$(document).ready(function(){    
    $("input[name='Price']").blur(function(){
        if( $("input[name='Price']").val() !== "" && !$.isNumeric($("input[name='Price']").val())){
            $("td[name='Price']").removeClass("hidden").addClass("red");
        }
        else{
            $("td[name='Price']").addClass("hidden");
        }
    });
    $("input[name='Amount']").blur(function(){
        if($("input[name='Amount']").val() !== "" && !$.isNumeric($("input[name='Amount']").val())){
            $("td[name='Amount']").removeClass("hidden").addClass("red");
        }
        else{
            $("td[name='Amount']").addClass("hidden");
        }
    });
});