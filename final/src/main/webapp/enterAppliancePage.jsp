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
        <title>Enter Appliance</title>

        <%
            request.setAttribute("typeStrings", Appliance.getValidTypes());
            request.setAttribute("fields", Appliance.getFields());
        %>
    </head>
    <body>
        <div id="container">
            <h:backToHomePage></h:backToHomePage>
                <h3 class="header">Enter Appliance</h3>
                <div class="survey">
                    <form action="/CreateAndSaveAppliance" method="post">
                        <table class="hydQuestion">
                        <c:forEach var="attr" items="${fields}">
                            <h:enterField field="${attr}"></h:enterField>
                        </c:forEach>
                        <tr>
                            <td><label>Type of Product</label>
                                <select name="type">
                                    <c:forEach var="i" items="${typeStrings}">
                                        <option value="${i}">${i}</option>
                                    </c:forEach>
                                </select></td>
                        </tr>
                        <tr>
                            <td><input type="submit" value="Save Appliance"></td>
                        </tr>
                    </table>
                </form>
            </div>
            <%
                String applianceName = request.getParameter("applianceName");
                if (applianceName != null) {
                    pageContext.setAttribute("applianceName", applianceName);
            %>
            <p class="header">${fn:escapeXml(applianceName)} has been saved</p>
            <%
                }
            %>
            <h:backToHomePage></h:backToHomePage>
        </div>
    </body>
</html>