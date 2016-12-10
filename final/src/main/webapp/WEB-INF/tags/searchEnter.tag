<%@tag description="Search Enter" pageEncoding="UTF-8"%>

<%@attribute name="searchBy"%>


<tr>
    <td>${searchBy}</td>
    <td><input type="text" name="${searchBy}"></td>
    <td><input type="submit" value="Search"></td>
</tr>
