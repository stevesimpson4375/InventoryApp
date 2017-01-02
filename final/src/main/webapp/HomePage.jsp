<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
        <title>Inventory Home Page</title>
    </head>
    <body>
        <div id="container">
            <h2 class="header">Welcome to my inventory tracking App!</h2>
            <br />
            <h3 class="header">Select What you want to do using the buttons below</h3>
            <br />
            <div class="survey">
                <table class="hydQuestion">
                    <tr>
                        <td><button id="foodButton">Enter Food</button></td>
                        <td><button id="houseHoldProductsButton">Enter Household Item</button></td>
                        <td><button id="applianceButton">Enter Appliance</button></td>
                        <td><button id="searchButton">Search Data</button></td>
                        <td><button id="showAllButton">See Everything You Have</button>
                    </tr>
                </table>
            </div>
            <br />
            <script type="text/javascript">
                document.getElementById("foodButton").onclick = function(){
                    location.href = "/enterFoodPage.jsp";
                };
                document.getElementById("houseHoldProductsButton").onclick = function(){
                    location.href = "/enterHouseHoldProductsPage.jsp";
                };
                document.getElementById("applianceButton").onclick = function(){
                    location.href = "/enterAppliancePage.jsp";
                };
                document.getElementById("searchButton").onclick = function(){
                    location.href = "/searchPage.jsp";
                };
                document.getElementById("showAllButton").onclick = function(){
                    location.href = "/showAll.jsp";
                };
            </script>
        </div>
    </body>
</html>
