<!doctype html>
<html lang="ru" >
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Регистрация</title>
    <style>

    </style>
</head>
<body>
<div id="header">
    <h2>Регистрация</h2>
</div>
<div id="content">

    <fieldset>
        <legend>Создать нового пользователя</legend>
        <form name="user" action="/signin" method="post">
            Логин : <input type="text" name="name" /><br/>
            Email : <input type="text" name="email" /><br/>
            Пароль: <input type="text" name="password" /><br/>
            <input type="submit" value="Создать" />
        </form>
        <br>
        <a href="/login">
            <button>Уже есть аккаунт</button>
        </a>
    </fieldset>
</div>
</body>
</html>