<%@ tag description="Generates table of results" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3 class="header">Food Results</h3>
<div class="survey">
    <table class="sortable">
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th>Purchase Date</th>
        </tr>
        <c:forEach var="i" items="${results}" varStatus="loop">
            <c:choose>
                <c:when test="${i.class == 'class com.Food'}">
                    <tr>
                        <td>${fn:escapeXml(i.description)}</td>
                        <td>${fn:escapeXml(i.price)}</td>
                        <td>${i.purchaseDate}</td>
                        <td><button type="submit" name="selected" value="${i.id}">Delete</button></td>
                    </tr>
                </c:when>
            </c:choose>
        </c:forEach>
    </table>
</div>

<h3 class="header">Household Product Results</h3>
<div class="survey">
    <table class="sortable">
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th>Purchase Date</th>
            <th>Amount</th>
            <th>Amount Type</th>
            <th>Type of Product</th>
        </tr>
        <c:forEach var="i" items="${results}" varStatus="loop">
            <c:choose>
                <c:when test="${i.class == 'class com.HouseHoldProduct'}">
                    <tr>
                        <td>${fn:escapeXml(i.description)}</td>
                        <td>${fn:escapeXml(i.price)}</td>
                        <td>${i.purchaseDate}</td>
                        <td>${fn:escapeXml(i.amount)}</td>
                        <td>${fn:escapeXml(i.amountType)}</td>
                        <td>${fn:escapeXml(i.type)}</td>
                        <td><button type="submit" name="selected" value="${i.id}">Delete</button></td>
                    </tr>
                </c:when>
            </c:choose>
        </c:forEach>
    </table>
</div>

<h3 class="header">Appliance Results</h3>
<div class="survey">
    <table class="sortable">
        <tr>
            <th>Description</th>
            <th>Price</th>
            <th>Purchase Date</th>
            <th>Material</th>
            <th>Weight (in kgs)</th>
            <th>Type of Product</th>
        </tr>
        <c:forEach var="i" items="${results}" varStatus="loop">
            <c:choose>
                <c:when test="${i.class == 'class com.Appliance'}">
                    <tr>
                        <td>${fn:escapeXml(i.description)}</td>
                        <td>${fn:escapeXml(i.price)}</td>
                        <td>${i.purchaseDate}</td>
                        <td>${fn:escapeXml(i.material)}</td>
                        <td>${fn:escapeXml(i.weight)}</td>
                        <td>${fn:escapeXml(i.type)}</td>
                        <td><button type="submit" name="selected" value="${i.id}">Delete</button></td>
                    </tr>
                </c:when>
            </c:choose>
        </c:forEach>
    </table>
</div>
