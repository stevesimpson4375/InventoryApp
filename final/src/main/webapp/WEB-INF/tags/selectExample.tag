<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@tag description="Generate Example Select Element" pageEncoding="UTF-8"%>

<%@attribute name="examples" type="java.lang.String[]" %>
                <div class="survey">
                    <table class="hydQuestion">
                        <tr>
                            <td>Select a predefined appliance: </td>
                            <td><select class="selectExample">
                                <c:forEach var="i" items="${examples}">
                                    <option value="${i}">${i}</option>
                                </c:forEach>
                            </select></td>
                    </tr>
                </table>
            </div>