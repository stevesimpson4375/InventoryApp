$(document).ready(function () {

    $(".datepicker").datepicker();

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

    $(".searchButton").click(function (event) {
        if (!$.isNumeric($("input[id='Price']").val())) {
            event.preventDefault();
        }
    });

    /* The following checks for changes to the food examples and calls the matching method */
    $(".selectExample").change(function () {
        if ($(".selectExample").val() === "Apples") {
            selectApples();
        }
    });
    
    $(".selectExample").change(function () {
        if ($(".selectExample").val() === "Bacon") {
            selectBacon();
        }
    });

    $(".selectExample").change(function () {
        if ($(".selectExample").val() === "Cheese") {
            selectCheese();
        }
    });
           
    $(".selectExample").change(function () {
        if ($(".selectExample").val() === "Red Baron Pizza, Pepperoni") {
            selectRedBaron();
        }
    });
    
    /* The following changes the input text to the predefined input values */
    function selectCheese() {

        $("input[id='Description']").val("Cheese");
        $("input[id='Price']").val("4.00");
        $("input[id='Purchase Date']").val(getDateString());
        $("input[id='Expiration Date']").val(getDateStringAdded(180));
        $("input[id='Amount']").val("8");
        $("input[id='Amount Type']").val("Ounces");
    }
    
    function selectApples() {

        $("input[id='Description']").val("Apples");
        $("input[id='Price']").val("1.99");
        $("input[id='Purchase Date']").val(getDateString());
        $("input[id='Expiration Date']").val(getDateStringAdded(10));
        $("input[id='Amount']").val("3");
        $("input[id='Amount Type']").val("Pounds");
    }
    
     function selectBacon() {

        $("input[id='Description']").val("Bacon");
        $("input[id='Price']").val("2.99");
        $("input[id='Purchase Date']").val(getDateString());
        $("input[id='Expiration Date']").val(getDateStringAdded(28));
        $("input[id='Amount']").val("1");
        $("input[id='Amount Type']").val("Pounds");
    }
    
     function selectRedBaron() {

        $("input[id='Description']").val("Red Baron Pizza, Pepperoni");
        $("input[id='Price']").val("3.49");
        $("input[id='Purchase Date']").val(getDateString());
        $("input[id='Expiration Date']").val(getDateStringAdded(90));
        $("input[id='Amount']").val("1");
        $("input[id='Amount Type']").val("Unit");
    }  

    /* The following checks for changes to the aapliance examples and calls the matching method */
    $(".selectExample").change(function () {
        if ($(".selectExample").val() === "Farberware Oil-Less Fryer") {
            selectAirFryer();
        }
    });
    
    $(".selectExample").change(function () {
        if ($(".selectExample").val() === "Bread Machine") {
            selectBreadMachine();
        }
    });
    
    $(".selectExample").change(function () {
        if ($(".selectExample").val() === "Coffee Maker") {
            selectCoffeeMaker();
        }
    });
    
    /* The following changes the input text to the predefined input values */
    function selectAirFryer() {

        $("input[id='Description']").val("Farberware Oil-Less Fryer");
        $("input[id='Price']").val("79.99");
        $("input[id='Purchase Date']").val(getDateString());
        $("input[id='Material']").val("Plastic and Metal");
        $("input[id='Weight (in kg)']").val("5");
        $("select[name='Type of Product']").val("Air Fryer");
    }
    
    /* The following checks for changes to the household product examples and calls the matching method */
    $(".selectExample").change(function () {
        if ($(".selectExample").val() === "Ultra Palmolive Original") {
            selectDishSoap();
        }
    });
    
    /* The following changes the input text to the predefined input values */
    function selectDishSoap() {

        $("input[id='Description']").val("Ultra Palmolive Original");
        $("input[id='Price']").val("1.83");
        $("input[id='Purchase Date']").val(getDateString());
        $("input[id='Amount']").val("24");
        $("input[id='Amount Type']").val("Ounces");
        $("select[name='Type of Product']").val("Dish Soap");
    }

    function getDateString() {
        var now = new Date();
        var day = ("0" + now.getDate()).slice(-2);
        var month = ("0" + (now.getMonth() + 1)).slice(-2);
        return (month) + "/" + (day) + "/" + now.getFullYear();
    }

    function getDateStringAdded(addedDays) {
        var now = new Date();
        now.setDate(now.getDate() + addedDays);
        var day = ("0" + now.getDate()).slice(-2);
        var month = ("0" + (now.getMonth() + 1)).slice(-2);
        return (month) + "/" + (day) + "/" + now.getFullYear();
    }
});