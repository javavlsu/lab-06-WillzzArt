<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<html>
    <head></head>

    <body>
        <h1><a href="<c:url value='/group'/>">Create new group</a></h1>
        <br>
        <table border="2">
            <tr>
                <th>id</th>
                <th>name</th>
                <th>delete</th>
                <th>update</th>
            </tr>
            <c:forEach items="${groupList}" var="groupItem">
                <c:url value="/group/${groupItem.id}" var="deleteURL" />
                <c:url value="/group" var="updateURL">
                    <c:param name="id" value="${groupItem.id}"/>
                </c:url>
                <tr>
                    <td><c:out value="${groupItem.id}"/></td>
                    <td><c:out value="${groupItem.groupName}"/></td>
                    <td><a href="${deleteURL}">delete</a></td>
                    <td><a href="${updateURL}">update</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>

</html>