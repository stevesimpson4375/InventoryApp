<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Enter Field" pageEncoding="UTF-8"%>

<%@attribute name="field" required="true"%>

<c:choose>
    <c:when test="${field == 'Purchase Date' || field == 'Expiration Date'}">
        <tr>
            <td><label>${field}  <input type='date' name="${field}"></label></td>
        </tr>
    </c:when>
    <c:otherwise>
        <tr>
            <td><label>${field}  <input type='text' name="${field}"></label></td>
        </tr>
</c:otherwise>
</c:choose>