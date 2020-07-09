<%--
Выводит список сотрудников с учетом фильтров
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="main">

    <table border="2" cellspacing="5" cellpadding="8" >
        <thead>
        <tr>
            <td> <h4> № ID </h4></td>
            <td> <h4> Сотрудников список </h4></td>
            <td> <h4> Возраст </h4></td>
            <td> <h4> Район </h4></td>
            <td> <h4> Округ </h4></td>
            <td> <h4> Адрес </h4></td>
            <td> <h4> Начало смены </h4></td>
            <td> <h4> Конец смены </h4></td>
            <td> <h4> ${dxl} </h4></td>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="user" items = "${num}"  >

            <tr>
                <td> ${i=i+1;allusers.get(i-1)} </td>
                <td> ${i=i+1;allusers.get(i-1)} </td>
                <td> ${i=i+1;allusers.get(i-1)} </td>
                <td> ${i=i+1;allusers.get(i-1)} </td>
                <td> ${i=i+1;allusers.get(i-1)} </td>
                <td> ${i=i+1;allusers.get(i-1)} </td>
                <td> ${i=i+1;allusers.get(i-1)} </td>
                <td> ${i=i+1;allusers.get(i-1)} </td>
            </tr>

        </c:forEach>

        </tbody>
    </table>

</div>