<!doctype html>
<html lang="ru" xmlns:sec="">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Войти в систему</title>
</head>
<body>

<div align="center">

    <h1>Welcome <sec:authentication property="principal.username"/> </h1>

    <sec:authorize access="!isAuthenticated()">
        <p><a class="btn btn-lg btn-success" href="/login" role="button">Войти</a></p>
    </sec:authorize>

    <sec:authorize access="isAuthenticated()">
        <p><a class="btn btn-lg btn-danger" href="/logout" role="button">Выйти</a></p>
    </sec:authorize>

</div>

</body>
</html>