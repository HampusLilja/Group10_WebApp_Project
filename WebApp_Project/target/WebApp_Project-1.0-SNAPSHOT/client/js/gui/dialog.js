var Dialog = function(wish, anumb){
    this.wish = wish;
    if( anumb ){
        this.anumb = anumb;
    }
}

Dialog.prototype = (function(){ 
     
    var CLASS = "dialog"; 
    
    return{
        addHandler: function( handler ){
            this.handler = handler;
        },
        
        setParent: function( selector ){
            this.parent = selector;  
        },
        
        sendMail: function(){
          html += "<form id='contactForm' action='mailto:herzog90@gmail.com?subject=contact' method='post' enctype='text/plain'>"  
            + "<input name='First name' id='firstname' required='true'/><br/>"
            + "</form>";  
        },
           
        render: function(){
            if( ! this.parent ){
                throw "No parent defined";
            }
           
            var html = this.toHtml();

            $(this.parent).html(html);
            
            var self = this; 
            
            $(this.parent).find("#save")  
            .on('click', function(){
                var wish = {};
                wish.anumb =  $(self.parent).find("#anumb").val();
                wish.name = $(self.parent).find("#name").val();
                wish.size = $(self.parent).find("#size").val();
                
                if( self.handler ){
                    self.handler( "save", wish ) // if defined!
                }
                $(self.parent).html("");  
            }); 
            $(this.parent).find( "#cancel").click(function(){
                $(self.parent).html("");
            });
            $(this.parent).find( "#del").click(function(){
                var wish = {};
                wish.anumb =  $(self.parent).find("#anumb").val();
                wish.name = $(self.parent).find("#name").val();
                wish.size = $(self.parent).find("#size").val();
                self.handler( "del", wish );
                $(self.parent).html("");
            });
        },
        
        toHtml : function(){
            var wish = this.wish || {
                anumb:"", 
                name:"",
                size:""
            };
        
            var html;
            if( this.id ){
                html = "<div anumb='"+ this.anumb +"' class='"+ CLASS + "'>"; 
            }else{
                html = "<div class='"+ CLASS + "'>"; 
            }
            html += "<table>"  
            + "<tr><td><label for='anumb'>ArticleNumber</label></td><td>"
            + "<input id='anumb' type='text' size='6' value='"+ wish.anumb + "'/></td></tr>" 
            + "<tr><td><label for='name'>Name</label></td><td>" 
            + "<input id='name' type='text' size='14' value='"+ wish.name + "'/></td></tr>"
            + "<tr><td><label for='name'>Size</label></td><td>" 
            + "<input id='size' type='text' size='14' value='"+ wish.size + "'/></td></tr>"
            + "</table>"
            + "<input id='save' type='button' value='Save'/>" 
            + "<input id='cancel' type='button' value='Cancel'/>"
            + "</div>";
            return html;
        }
    }
})();


