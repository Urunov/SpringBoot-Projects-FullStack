<!DOCTYPE HTML>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2020 00:00:00 GMT">

    <title>Todo Manager | Home</title>

    <link href="/static/css/bootstrap.min.css" rel="stylesheet">
    <link href="/static/css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>

<div>
    <ul class="navigation-bar">
        <li><a href="/">Todos</a></li>
        <li><a href="new-todo">Create Todo</a></li>
        <li><a href="all-todos">All Todos</a></li>
    </ul>
</div>

<c:choose>
    <c:when test="${mode == 'MODE_HOME'}">
        <div class="container" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Welcome to Todo Manager</h1>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_TODOS'}">
        <div class="container text-center" id="tasksDiv">
            <h3>My Todos</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                    <tr>
                        <th>TodoId</th>
                        <th>Name</th>
                        <th>Description</th>
                        <th>Date Created</th>
                        <th>Finished</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="todo" items="${todos}">
                        <tr>
                            <td>${todo.id}</td>
                            <td>${todo.name}</td>
                            <td>${todo.description}</td>
                            <td>
                                <fmt:formatDate pattern="yyyy-MM-dd HH:mm:ss" value="${todo.dateCreated}" />
                            </td>
                            <td>${todo.finished}</td>
                            <td>
                                <a href="update-todo?id=${todo.id}">
                                    <span>&#x1f589;</span></a>
                            </td>
                            <td>
                                <a href="delete-todo?id=${todo.id}">
										<span class="close-icon">
										<i class="fa fa-trash"></i></span></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </c:when>
    <c:when test="${mode == 'MODE_NEW' || mode == 'MODE_UPDATE'}">

        <div class="container">
            <form class="form-horizontal" method="POST" action="save-todo">
                <div class="text-center">
                    <h3>Manage Todo</h3>
                </div>
                <hr />
                <input type="hidden" name="id" value="${todo.id}" />
                <div class="form-group">
                    <label for="name">Name</label>
                    <input type="text" class="form-control" name="name" value="${todo.name}" />
                </div>
                <div class="form-group">
                    <label for="description">Description</label>
                    <input type="text" class="form-control" name="description" value="${todo.description}" />
                </div>
                <div class="form-group">
                    <label for="finished">Finished</label>
                    <div class="col-md-7">
                        <input type="radio" class="col-sm-1" name="finished" value="true" />
                        <span class="col-sm-1">Yes</span>
                        <input type="radio" class="col-sm-1" name="finished" value="false" checked />
                        <span class="col-sm-1">No</span>
                    </div>
                </div>
                <div class="form-group">
                    <input type="submit" class="btn btn-primary" value="Save" />
                </div>
            </form>
        </div>
    </c:when>
</c:choose>

</body>
</html>