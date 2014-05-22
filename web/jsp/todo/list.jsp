<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <a href="?add">+ Add</a>
        <table>
            <tr>
                <th align="right">#</th>
                <th align="left">Tasks</th>
            </tr>
            <c:forEach items="${taskList}" var="item" varStatus="stat">
                <tr>
                    <td align="right">${stat.index + 1}.</td>
                    <td>${item}</td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
