<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div id="header">
    <div style="text-align: center; font-size: 35px; color: white;">ООО Ромашка</div>
    <div style="position: fixed; right: 10px; top: 10px; color: white;">Вы вошли как: ${username}</div>
    <div style="position: fixed; left: 10px; top: 10px; color: white;">Session ID: ${sessionid}</div>
    <div style="position: fixed; left: 10px; top: 30px; color: white;">Autorization: ${autorized}</div>
    <div style="position: fixed; right: 10px; top: 30px; color: white;"><a href="/sClose" >Выход</a> </div>

</div>