
// Initialize some values
var cart = {};
var catalog = {};
$(document).ready(function(){

    loadCatalog();
    checkEmptyCart();
    $(".catalog-item").live("click",function(){
        var id = $(this).attr('rel');
        var sc = $("#shopping-cart");
        var item = catalog[id];
        $("#empty").hide();
        if(!cart[id]){
           cart[id] = 1;
           sc.append('<tr rel="'+ id +'" class="cart-entry"><td>' + item.name + '</td><td><input type="text" name="count" value="1" style="width:50px;text-align:center;" /></td><td><button onclick="return removeCartItem(' + id + ');">Remove</button></td></tr>');
        }
        refreshCart();
    });
    $(".cart-entry").live("change",function(){
        cart[$(this).attr("rel")] = $("input[name=count]",this).val();
        console.log(cart);
    });
});

function checkEmptyCart(){
    var count = 0;
    for (var k in cart) {
        if (cart.hasOwnProperty(k)) {
           ++count;
        }
    }
    if(count == 0){
        $("#empty").show();
    }
    return count;
}

function removeCartItem(id){
    delete cart["" + id];
    $("tr[rel=" + id + "]").remove();
    return false;
}

function parseCatalog(data){
    var items = data.Body.getCatalogResponse['return'].product;
    var itemID = 1000;
    for(var i in items){
        var x = items[i];
        var man = x.manufacturerName;
        var type = x.productType;
        var cost = x.unitPrice;
        catalog[''+itemID] = {"name": man + '' + type,
                              "type": type,
                              "manufacturer": man,
                              "cost": cost,
                              "image": 'img/' + type + '.jpg'};
        itemID ++;
    }

    // @todo Logic for grabbing SOAP data from the WebService
    for(var i in catalog){
        var item = catalog[i];
        $("#catalog").append("<div rel='" + i + "' class='catalog-item'><div class='image'><img src='" + item.image + "'></div>" +
                                 "<h4>" + item.name + "</h4>" +
                                 "<ul class='details'>" +
                                    "<li>Price: " + item.cost + "</li>" +
                                 "</ul>" +
                             "</div>");
    }

}

function loadCatalog(){

     var ns2 = new SOAPObject("ns2:getCatalog");
        ns2.attr("xmlns:ns2","http://retail.supplychain.soen487.org/");

        var request = new SOAPRequest("http://retail.supplychain.soen487.org/Retail/submitOrderRequest",ns2);
        console.log(request.toString());
        SOAPClient.Proxy = "/RetailWebService/RetailService";
        SOAPClient.SendRequest(request,parseCatalog);
}

function refreshCart(){

}