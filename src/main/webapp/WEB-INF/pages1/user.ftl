<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.springframework.org/security">
<head>
    <meta charset="UTF-8">
    <title>User Page</title>
</head>
<body>

<div align="center">

    <h1>Hello  <span sec:authentication="name"></span></h1>

    <sec:authorize access="isAuthenticated()">
        <p>Ваш логин: <sec:authentication property="principal.username" /></p>
        <p><a class="btn btn-lg btn-danger" href="/logout" role="button">Выйти</a></p>
    </sec:authorize>

</div>

</body>
</html>