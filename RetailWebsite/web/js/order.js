$(document).ready(function(){
    $("#orderForm").submit(function(evt){
       // $.fancybox({content: "Submitting your order...<br />\n\
       //                       <p class='centered'>\n\
       //                          <img class='centered' src='img/ajax-loader.gif' alt='loading...' />\n\
       //                       </p>" });
        var ns2 = new SOAPObject("ns2:submitOrder");
        ns2.attr("xmlns:ns2","http://retail.supplychain.soen487.org/");

        var itemlist = new SOAPObject("itemList");
        var item = new SOAPObject("items");
        item.child("manufacturerName","Brand1");
        item.child("productName","Brand1TV");
        item.child("productType","TV");
        item.child("quantity","5");
        item.child("unitPrice","1500.0");
        itemlist.appendChild(item);
        
        var custinfo = new SOAPObject("custInfo");
        custinfo.child("country","canada");
        custinfo.child("customerReferenceNumber","12345");
        custinfo.child("name","Stephen");
        custinfo.child("state","Montreal");
        custinfo.child("street1","1234");
        custinfo.child("street2","fakeStreet");

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