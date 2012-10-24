var WishResourceProxy = function( baseUri ){
    this.baseUri = baseUri;
}

WishResourceProxy.prototype = (function (){ 
  
    return {
        find: function( anumb ){
            return $.getJSON(this.baseUri + "/" + anumb); 
        },
        
        getAll: function() {
            return $.getJSON(this.baseUri);
        },
        
        add: function( wish ){
            return $.ajax({
                type: 'POST',
                url: this.baseUri,
                data: wish   
            }); 
        },
        
        update: function ( wish ){  
        },
        
        send: function ( anumb ){
            return $.ajax({
                type: '',
                url: this.baseUri + "/" + anumb
            });
        },
        
        remove: function ( anumb ){    
            return $.ajax({
                type: 'DELETE',
                url: this.baseUri + "/" + anumb
            });
        }  
    }     
}());