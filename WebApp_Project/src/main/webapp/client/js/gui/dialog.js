var Dialog = function(member, pnumb){
    this.member = member;
    if( pnumb ){
        this.pnumb = pnumb;
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
           
        render: function(){
            if( ! this.parent ){
                throw "No parent defined";
            }
           
            var html = this.toHtml();

            $(this.parent).html(html);
            
            var self = this; 
            
            $(this.parent).find("#save")  
            .on('click', function(){
                var member = {};
                member.pnumb =  $(self.parent).find("#pnumb").val();
                member.name = $(self.parent).find("#name").val();
                
                if( self.handler ){
                    self.handler( "save", member ) // if defined!
                }
                $(self.parent).html("");  
            }); 
            $(this.parent).find( "#cancel").click(function(){
                $(self.parent).html("");
            });
            $(this.parent).find( "#del").click(function(){
                var member = {};
                member.pnumb =  $(self.parent).find("#pnumb").val();
                member.name = $(self.parent).find("#name").val();
                self.handler( "del", member );
                $(self.parent).html("");
            });
        },
        
        toHtml : function(){
            var member = this.member || {
                pnumb:"", 
                name:""
            };
        
            var html;
            if( this.id ){
                html = "<div pnumb='"+ this.pnumb +"' class='"+ CLASS + "'>"; 
            }else{
                html = "<div class='"+ CLASS + "'>"; 
            }
            html += "<table>"  
            + "<tr><td><label for='pnumb'>PersonNumber</label></td><td>"
            + "<input id='pnumb' type='text' size='6' value='"+ member.pnumb + "'/></td></tr>" 
            + "<tr><td><label for='name'>Name</label></td><td>" 
            + "<input id='name' type='text' size='14' value='"+ member.name + "'/></td></tr>" 
            + "</table>"
            + "<input id='save' type='button' value='Save'/>" 
            + "<input id='cancel' type='button' value='Cancel'/>"
            + "</div>";
            return html;
        }
    }
})();


