<!DOCTYPE html>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

        <title>Enter Food Page</title>
    </head>

    <%
        pageContext.setAttribute("fields", Food.getFields());
        pageContext.setAttribute("examples", Util.getExampleFoods());
    %>

    <body>
        <div id="container">
            <h:backToHomePage></h:backToHomePage>
            <h3 class="header">Enter Food</h3>
            <br />
            <h:selectExample examples="${examples}"></h:selectExample>
            <br />
            <div class="survey">
                <form action="/enterFood" method="post">
                    <table class="hydQuestion">
                        <c:forEach var="attr" items="${fields}">
                            <h:enterField field="${attr}"></h:enterField>
                        </c:forEach>
                        <tr>
                            <td></td><td><input type="submit" value="Save Food" class="createButton"></td>
                        </tr>
                    </table>
                </form>
            </div> 
            <%
                String foodName = request.getParameter("foodName");
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