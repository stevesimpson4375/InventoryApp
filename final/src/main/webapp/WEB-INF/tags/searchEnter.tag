<%@tag description="Search Enter" pageEncoding="UTF-8"%>

<%@attribute name="searchBy"%>

<tr>
    <td>${searchBy}</td>
    <td><input type="text" name="searchValue"></td>
    <td><input type="submit" value="Search"></td>
    <input type="hidden" name="searchedBy" value="${searchBy}" />
</tr>

