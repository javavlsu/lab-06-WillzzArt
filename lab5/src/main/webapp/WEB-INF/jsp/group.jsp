<%@page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isELIgnored="false" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
    <head></head>

    <body>
        <h1>Create/Update groups</h1>
        <form action="group" method="post">
            <c:choose>
                <c:when test="${isCreate == false}">
                    <input type="hidden" name="id" value="${group.id}" />
                </c:when>
            </c:choose>
            <p>Name: <input type="text" name="groupName" id="groupName" value="${group.groupName}"/></p>
            <p><input type="submit" value="Submit" /> <input type="reset" value="Reset" /></p>
        </form>
    </body>

</html>