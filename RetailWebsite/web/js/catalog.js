
// Initialize some values
var cart = {};
var catalog = {"1000":{"name":"Television",
                       "cost":500,
                       "manufacturer": "Manufacturer",
                       "type": "TV",
                       "image":"http://t2.gstatic.com/images?q=tbn:ANd9GcQRiz6FXjhFkL3wUDAE_GAhxCV3kpusboDZj6ypnZejLMW_Ktrjiw"},
               "1001":{"name":"Stereo",
                        "cost":10,
                        "manufacturer": "Manufacturer",
                        "type": "Stereo",
                        "image":"http://visual.merriam-webster.com/images/communications/communications/mini-stereo-sound-system.jpg"},
               "1002":{"name":"Cell Phone",
                       "cost":500,
                       "manufacturer": "Manufacturer",
                       "type": "Phone",
                       "image":"http://handies.phandroid.com/media/htc-legend-1284383469-222.jpg"}
              };
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
           sc.append('<tr rel="'+ id +'" class="cart-entry"><td>' + item.name + '</td><td><input type="text" name="count" value="1" /></td></tr>');
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

function loadCatalog(){
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

function refreshCart(){

}