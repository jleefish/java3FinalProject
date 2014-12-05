<%-- 
    Document   : rentals
    Created on : Dec 3, 2014, 7:40:47 PM
    Author     : jhlee
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>RENTAL INFO</title>
        <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    </head>
    <body>
        <h1>RENTAL INFORMATION</h1><hr>
        <table>
            <tr>
                <td>Customer No</td><td><c:out value="${bean.customerNumber}"/></td>
            </tr>
            <tr>
                <td>Pick Up</td><td>
                    <c:out value="${bean.pickupHour}"/>h <c:out value="${bean.pickupDay}"/>d <c:out value="${bean.pickupMon}"/>m <c:out value="${bean.pickupYear}"/>y
                </td>
            </tr>
            <tr>
                <td>Drop Off</td><td>
                    <c:out value="${bean.dropoffHour}"/>h <c:out value="${bean.dropoffDay}"/>d <c:out value="${bean.dropoffMon}"/>m <c:out value="${bean.dropoffYear}"/>y
                </td>
            </tr>
            <tr>
                <td>Car Type</td><td><c:out value="${bean.rentalType}"/></td>
            </tr>
            <tr>
                <td>Credit Card</td><td><c:out value="${bean.cardType}"/></td>
            </tr>
            <tr>
                <td>Credit Card No</td><td><c:out value="${bean.cardNumber}"/></td>
            </tr>
        </table><hr>
        <h3>Price: <c:out value="${bean.price}"/> CAD</h3><hr>
        <a href="index.html">start over</a>

</body>
</html>
