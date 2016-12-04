<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ page import="java.util.ArrayList"%>
<%@ page import="com.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
        <title>Enter Food Page</title>
    </head>

    <%
        String[] fields = Food.getFields();
        pageContext.setAttribute("fields", fields);

    %>

    <body>
        <div id="container">
            <h:backToHomePage></h:backToHomePage>
                <h3 class="header">Enter Food</h3>
            <div class="survey">
                <form action="/enterFood" method="post">
                    <table class="hydQuestion">
                        <c:forEach var="attr" items="${fields}">
                            <h:enterField field="${attr}"></h:enterField>
                        </c:forEach>
                        <tr>
                            <td><input type="submit" value="Save Food"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <%String foodName = request.getParameter("foodName");
                if (foodName != null) {
                    pageContext.setAttribute("foodName", foodName);
            %>
            <br />
            <p class="header">${fn:escapeXml(foodName)} has been saved</p>
            <%
                }
            %>
            <h:backToHomePage></h:backToHomePage>
        </div>
    </body>
</html>
