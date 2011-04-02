
// Testing sleep function
function sleep(milliseconds) {
  var start = new Date().getTime();
  for (var i = 0; i < 1e7; i++) {
    if ((new Date().getTime() - start) > milliseconds){
      break;
    }
  }
}

$(document).ready(function(){
    $("#orderForm").submit(function(evt){
        $.fancybox({content: "Submitting your order...<br />\n\
                              <p class='centered'>\n\
                                 <img class='centered' src='img/ajax-loader.gif' alt='loading...' />\n\
                              </p>" });
        evt.preventDefault();
    });
});