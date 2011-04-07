// Helper function, finds the size of a JSON object
function size(obj){
    var size = 0;
    var key;
    for (key in obj) {
        if (obj.hasOwnProperty(key)) size++;
    }
    return size;
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

$(document).ready(function(){
    $("#orderForm").submit(function(evt){
       // $.fancybox({content: "Submitting your order...<br />\n\
       //                       <p class='centered'>\n\
       //                          <img class='centered' src='img/ajax-loader.gif' alt='loading...' />\n\
       //                       </p>" });
        var ns2 = new SOAPObject("ns2:submitOrder");
        ns2.attr("xmlns:ns2","http://retail.supplychain.soen487.org/");
        
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
            alert("Cart is empty");
        }

        var customerID=createUUID();
        
        var custinfo = new SOAPObject("custInfo");

        var form = $("#orderForm");

        custinfo.child("country",$("input[name='country']",form).val());
        custinfo.child("customerReferenceNumber",customerID);
        custinfo.child("name",$("input[name='name']",form).val());
        custinfo.child("state",$("input[name='state']",form).val());
        custinfo.child("street1",$("input[name='addr1']",form).val());
        custinfo.child("street2",$("input[name='addr2']",form).val());

        ns2.appendChild(itemlist);
        ns2.appendChild(custinfo);

        var request = new SOAPRequest("http://retail.supplychain.soen487.org/Retail/submitOrderRequest",ns2);

        SOAPClient.Proxy = "/RetailWebService/RetailService";
        SOAPClient.SendRequest(request,recv);


        evt.preventDefault();
    });
});

function recv(json){
    console.log(json);
}