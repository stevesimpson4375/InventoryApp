<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Enter Field" pageEncoding="UTF-8"%>

<%@attribute name="field" required="true"%>

<c:choose>
    <c:when test="${field == 'Purchase Date' || field == 'Expiration Date'}">
        <tr>
            <td>${field}</td><td><input type='date' name="${field}" required="true"></td>
        </tr>
    </c:when>
    <c:otherwise>
        <tr>
            <td>${field}</td><td><input type='text' name="${field}" required="true"></td>
        </tr>
    </c:otherwise>
</c:choose>