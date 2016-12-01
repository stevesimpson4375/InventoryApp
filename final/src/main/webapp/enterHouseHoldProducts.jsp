<%@ page import="com.*"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <%request.setAttribute("typeStrings", HouseHoldProduct.getValidTypes());%>

        <title>Enter Household Product</title>
    </head>
    <body>
        <h3>Enter Household Product</h3>
        <form action="/enterProduct" method="post">
            <div>Description <input type="text" name="description"/></div>
            <div>Price <input type="text" name="price"/></div>
            <div>Purchase Date <input type="text" name="purchaseDate"/></div>
            <div>Type of Product
            <select name="type">
                <c:forEach var="i" items="${typeStrings}">
                    <option value="${i}">${i}</option>
                </c:forEach></div>
            </select> 
            <div><input type="submit" value="Save HouseHold Item"</div>
        </form>
        <%
            String productName = request.getParameter("productName");
            if (productName != null) {
                pageContext.setAttribute("productName", productName);
        %>
        <p>${fn:escapeXml(productName)} has been saved</p>
        <%
            }
        %>
    </body>
</html>
