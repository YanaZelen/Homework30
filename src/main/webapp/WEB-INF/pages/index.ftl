<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org" xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity5">
<head>
    <meta charset="UTF-8">
    <title>Войти в систему</title>
</head>
<body>

<div align="center">

    <h1>Welcome <sec:authentication property="principal.username"/> </h1>

    <th:block sec:authorize="isAuthenticated()">
        <a href="/logout"><button>Выйти</button></a>
    </th:block>
    <a href="/login"><button>Войти</button></a>

</div>

</body>
</html>