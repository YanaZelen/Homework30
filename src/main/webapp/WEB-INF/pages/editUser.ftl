<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Редактировать пользователя</title>
</head>
<body>
<br>

<fieldset>
    <legend>Редактировать пользователя</legend>
    <form name="user" action="/user/edit" method="post">
        Идентификатор : <input type="number" name="id" value="${user.id}" readonly /><br/>
        Имя : <input type="text" name="name" value="${user.name}"/><br/>
        Почта: <input type="text" name="email" value="${user.email}"/><br/>
        Пароль: <input type="text" name="password" value="${user.password}"/><br/>
        <input type="submit" value="Save" />
    </form>
</fieldset>
<br/>

</div>
</body>
</html>