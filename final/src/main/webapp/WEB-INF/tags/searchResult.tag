<%@ tag description="Generates table of results" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<div class="survey">
    <table class="hydQuestion sortable">
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th>Purchase Date</th>
        </tr>
        <c:forEach var="i" items="${results}" varStatus="loop">
            <tr>
                <td>${fn:escapeXml(i.description)}</td>
                <td>${fn:escapeXml(i.price)}</td>
                <td>${i.purchaseDate}</td>
                <td><button type="submit" name="selected" value="${i.id}">Delete</button></td>
            </tr>
        </c:forEach>
    </table>
</div>
