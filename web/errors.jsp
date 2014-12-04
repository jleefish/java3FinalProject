<%-- 
    Document   : errors
    Created on : Dec 3, 2014, 7:41:16 PM
    Author     : jhlee
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ERROR PAGE</title>
        <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    </head>
    <body>
        <h1>ERROR!</h1><hr>
        <table>
            <tr>
                <td>Error Codes</td>
            </tr>
            <c:forEach items="${errorCodes}" var="codes">
                <tr>
                    <td>
                        <c:out value="${codes}"/>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
