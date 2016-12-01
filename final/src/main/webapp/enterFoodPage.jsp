<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
            <div>Expiration Date <input type="text" name="expireDate"/></div>
            <div>Amount <input type="text" name="amountOfFood"</div>
            <div>Amount Type <input type="text" name="amountType"</div>
            <div><input type="submit" value="Save Food"</div>
        </form>

        <%
            String foodName = request.getParameter("foodName");
            if (foodName != null) {
                pageContext.setAttribute("foodName", foodName);
        %>
        <p>${fn:escapeXml(foodName)} has been saved</p>
        <%
            }
        %>

    </body>
</html>
