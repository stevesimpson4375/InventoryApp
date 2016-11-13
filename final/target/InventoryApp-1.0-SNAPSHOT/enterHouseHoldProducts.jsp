<%-- 
    Document   : enterHouseHoldProducts
    Created on : Nov 12, 2016, 11:43:55 PM
    Author     : steve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Household Product</title>
    </head>
    <body>
        <h3>Enter Household Product</h3>
        <h3>Enter Food</h3>
        <form action="/enterFood" method="post">
            <div>Description <input type="text" name="foodDescription"/></div>
            <div>Price <input type="text" name="foodPrice"/></div>
            <div>Purchase Date <input type="text" name="purchaseDate"/></div>
            <div>Expiration Date<input type="text" name="expireDate"/></div>
            <div><input type="submit" value="Save Food"</div>
        </form>
    </body>
</html>
