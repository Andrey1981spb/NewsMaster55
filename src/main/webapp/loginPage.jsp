<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">

    <title>loginPage</title>

    <style>

    </style>

    <script type="text/javascript" charset="UTF-8">

    </script>

</head>

<body>

    <div>
        <p>${new_message.message}</p>
    </div>

<div class="author" id="authorForm">
    <form method="post" action="loginPage">

        <input type= "text" name="login">
        <input type= "text" name="password">

        <input type="submit" value="Войти" name="postInApp">
    </form>

</div>


</body>

</html>

