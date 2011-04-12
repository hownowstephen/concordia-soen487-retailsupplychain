// Helper function, finds the size of a JSON object
function size(obj){
    var size = 0;
    var key;
    for (key in obj) {
        if (obj.hasOwnProperty(key)) size++;
    }
    return size;
}

    //chk if an object is an array or not.
function isArray(obj) {
//returns true is it is an array
if (obj.constructor.toString().indexOf("Array") == -1)
return false;
else
return true;
}

// Helper function generates a unique id
function createUUID() {
    // http://www.ietf.org/rfc/rfc4122.txt
    var s = [];
    var hexDigits = "0123456789ABCDEF";
    for (var i = 0; i < 32; i++) {
        s[i] = hexDigits.substr(Math.floor(Math.random() * 0x10), 1);
    }
    s[12] = "4";  // bits 12-15 of the time_hi_and_version field to 0010
    s[16] = hexDigits.substr((s[16] & 0x3) | 0x8, 1);  // bits 6-7 of the clock_seq_hi_and_reserved to 01

    var uuid = s.join("");
    return uuid;
}

function hideSubmit(){
    $("#submit_in_progress").css("display","block");
    $("#submitbtn").css("display","none");
}
function displaySubmit(){
    $("#submitbtn").css("display","block");
    $("#submit_in_progress").css("display","none");
}

$(document).ready(function(){
    $("#orderForm").submit(function(evt){
        hideSubmit();
        var ns2 = new SOAPObject("ns2:submitOrder");
        ns2.attr("xmlns:ns2","http://retail.supplychain.soen487.org/");

        // Generate the items to send
        var itemlist = new SOAPObject("itemList");
        if(size(cart) > 0){
            for(c in cart){
                var catalogItem = catalog[c];
                var item = new SOAPObject("items");
                item.child("manufacturerName",catalogItem['manufacturer']);
                item.child("productName",catalogItem['name']);
                item.child("productType",catalogItem['type']);
                item.child("quantity",cart[c]);
                item.child("unitPrice",catalogItem['cost']);
                itemlist.appendChild(item);
            }
        }else{
            // Can't submit with an empty cart'
            $.fancybox({content:"Error: Cart is empty"});
            displaySubmit();
            return false;
        }

        // validate data

        errors = [];

        var customerName = $("input[name='name']",form).val()
        var country = $("input[name='country']",form).val();
        var state = $("input[name='state']",form).val();
        var street1 = $("input[name='addr1']",form).val();
        var street2 = $("input[name='addr2']",form).val();

        var email1 = $("input[name='email']",form).val();
        var email2 = $("input[name='email2']",form).val();

        if(!customerName) errors.push("Please insert your name");
        if(!country) errors.push("Please insert your country");
        if(!state) errors.push("Please input your state/province");
        if(!street1) errors.push("Please insert a valid address");
        if(!email1) errors.push("Please insert your email address");
        if(email1 != email2) errors.push("Please insert the same email in both fields");
        
        if(errors.length > 0){
            out = "<h3>Error! Please resolve the following:</h3><ol>";
            for(var e in errors){
                out += "<li>" + errors[e] + "</li>";
            }
            out += "</ol>";
            $.fancybox({content: out});
            displaySubmit();
            return false;
        }

        var customerID=createUUID();
        
        var custinfo = new SOAPObject("custInfo");

        var form = $("#orderForm");

        // Generate the customer info
        custinfo.child("country",country);
        custinfo.child("customerReferenceNumber",customerID);
        custinfo.child("name",customerName);
        custinfo.child("state",state);
        custinfo.child("street1",street1);
        custinfo.child("street2",street2);

        ns2.appendChild(itemlist);
        ns2.appendChild(custinfo);

        var request = new SOAPRequest("http://retail.supplychain.soen487.org/Retail/submitOrderRequest",ns2);

        console.log(request.toString());

        SOAPClient.Proxy = "/RetailWebService/RetailService";
        SOAPClient.SendRequest(request,recv);



        evt.preventDefault();
    });
});

function recv(json){

    var results = json.Body.submitOrderResponse['return'].items;

    var out = "<h2>Your order has been processed successfully!</h2>";
    out += "<p>Please review the details below and contact us at info@XYZ.com if there is anything amiss!" +
        "<br />Thank you for choosing XYZ!</p>"
    out += "<table>" +
          "<tr><td>Product</td><td># Requested</td><td># Shipped</td><td># On Order</td></tr>";
    if(isArray(results)){
        for(var r in results){
            var item = results[r].item;
            var res = results[r];
            out += "<tr><td>" + item.productName +
                   "</td><td>" + item.quantity +
                   "</td><td>" + res.shipped +
                   "</td><td>" + res.not_shipped + "</td></tr>"
        }
    }else{
        var item = results.item;
        var res = results;
         out += "<tr><td>" + item.productName +
                   "</td><td>" + item.quantity +
                   "</td><td>" + res.shipped +
                   "</td><td>" + res.not_shipped + "</td></tr>"
    }
    var form = $("#orderForm");
    // Clear form
    $("input[name='name']",form).val('')
    $("input[name='country']",form).val('');
    $("input[name='state']",form).val('');
    $("input[name='addr1']",form).val('');
    $("input[name='addr2']",form).val('');
    $("input[name='email']",form).val('');
    $("input[name='email2']",form).val('');

    displaySubmit();

    $.fancybox({content: out});

}