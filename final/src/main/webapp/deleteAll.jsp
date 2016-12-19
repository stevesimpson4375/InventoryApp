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

    </head>
    <body> 
        <div id="container">
            <h:backToHomePage></h:backToHomePage>
                <h3 class="header">Delete All</h3>

                <div class="survey">
                    <table class="hydQuestion">
                        <form action="/deleteAll" method="post">
                            <tr><td><input type="submit" value="Delete All Records"></td></tr>
                        </form>
                    </table>
                </div>
            </div>

            <h:backToHomePage></h:backToHomePage>
        </div>
    </body>
</html>
