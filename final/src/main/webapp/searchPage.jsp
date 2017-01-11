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
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script type="text/javascript" src="js/script.js"></script>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <title>Search Page</title>
        <% 
            request.setAttribute("productTypeStrings", Util.getValidProductTypes()); 
            request.setAttribute("applianceTypeStrings", Util.getValidApplianceTypes()); 
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
                    <table class="hydQuestion">
                    <form action="/SearchBy" method="post">
                        <h:searchEnter searchBy="Expiration Date"></h:searchEnter>
                    </form>
                    </table>
                </div>
                <h3 class="header">Household Item Only Searches</h3>
                <div class="survey">
                    <table class="hydQuestion">
                        <form action="/SearchBy" method="post">
                            <h:searchEnter searchBy="Household Product Type"></h:searchEnter>
                        </form>
                    </table>
                </div>
                <h3 class="header">Appliance Item Only Searches</h3>
                <div class="survey">
                    <table class="hydQuestion">
                        <form action="/SearchBy" method="post">
                            <h:searchEnter searchBy="Appliance Type"></h:searchEnter>
                        </form>
                    </table>
                </div>
            <h:backToHomePage></h:backToHomePage>
        </div>
    </body>
</html>
