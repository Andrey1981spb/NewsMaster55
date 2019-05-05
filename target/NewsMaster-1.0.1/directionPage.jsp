<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">

    <title>newsPage</title>

    <style>

        .pushblock {
            position: relative;
            background-color: #faf2c7;
            width: 100%;
            float: left;
            height: 100%;
            z-index: 2;
        }


        .modalpush {
            position: absolute;
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
            z-index: 1000;
        }


        .dirstack {
            position: absolute;
            background-color: #807361;
            top: 20%;
            bottom: 30%;
            left: 10%;
            right: 10%;
            border-style: solid;
            border: black;
            border-width: 5px;
        }

    </style>

    <script type="text/javascript" charset="UTF-8">

        function modal_open() {
            var modalWind;
            modalWind = document.getElementById('modalDialog');
            modalWind.style.display = 'block';
            document.getElementById("button_modal").disabled = true;
        }


        function modal_close() {

            var modalWind = document.getElementById('modalDialog');
            modalWind.style.display = 'none';
            document.getElementById("button_modal").disabled = false;

        }

        function countf() {
            var text1;
            var text2;

            if (text1 = document.getElementById('text1')) {
                var valuecounter = text1.value;
                var lengthcounter = valuecounter.length;
                var maxlength = document.getElementById('text1').getAttribute('maxlength')
                var vestige = maxlength - lengthcounter;
                var delta = document.getElementById('count1');
                delta.innerHTML = 'осталось ' + vestige + ' знаков'
            }

            if (text2 = document.getElementById('text2')) {
                var valuecounter = text2.value;
                var lengthcounter = valuecounter.length;
                var maxlength = document.getElementById('text2').getAttribute('maxlength')
                var vestige = maxlength - lengthcounter;
                var delta = document.getElementById('count2');
                delta.innerHTML = 'осталось ' + vestige + ' знаков'
            }

        }

    </script>

</head>

<body>

<div class="pushblock">

    <div>
        <form>
            <input type="button" id="button_modal" value="Добавить" onclick="modal_open()"/>
        </form>
    </div>

    <ul>
        <jsp:useBean id="listofdirs" scope="request" type="java.util.List<ru.spb.push.directions.Directiondata>"/>
        <c:forEach items="${listofdirs}" var="directiondata">
            <div class="dirstack">
                <form>
                    <p>Трудоустройство</p>
                    <input type="textarea" name="job" onkeyup="countf()" cols="45" maxlength="400"
                           value="<c:out value="${directiondata.job}"/>">
                    <p>Поступление</p>
                    <input type="textarea" name="admission" onkeyup="countf()" cols="45" maxlength="400"
                           value="<c:out value="${directiondata.admission}"/>">
                    <br/>
                </form>
            </div>
        </c:forEach>
    </ul>


    <div class="modalpush" id="modalDialog">
        <form method="post" action="newsPage">

            <textarea cols="45" maxlength="100" onkeyup="countf()" id="text1" name="job"></textarea>
            <p style="font-size: 20px" id="count1"></p>

            <textarea cols="45" maxlength="100" onkeyup="countf()" id="text2" name="admission"></textarea>
            <p style="font-size: 20px" id="count2"></p>

            <input type="submit" value="Сохранить" name="modalDirection">
        </form>
        <input type="button" value="Закрыть" onclick="modal_close()">

    </div>

</div>


</body>

</html>

