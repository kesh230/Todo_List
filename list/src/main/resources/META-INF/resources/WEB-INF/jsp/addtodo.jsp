<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet" >
  <title>Add new todos</title>
</head>
<body>
    <div class="container">
        <h2>Enter new list of todos details:-</h2>
        <form:form method="post" modelAttribute="todo">
            Description: <form:input type="text"  path="description" required="required"/>
            <form:errors path="description" cssClass="text-warning"/>
                <form:input type="text"  path="id"/>
                <form:input type="text"  path="done"/>
            <input type="submit" class="btn btn-success"/>
        </form:form>
    </div>

    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</body>
</html>