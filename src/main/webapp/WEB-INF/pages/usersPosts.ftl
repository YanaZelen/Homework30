<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Список постов пользователя</title>
    <style>
        table {
            width: 100%;
            margin-bottom: 20px;
            border: 1px solid #dddddd;
            border-collapse: collapse;
        }

        table th {
            font-weight: bold;
            padding: 5px;
            background: #efefef;
            border: 1px solid #dddddd;
        }

        table td {
            border: 1px solid #dddddd;
            padding: 5px;
        }
    </style>
</head>
<body>

<h1>Посты пользователя ${user.name} </h1>

<div id="content">
    <table class="datatable">
        <h3>Список постов</h3>
        <tr>
            <td>Заголовок</td>
            <td>Текст</td>
            <td>Дата публикации</td>
            <td>Информация</td>
        </tr>
        <#list postListByUser as post>
            <tr>
                <td>${post.title}</td>
                <td>
                    ${post.text}
                </td>
                <td>${post.date}</td>
                <td>
                    <a href="/post/edit/${post.id}">
                        <button>Редактировать</button>
                    </a>
                    <a href="/post/delete/${post.id}">
                        <button>Удалить</button>
                    </a>
                </td>
            </tr>
        </#list>
    </table>

    <a href="/post/add/${user.id}">
        <button>Добавить новый</button>
    </a>

</div>

</body>
</html>