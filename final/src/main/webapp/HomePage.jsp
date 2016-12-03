<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inventory Home Page</title>
    </head>
    <body>
        <h2>Welcome to my inventory tracking App!</h2>

        <button id="foodButton">Enter Food</button>
        <button id="houseHoldProductsButton">Enter Household Item</button>
        <button id="applianceButton">Enter Appliance</button>
        <button id="searchButton">Search Data</button>
        <script type="text/javascript">
            document.getElementById("foodButton").onclick = function(){
                location.href = "/enterFoodPage.jsp";
            };
            document.getElementById("houseHoldProductsButton").onclick = function(){
                location.href = "/enterHouseHoldProducts.jsp";
            };
            document.getElementById("applianceButton").onclick = function(){
                location.href = "/enterAppliance.jsp";
            };
            document.getElementById("searchButton").onclick = function(){
                location.href = "/searchPage.jsp";
            };
        </script>
    </body>
</html>
