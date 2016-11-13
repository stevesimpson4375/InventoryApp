<%-- 
    Document   : enterFood
    Created on : Nov 12, 2016, 7:35:15 PM
    Author     : steve
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Food Page</title>
    </head>
    <body>
        <h3>Enter Food</h3>
        <form action="/enterFood" method="post">
            <div>Description <input type="text" name="foodDescription"/></div>
            <div>Price <input type="text" name="foodPrice"/></div>
            <div>Purchase Date <input type="text" name="purchaseDate"/></div>
            <div>Expiration Date<input type="text" name="expireDate"/></div>
            <div><input type="submit" value="Save Food"</div>
        </form>

        <%
            String foodName = request.getParameter("foodName");
            if (foodName != null) {
                pageContext.setAttribute("foodName", foodName);
        %>
        <p>${c:escapeXml(foodName)} has been saved</p>
        <%
            }
        %>

    </body>
</html>
