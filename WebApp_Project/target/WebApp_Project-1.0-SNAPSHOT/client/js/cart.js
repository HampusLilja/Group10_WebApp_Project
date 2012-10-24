$(document).ready(function() {

var total_items = 0;	
var totalprice = 0;
var totalitemsdisplay = $("#totalitems");
var totalpricedisplay = $("#totalprice");
var emptyText = $('.cart-content').find('.placeholder');
var emptyBtn = $('.emptybutton').button();
var buyBtn = $('.buybutton').button();
var quantity = 1;

//Plugin to make the cart follow page
$('#cart').jfollow('#cart', 20);

        
	//Shopping cart functionality
	//Hide the empty cart button
	emptyBtn.hide();
        buyBtn.hide();
	
	$('.product').draggable({
		appendTo: 'body',
		helper: 'clone'		
	});
	$('.dropzone').droppable({
		tolerance: 'touch',
		activeClass: 'ui-state-default',
		hoverClass: 'dropzone-hover',
		accept: '.product',
		drop: function(event, ui){
			

                        var item = $(ui.draggable).find('.product-title').text();
			var itemid = $(ui.draggable).find('.id').text();
			var price = $(ui.draggable).find('.price').text();
                        var html = '<div class="cart-item" data-productid="'+itemid+'" >';
				html = html + '<div class="div-remove">';
				html = html + '<a onclick = "remove(this)" class="remove '+itemid+'">&times;</a>'+'</div>';
				html = html + '<p class="div-remove-text">'+item+'  </p>';
                                html = html + '<p class="div-remove-text">'+price+'</p>';
                                html = html + '<input type="text" class="div-remove-form" maxlength="2" name="quantity" value="'+quantity+'" />';
				html = html + '</p>'+'</div>';
			
			var cartitem = $('".cart-item[data-productid="'+itemid+'"]"');
			
			if(cartitem.length > 0){
				var int = parseInt(cartitem.find('input').val());
				int ++;
				cartitem.find('input').val(int);	
			}else{
				var content = $('.cart-content');
				content.append(html);
				emptyText.hide();
			}			
			//update the total items
			total_items++;
            // update total price
            price = parseInt(ui.draggable.find(".price").html().replace("$ ", ""));
            totalprice = totalprice + price;
            totalpricedisplay.html("Total price:  " + totalprice + "$");
            totalitemsdisplay.html("Total items: " + total_items);
                        if(total_items > 0){
				emptyBtn.fadeIn('1000');
                                buyBtn.fadeIn('1000');
                                totalitemsdisplay.fadeIn('1000');
                                totalpricedisplay.fadeIn('1000');
			}		
                        
			emptyBtn.click(function(){
                           
				$('#dialog-confirm').dialog({
                                    
					resizable: false,
					modal: true,
					buttons: [	{
                                                
                                                                text: "Cancel",
                                                                className: 'emptybutton',
                                                                click: function(){
                                                                $(this).dialog('close');}
                                                                },
								{	
								text: "Clear!",
                                                                className: 'emptybutton',
								click: function(){
									var content = $('.cart-item');
									content.remove();
									$('cart-content').find('.placeholder').show();
									$(this).dialog('close');
									emptyBtn.fadeOut('500');
									emptyText.fadeIn('500');
                                                                        buyBtn.fadeOut('500');
                                                                        totalitemsdisplay.fadeOut('500');
                                                                        totalpricedisplay.fadeOut('500');
                                                                }
								}
							]					
				})
                                $("#dialog-confirm").siblings(".ui-dialog-titlebar").remove();
				return false;
			});
                        buyBtn.click(function(){ window.location = 'index.xhtml'});
                        
		} //end drop function
	});

}); //end document ready

    function remove(el) {
        $(el).hide();
        
        $(el).parent().parent().fadeOut('1000');
        setTimeout(function() {
            $(el).parent().parent().remove();
        }, 1100);

        // update total items and total price
        total_items--;
        totalitemsdisplay.html("Total items: " + total_items);
                
        price = parseInt($(el).parent().parent().find(".price").html().replace("$ ", ""));
        totalprice = totalprice - price;
        totalpricedisplay.html(totalprice);
                        if( total_items == 0){
			
                        emptyText.delay('1000').fadeIn('500');
                        emptyBtn.fadeOut('500');
                        buyBtn.fadeOut('500');
                        totalitemsdisplay.fadeOut('500');
                        totalpricedisplay.fadeOut('500');
               			}
  	}
