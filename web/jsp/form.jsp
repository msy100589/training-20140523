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
                   name="name"
                   placeholder="Type your name"
                   size="50"
                   value="${param.name}"/>
            <button type="submit">Post</button>
        </form>

        <c:if test="${not empty param.name}">
            <h3>Hi ${param.name}</h3>
        </c:if>
    </body>
</html>
