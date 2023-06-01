<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Добавить пост</title>
</head>
<body>
<br>

<fieldset>
    <legend>Добавить пост</legend>
    <form name="post" action="user/post/add/${user.id}" method="post">
        Заголовок: <input type="text" name="title" /><br/>
        Текст: <input type="text" name="text" /><br/>
        <input type="submit" value="Save" />
    </form>
</fieldset>
<br/>
</body>
</html>