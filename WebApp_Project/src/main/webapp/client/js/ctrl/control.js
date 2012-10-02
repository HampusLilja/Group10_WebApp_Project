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

var proxy = new MemberResourceProxy("http://localhost:8080/WebApp_Project/rs/members");
    var selectedMember;
    var table;
    
    return {
        init: function(){ 
            table = new Table(["PersonNumber", "Name"]); 
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
                deferred.done(function(members){
                    table.clear();
                    table.addRows(members);
                    table.render(); 
                }); 
                deferred.fail(function(){
                    alert("Failed")
                });
            } else if( this.id === "btnDel"){
                if( ! selectedMember){
                    return;
                }
                deferred = proxy.remove(selectedMember.pnumb);
                deferred.done(function(){
                    selectedMember = null;
                    alert("Done");
                });
                deferred.fail(function(xhr){
                    alert("Fail" + xhr.status);
                });
            }
        }, 
        
        tableListener: function( member ){
            selectedMember = member;
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
