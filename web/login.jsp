<link href="resources/css/style.css" rel="stylesheet" type="text/css">


<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<body>
<div class="bgr">
    <form action="/login_filter">
        <div class="container">
            <div class="row">
                <div class="col" style="width: 100px;">
                    <b>User Name</b>
                </div>
                <div class="col">
                    <input type="text" placeholder="Enter username"
                           name="username" required>
                </div>
            </div>
            <div class="row">
                <div class="col">
                    <b>Password</b>
                </div>
                <div class="col">
                    <input type="password" placeholder="Enter password"
                           name="password" required>
                </div>
            </div>

            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <button type="submit">Login</button>
                </div>
            </div>

            <div class="row">
                <div class="col"></div>
                <div class="col">
                    <p class = "err"> ${login_err} </p>
                </div>
            </div>


        </div>
    </form>
</div>

</body>

