<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml" xmlns:th="http://www.thymeleaf.org"
      xmlns:sec="http://www.springframework.org/security"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xsi:schemaLocation="http://www.springframework.org/security
http://www.springframework.org/security ">
<head>
    <meta charset="UTF-8">
    <title>USERS CRUD</title>
</head>
<body>

<div align="center">
    <h1 sec:authentication="name"></h1>
    <sec:authorize access="isAuthenticated()">
        <p>Ваш логин: <sec:authentication property="principal.username" /></p>
        <p><a class="btn btn-lg btn-danger" href="/logout" role="button">Выйти</a></p>
    </sec:authorize>
    <h2>Users</h2>


    <div id="content">
        <table style="border: 3px solid black" class="datatable">
            <tr>
                <td style="border: 1px solid gray">Идентификатор</td>
                <td style="border: 1px solid #808080">Имя</td>
                <td style="border: 1px solid gray">Почта</td>
                <td style="border: 1px solid gray">Пароль</td>
                <td style="border: 1px solid gray">Посты</td>
                <td style="border: 1px solid gray">Информация</td>
            </tr>
            <#list users as user>
            <tr style="border: 2px solid black">
                <td style="border: 1px solid gray" ${user.id}/>
                <td style="border: 1px solid gray" ${user.name}/>
                <td style="border: 1px solid gray" ${user.email}/>
                <td style="border: 1px solid gray" ${user.password}/>
                <td style="border: 1px solid gray"><a href="/user/posts/${user.id}">
                        <button>Список постов</button>
                    </a>
                </td>
                <td style="border: 1px solid gray">
                    <a href="/admin/edit/${user.id}">
                        <button>Редактировать</button>
                    </a>
                    <a href="/admin/delete/${user.id}">
                        <button>Удалить</button>
                    </a>
                </td>
            </tr>
            </#list>
        </table>
        <a href="/admin/add">
            <button>Добавить пользователя</button>
        </a>

    </div>
</div>

</body>
</html>