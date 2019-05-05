<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">

    <title>loginPage</title>

    <style>

    </style>

    <script type="text/javascript" charset="UTF-8">

        function change1() {
            document.getElementById('posted').name = "postInApp1";

        }

        function change2() {
            document.getElementById('posted').name = "postInApp2";

        }


    </script>

</head>

<body>



<div class="author" id="authorForm">
    <form method="post" action="loginPage">

        <input name="rad" type="radio" value="spec" onclick="change1()" id = "spec" > Специалист <br/>
        <input name="rad" type="radio" value="manager" onclick="change2()" id = "manager" > Руководитель <br/>

        <input type= "text" name="login">
        <input type= "text" name="password">

        <input type="submit" value="Войти" id = "posted" >
    </form>



</div>


</body>

</html>

