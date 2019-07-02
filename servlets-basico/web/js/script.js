$(document).ready(function(){

    $("#boton1").click(function(){
        
        $("#boton3").hide();
    })
    $("#boton2").click(function(){
        $("#boton1").addClass("btn-warning")
    })

    $("tr:even").hover(function(){
        $(this).css("cursor","pointer");
    })

    $("li:first").html("Holas")

    $("#boton4").click(function(){
        
        alert($("#user").val())
    })
})



