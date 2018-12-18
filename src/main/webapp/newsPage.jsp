<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>newsPage</title>

    <meta charset="utf-8">
    <style>
        .modal {
            background-color: #806b71;
            font-size: 30%;
            position: fixed;
            height: 400px;
            width: 600px;
            top: 20%;
            bottom: 30%;
            left: 30%;
            right: 30%;
            border-style: solid;
            border: black;
            border-width: 5px;
            display: none;
        }

    </style>
    <script type="text/javascript">

        function modal_open() {
            var modalWind = document.getElementById('modalDialog');
            modalWind.style.display = 'block';
            document.getElementById("button_modal").disabled = true;
        }

        function modal_close() {
            var modalWind = document.getElementById('modalDialog');
            modalWind.style.display = 'none';
            document.getElementById("button_modal").disabled = false;
        }

    </script>

</head>

<body>
<div>
    <form>
        <input type="button" id="button_modal" value="Добавить" onclick="modal_open()"/>
    </form>
</div>

<div>
    <ul>
        <jsp:useBean id="listofpush" scope="request" type="java.util.List<ru.spb.Pushdata>"/>
        <c:forEach items="${listofpush}" var="pushdata">
            <li><c:out value="${pushdata.title}"/></li>
            <br/>
            <li><c:out value="${pushdata.content}"/></li>
            <br/>
        </c:forEach>
    </ul>
</div>


<div class="modal" id="modalDialog">
    <form method="post" action="newsPage">
        <input type= "text" name="content">
        <input type= "text" name="title">
        <input type="submit" value="Сохранить" name="putInApp">
    </form>
    <input type="button" value="Закрыть" onclick="modal_close()">

</div>


</body>

</html>

