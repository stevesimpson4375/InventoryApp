<%@ page import="com.googlecode.objectify.cmd.Query" %>
<%@ page import="com.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.ArrayList"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Search Page</title>

        <%
            ArrayList<String> items = Util.datastore.retrieveDescriptions();
            request.setAttribute("items", items);
        %>
    </head>
    <body>
        <h3>Enter Search Criteria Below</h3>

        <c:forEach var="i" items="${items}">
            <p>${i}</p>
        </c:forEach>

        <form action="/deleteAll" method="post">
            <div><input type="submit" value="Delete All Records"</div>
        </form>
            
        <%
            if(items == null){
        %>
                <p>Database Empty!</p>
        <%
            }
        %>
    </body>
</html>
