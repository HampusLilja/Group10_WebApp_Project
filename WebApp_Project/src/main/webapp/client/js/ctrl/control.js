$(document).ready(function(){
    $('#btnList').on('click', control.menuListener);
    $('#btnAdd').on('click', control.menuListener);
    $('#btnDel').on('click', control.menuListener);
    control.init();
})

{
    var table;
}
 
var control = (function (){

var proxy = new WishResourceProxy("http://localhost:8080/WebApp_Project/rs/wish");
    var selectedWish;
    var table;
    
    return {
        init: function(){ 
            table = new Table(["ArticleNumber", "Name", "Size"]); 
            table.addHandler(control.tableListener);
            table.setParent('#pageSection'); 
        },
        
        menuListener: function(){
            var deferred;
            if( this.id === "btnAdd"){
                var d = new Dialog();
                d.addHandler(control.dialogListener);
                d.setParent("#dialog");
                d.render();
            }else if( this.id === "btnList"){
                deferred = proxy.getAll();
                deferred.done(function(wish){
                    table.clear();
                    table.addRows(wish);
                    table.render(); 
                }); 
                deferred.fail(function(){
                    alert("Failed")
                });
            }else if( this.id === "btnSend"){
                if( ! selectedWish){
                    return;
                }
                deferred = proxy.send(selectedWish.anumb);
                deferred.done(function(){
                                      selectedWish = null;
                    alert("Done");
                });
                deferred.fail(function(xhr){
                    alert("Fail" + xhr.status);
                });
                
            } 
            
            else if( this.id === "btnDel"){
                if( ! selectedWish){
                    return;
                }
                deferred = proxy.remove(selectedWish.anumb);
                deferred.done(function(){
                    selectedWish = null;
                    alert("Done");
                });
                deferred.fail(function(xhr){
                    alert("Fail" + xhr.status);
                });
            }
        }, 
        
        tableListener: function( wish ){
            selectedWish = wish;
        },
        
        dialogListener: function(action, data ){
            var deferred;
            if( action === "save"){  // Always = = = (3)
                deferred = proxy.add(data);
                deferred.done(function(){
                    alert("Done");
                });
                deferred.fail(function(){
                    alert("Fail");
                });
            }
        }
        
    }       
}()); 
