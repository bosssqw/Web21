<%--
Дабавляет нового сотрудника в БД
--%>
<link href="../../resources/css/style.css" rel="stylesheet" type="text/css">

<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js" integrity="sha256-9/aliU8dGd2tb6OSsuzixeV4y/faTqgFtohetphbbj0=" crossorigin="anonymous"></script>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Добавление сотрудника</title>
</head>

<body>

<form action="/form_check">

<table border="2" cellspacing="5" cellpadding="8" >
    <thead>
    <tr>
        <th> Данные сотрудника. ID= ${cnt+1} </th>
        <td>
            <select name="new_id" style= "width: 350px;">

                <option value=${cnt+1}> ${cnt+1} </option>
            </select>
        </td>
    </tr>
    </thead>

    <tbody>
    <tr>
        <th> Введите ФИО по шаблону</th>
        <td>  <input type="text" placeholder="Иванов И. И."  name="new_name" required style= "width: 350px;">   </td>
    </tr>
    <tr>
        <th> Выберите возраст </th>
        <td>
            <select name="new_age" style= "width: 350px;">
                <c:forEach var = "item" items="${new_age}">
                    <option value=${item}> ${item} </option>

                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <th> Введите Адрес по шаблону</th>
        <td>  <input type="text" placeholder="Проектируемый проезд дом 12"  name="new_adres" required style= "width: 350px;">   </td>
    </tr>
    <tr>
        <th> Выберите округ из списка</th>
        <td>
            <select name="new_okrug" style= "width: 350px;">
                <c:forEach var = "item" items="${new_okrug}">
                    <option value="${item}">${item} </option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <th> Выберите район из списка</th>
        <td>
            <select name="new_rayon" style= "width: 350px;">
                <c:forEach var = "item" items="${new_rayon}">
                    <option value="${item}">${item} </option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <th> Выберите время начала работы </th>
        <td>
            <select name="new_start" style= "width: 350px;">
                <c:forEach var = "item" items="${new_time}">
                    <option value=${item}>${item} </option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <th> Выберите время окончания работы </th>
        <td>
            <select name="new_finish" style= "width: 350px;">
                <c:forEach var = "item" items="${new_time}">
                    <option value=${item}>${item} </option>
                </c:forEach>
            </select>
        </td>
    </tr>

    </tbody>

</table>


<br>
<div class="row">
    <div class="col">
         Для добавления нового сотрудника нажмите :
        <button type="submit" > ДОБАВИТЬ </button>
    </div>
</div>


<br>
<div class="row">
     <div class="col">
        <p class = "err"> ${new_err} </p>
        <p class = "add">  ${added}</p>
    </div>
</div>

</form>
</body>

</html>

