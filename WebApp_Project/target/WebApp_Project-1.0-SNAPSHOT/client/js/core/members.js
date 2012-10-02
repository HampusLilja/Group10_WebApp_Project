var MemberResourceProxy = function( baseUri ){
    this.baseUri = baseUri;
}

MemberResourceProxy.prototype = (function (){ 
  
    return {
        find: function( pnumb ){
            return $.getJSON(this.baseUri + "/" + pnumb); 
        },
        
        getAll: function() {
            return $.getJSON(this.baseUri);
        },
        
        add: function( member ){
            return $.ajax({
                type: 'POST',
                url: this.baseUri,
                data: member   
            }); 
        },
        
        update: function ( member ){  
        },
        
        remove: function ( pnumb ){    
            return $.ajax({
                type: 'DELETE',
                url: this.baseUri + "/" + pnumb
            });
        }  
    }     
}());