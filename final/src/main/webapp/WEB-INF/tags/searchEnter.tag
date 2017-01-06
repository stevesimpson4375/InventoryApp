<%@tag description="Search Enter" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@attribute name="searchBy"%>

<tr>
    <td>${searchBy}</td>
    <c:choose>
        <c:when test="${searchBy == 'Purchase Date' || searchBy == 'Expiration Date'}">
            <td><input type="text" name="searchValue" required="true"
                       class="datepicker" readonly="readonly"></td>
        </c:when>
        <c:when test="${searchBy == 'Household Product Type'}">
                <td><select name="${searchBy}">
                        <c:forEach var="i" items="${productTypeStrings}">
                            <option value="${i}">${i}</option>
                        </c:forEach>
                    </select></td>
        </c:when>
        <c:otherwise>
            <td><input type="text" name="searchValue" required="true" id="${searchBy}"></td>
        </c:otherwise> 
    </c:choose>
    <td><input type="submit" value="Search" class="searchButton" name="${searchBy}"></td>
    <td class="hidden" name="${searchBy}">You must enter a number</td>
    <input type="hidden" name="searchedBy" value="${searchBy}" />
</tr>
