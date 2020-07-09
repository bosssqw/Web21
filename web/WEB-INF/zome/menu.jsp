<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<body>
    <form action="/sotrudniki">


<div id="nav" class="vmenu">


   <br>
    <h4>Добавление новых сотрудников</h4>

    <p> <a target="_blank" href="/new_form" style= "width: 230px;">  Добавить сотрудника </a></p>

    <br>
    <h4>Фильтр сотрудников</h4>

    <tr>
        <th> Поиск сотрудников по ФИО </th>
        <td>  <input type="text" placeholder=" "  name="ff_fio"  style= "width: 250px;">   </td>
    </tr>
    <br>

    <tr>
        <th> Выберите район из списка</th>
        <td>
            <select name="ff_rayon" style= "width: 250px;">
                <c:forEach var = "item" items="${f_rayon}">
                    <option value=${item}>${item} </option>
                </c:forEach>
            </select>
        </td>
    </tr>

    <tr>
        <th> Выберите округ из списка</th>
        <td>
            <select name="ff_okrug" style= "width: 250px;">
                <c:forEach var = "item" items="${f_okrug}">
                    <option value=${item}>${item} </option>
                </c:forEach>
            </select>
        </td>
    </tr>

    <br>

    <tr>
        <th> Отсортировать список по </th>
        <td>
            <select name="ff_sort" style= "width: 250px;">
                <c:forEach var = "item" items="${f_sort}">
                    <option value=${item.value}>${item.key} </option>
                </c:forEach>
            </select>
        </td>
    </tr>

    <br>
    <br>
    <div class="row">
        <div class="col">
            <br>
            <button type="submit" style= "width: 250px;">  Обновить список сотрудников </button>
        </div>
    </div>
    <br>


</div>

    </form>

</body>






