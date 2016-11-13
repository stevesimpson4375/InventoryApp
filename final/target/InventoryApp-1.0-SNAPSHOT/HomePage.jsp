<%-- 
    Document   : HomePage
    Created on : Nov 12, 2016, 7:59:06 PM
    Author     : steve
--%>

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
        <button id="houseHoldProductsButton">Enter House Hold Item></button>
        <script type="text/javascript">
            document.getElementById("foodButton").onclick = function(){
                location.href = "/enterFoodPage.jsp";
            };
            document.getElementById("houseHoldProductsButton").onclick = function(){
                location.href = "/enterHouseHoldProductsPage";
            };
        </script>
    </body>
</html>
