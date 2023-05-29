<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавить пользователя</title>
</head>
<body>
<br>

<fieldset>
    <legend>Добавить пользователя</legend>
    <form name="user" action="/user/add" method="post">
        Имя: <input type="text" name="name" /><br/>
        Почта: <input type="text" name="email" /><br/>
        Пароль: <input type="text" name="password" /><br/>
        <input type="submit" value="Save" />
    </form>
</fieldset>
<br/>

</div>
</body>
</html>