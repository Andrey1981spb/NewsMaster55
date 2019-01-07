<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">

    <title>newsPage</title>

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

        .pushstack{
            background-color: #800921;
            border-style: solid;
            border: black;
            border-width: 5px;
            width: 600px;
        }

        .contentnew{
            height: 20px;
            width: 300px;
        }

    </style>

    <script type="text/javascript" charset="UTF-8">

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

            function countf() {
                var text = document.getElementById('text');
                var valuecounter = text.value;
                var lengthcounter = valuecounter.length;
                var maxlength = document.getElementById('text').getAttribute('maxlength');

                var vestige = maxlength - lengthcounter;
                var delta = document.getElementById('count');
                delta.innerHTML = 'осталось ' + vestige + ' знаков';
            }

    </script>

</head>

<body>
<div>
    <form>
        <input type="button" id="button_modal" value="Добавить" onclick="modal_open()"/>
    </form>
</div>


<ul>
    <jsp:useBean id="listofpush" scope="session" type="java.util.List<ru.spb.push.Pushdata>"/>
    <c:forEach items="${listofpush}" var="pushdata">
        <div class="pushstack">
            <form>
                <input type="text" name="title" value="<c:out value="${pushdata.title}"/>">
                <input type="textarea" name="content" cols="45" maxlength="100" value="<c:out value="${pushdata.content}"/>">
                <br/>
            </form>
        </div>
    </c:forEach>
</ul>



<div class="modal" id="modalDialog">
    <form method="post" action="newsPage">

        <input type= "text" name="title">

        <textarea cols="45" maxlength="100" onkeyup="countf()" id="text" name="content"></textarea>
        <p style="font-size: 20px" id="count"></p>

        <input type="submit" value="Сохранить" name="putInApp">
    </form>
    <input type="button" value="Закрыть" onclick="modal_close()">

</div>


</body>

</html>

