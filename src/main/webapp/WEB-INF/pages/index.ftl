<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Информация о пользователях</title>
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
<div id="header">
    <h2>Сервис пользователей</h2>
</div>
<div id="content">
    <table class="datatable">
        <h3>Список пользователей</h3>
        <tr>
            <td>Идентификатор</td>
            <td>Имя</td>
            <td>Почта</td>
            <td>Посты</td>
            <td>Информация</td>
        </tr>
        <#list userList as user>
            <tr>
                <td>${user.id}</td>
                <td>
                    ${user.name}
                </td>
                <td>${user.email}</td>
                <td><a href="/user/posts/${user.id}">
                        <button>Список постов</button>
                    </a>
                </td>
                <td>
                    <a href="/user/edit/${user.id}">
                        <button>Редактировать</button>
                    </a>
                    <a href="/user/delete/${user.id}">
                        <button>Удалить</button>
                    </a>
                </td>
            </tr>
        </#list>
    </table>

    <a href="/user/add">
        <button>Добавить пользователя</button>
    </a>

</div>
</body>
</html>