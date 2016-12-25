<!DOCTYPE html>
<%@ page import="com.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
        <title>Search Results: Price</title>
        
    </head>
    <body>
        <div id="container">
            <h:backToHomePage></h:backToHomePage>

                <div class="survey">
                    <form action="/DeleteByIdServlet" method="post">
                        <table class="hydQuestion">
                        <c:forEach var="i" items="${results}" varStatus="loop">
                            <tr><td>${fn:escapeXml(i)}</td><td><button type="submit" name="selected" 
                                value="${ids[loop.index]}">Delete</button></td></tr>
                                    </c:forEach>
                            <input type="hidden" name="searchedBy" value="${searchedBy}" />
                            <input type="hidden" name="searchValue" value="${searchValue}" />
                    </table>
                </form>
                <c:choose>
                    <c:when test="${fn:length(results) == 0}">
                        <p>Search returned no results!</p>
                    </c:when>
                </c:choose>
            </div>

            <h:backToHomePage></h:backToHomePage>
        </div>
    </body>
</html>
