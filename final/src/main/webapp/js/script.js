$(document).ready(function () {
    var $inputPrice = $("input[id='Price']");
    var $tdPrice = $("td[name='Price']");
    $inputPrice.keyup(function () {
        if ($inputPrice.val() !== "" && !$.isNumeric($inputPrice.val())) {
            $tdPrice.removeClass("hidden").addClass("red");
        } else {
            $tdPrice.addClass("hidden").removeClass("red");
        }
    });

    var $inputAmount = $("input[id='Amount']");
    var $tdAmount = $("td[name='Amount']");
    $inputAmount.keyup(function () {
        if ($inputAmount.val() !== "" && !$.isNumeric($inputAmount.val())) {
            $tdAmount.removeClass("hidden").addClass("red");
        } else {
            $tdAmount.addClass("hidden").removeClass("red");
        }
    });

    var $inputWeight = $("input[id='Weight (in kg)']");
    var $tdWeight = $("td[name='Weight (in kg)']");
    $inputWeight.keyup(function () {
        if ($inputWeight.val() !== "" && !$.isNumeric($inputWeight.val())) {
            $tdWeight.removeClass("hidden").addClass("red");
        } else {
            $tdWeight.addClass("hidden").removeClass("red");
        }
    });

/* The following checks that the forms have usable values before submitting */
    $(".createButton").click(function (event) {
        
        if (!$.isNumeric($("input[id='Price']").val())) {
            event.preventDefault();
        }
    /*Not all forms have the following, so they are checked for before testing*/    
        if ($("input[id='Amount']").length) {
            if (!$.isNumeric($("input[id='Amount']").val())) {
                event.preventDefault();
            }
        }
        
        if ($("input[id='Weight (in kg)']").length) {
            if (!$.isNumeric($("input[id='Weight (in kg)']").val())) {
                event.preventDefault();
            }
        }
    });
});
