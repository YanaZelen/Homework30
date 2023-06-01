<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <title>Редактировать пост</title>
</head>
<body>
<br>

<fieldset>
    <legend>Редактировать пост</legend>
    <form name="post" action="/post/edit/${user.id}" method="post">
        Идентификатор : <input type="number" name="id" value="${post.id}" readonly /><br/>
        Заголовок : <input type="text" name="title" value="${post.title}"/><br/>
        Текст: <input type="text" name="text" value="${post.text}"/><br/>
        Дата публикации: <input type="datetime-local" name="date" value="${post.date}" readonly/><br/>
        <input type="submit" value="Save" />
    </form>
</fieldset>
<br/>

</div>
</body>
</html>
