<!DOCTYPE html>
<%@page import="com.Util"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
        <title>All Records</title>
        <%
            ArrayList<String> items = Util.datastore.retrieveDescriptions();
            request.setAttribute("items", items);
        %>
    </head>
    <body>
        <div id="container">
            <h:backToHomePage></h:backToHomePage>
                <h2 class="header">All records are shown below</h2>
                <div class="survey">
                    <table class="hydQuestion">
                    <c:forEach var="i" items="${items}">
                        <tr><td><p>${fn:escapeXml(i)}</p></td></tr>
                    </c:forEach>
                </table>
                <c:choose>
                    <c:when test="${fn:length(items) == 0}">
                        <p>Database is empty!</p>
                    </c:when>
                </c:choose>
            </div>
            <h:backToHomePage></h:backToHomePage>
        </div>
    </body>
</html>
