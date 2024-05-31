<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
    <title>Todo List</title>
</head>
<body>
    <div class="container">
    <div>Welcome ${name}</div>
    <hr>
    <h1>Your todos are</h1>
    <table class="table">
        <thead>
            <tr>
                <th>id</th>
                <!-- <th>Username</th> -->
                <th>Description</th>
                <th>Target date</th>
                <th>isDone</th>
                <th></th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${todo}" var="todo">
                <tr>
                    <td>${todo.id}</td>
                    <!-- <td>${todo.username}</td> -->
                    <td>${todo.description}</td>
                    <td>${todo.localdate}</td>
                    <td>${todo.done}</td>
                    <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <a href="add-todo" class="btn btn-success">Add todo</a>
</div>
 <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>