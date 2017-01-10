<!DOCTYPE html>
<%@ page import="com.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="h" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="stylesheets/mystyle.css">
        <title>Search Results: Price</title>
        <script type="text/javascript" src="js/sorttable.js"></script>
    </head>
    <body>
        <div id="container">
            <h:backToSearchPage></h:backToSearchPage>
                <div class="survey">
                    <c:choose>
                        <c:when test="${fn:length(results) == 0}">
                            <p>Search returned no results!</p>
                        </c:when>
                        <c:otherwise>
                            <form action="/DeleteByIdServlet" method="post">
                                <%--<table class="hydQuestion">
                                        <c:forEach var="i" items="${results}" varStatus="loop">
                                            <tr><td>${fn:escapeXml(i)}</td><td>${i.id}</td>
                                                <td><button type="submit" name="selected" value="${i.id}">Delete</button></td>
                                            </tr>
                                        </c:forEach>
                                    </table>--%>
                            <h:searchResult></h:searchResult>
                            <input type="hidden" name="searchedBy" value="${searchedBy}" />
                            <input type="hidden" name="searchValue" value="${searchValue}" />
                            </form>
                        </c:otherwise>
                    </c:choose>
                </div>
            <h:backToSearchPage></h:backToSearchPage>
        </div>
    </body>
</html>
