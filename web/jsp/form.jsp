<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="post">
            <input type="text"
                   id="field1"
                   name="firstName"
                   placeholder="Type your name"
                   size="50"
                   value="${param.firstName}"/>
            <button type="submit">Post</button>
        </form>

        <c:if test="${not empty param.firstName}">
            <h3>Hi ${param.firstName}!</h3>
        </c:if>
    </body>
</html>
