<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
<head>
<title>JSP forward example with parameters</title>
</head>
<body> 
   
    <form action="/SearchBy" method="post" id="form1">
        <table>
            <input type="hidden" name="searchedBy" value="all" />
            <input type="hidden" name="searchValue" value="all" />
        </table>
    </form>
    
</body> 
<script>document.getElementById('form1').submit();</script>
</html>