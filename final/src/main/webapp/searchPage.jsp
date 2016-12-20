<!DOCTYPE html>
<%@ page import="com.googlecode.objectify.cmd.Query" %>
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
        <title>Search Page</title>

        <%
            ArrayList<String> items = Util.datastore.retrieveDescriptions();
            request.setAttribute("items", items);
        %>
    </head>
    <body> 
        <div id="container">
            <h:backToHomePage></h:backToHomePage>
                <h2 class="header">Enter Search Criteria Below</h2>
                <br />
                <h3 class="header">General Searches</h3>
                <div class="survey">
                    <table class="hydQuestion">
                        <form action="/SearchBy" method="post">
                        <h:searchEnter searchBy="Description"></h:searchEnter>
                        </form>
                        <form action="/SearchBy" method="post">
                        <h:searchEnter searchBy="Price"></h:searchEnter>
                        </form>
                        <form action="/SearchBy" mothod="post">
                        <h:searchEnter searchBy="Purchase Date"></h:searchEnter>
                        </form>
                    </table>
                </div>
                <br />
                <h3 class="header">Food Only Searches</h3>
                <div class="survey">
                    <table class="dhydQuestion">
                        
                    </table>
                </div>

                <hr />
                <div class="survey">
                    <table class="hydQuestion">
                    <c:forEach var="i" items="${items}">
                        <tr><td><p>${i}</p></td></tr>
                    </c:forEach>
                </table>
                <br />
                <div class="survey">
                    <table class="hydQuestion">
                        <form action="/deleteAll" method="post">
                            <tr><td><input type="submit" value="Delete All Records"></td></tr>
                        </form>
                    </table>
                </div>
            </div>
            <%
                if (items == null) {
            %>
            <p class="header">Database Empty!</p>
            <%
                }
            %>

            <h:backToHomePage></h:backToHomePage>
        </div>
    </body>
</html>
