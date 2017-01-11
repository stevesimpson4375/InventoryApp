<!DOCTYPE html>
<%@ page import="com.*"%>
<%@ page import="java.util.ArrayList"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
        <script type="text/javascript" src="js/sorttable.js"></script>
        <title>All Records</title>
        <%
            InventoryItem[] results = Util.datastore.retreiveAllArray();
            request.setAttribute("results", results);
        %>
    </head>
    <body>
        <div id="container">
            <h:backToHomePage></h:backToHomePage>
                <h2 class="header">All records are shown below</h2>
            <h:searchResult></h:searchResult>
            <c:choose>
                <c:when test="${fn:length(results) == 0}">
                    <p>Database is empty!</p>
                </c:when>
            </c:choose>
            <h:backToHomePage></h:backToHomePage>
        </div>
    </body>
</html>
