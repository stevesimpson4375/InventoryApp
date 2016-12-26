$(document).ready(function(){
    var $inputPrice = $("input[id='Price']");
    var $tdPrice = $("td[name='Price']");
    $inputPrice.keyup(function(){
        if($inputPrice.val() !== "" && !$.isNumeric($inputPrice.val())){
            $tdPrice.removeClass("hidden").addClass("red");
        }
        else{
            $tdPrice.addClass("hidden");
        }
    });
    
    var $inputAmount = $("input[id='Amount']");
    var $tdAmount = $("td[name='Amount']");
    $inputAmount.keyup(function(){
        if($inputAmount.val() !== "" && !$.isNumeric($inputAmount.val())){
            $tdAmount.removeClass("hidden").addClass("red");
        }
        else{
            $tdAmount.addClass("hidden");
        }
    });
    
    var $inputWeight = $("input[id='Weight (in kg)']");
    var $tdWeight = $("td[name='Weight (in kg)']");
    $inputWeight.keyup(function(){
        if($inputWeight.val() !== "" && !$.isNumeric($inputWeight.val())){
            $tdWeight.removeClass("hidden").addClass("red");
        }
        else{
            $tdWeight.addClass("hidden");
        }
    });
});
