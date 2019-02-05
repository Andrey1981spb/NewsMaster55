<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">

    <title>newsPage</title>

    <style>

        .pushblock {
            position: relative;
            background-color: #fa9ca5;
            width: 40%;
            float: left;
            height: 100%;
        }

        .newsblock {
            position: relative;
            background-color: #fa660a;
            width: 60%;
            float: right;
            top: 0%;
            height: 100%;
        }

        .modalpush {
            position: absolute;
            background-color: #806b71;
            font-size: 30%;
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
            z-index: 9999;
        }

        .modalnews {
            position: absolute;
            background-color: #807e6a;
            font-size: 30%;
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

        .pushstack1 {
            position: absolute;
            background-color: #800921;
            top: 20%;
            bottom: 30%;
            left: 10%;
            right: 10%;
            border-style: solid;
            border: black;
            border-width: 5px;
        }

        .pushstack2 {
            position: absolute;
            background-color: #800921;
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

        function modal_news_open() {
            var modalWind2;
            modalWind2 = document.getElementById('newsModalDialog');
            modalWind2.style.display = 'block';
            document.getElementById("news_button_modal").disabled = true;
        }

        function modal_close() {
            var modalWind;
            var modalWind2;

            if (modalWind = document.getElementById('modalDialog')) {
                modalWind.style.display = 'none';
                document.getElementById("button_modal").disabled = false;
            }

            if (modalWind2 = document.getElementById('newsModalDialog')) {
                modalWind2.style.display = 'none';
                document.getElementById("news_button_modal").disabled = false;
            }

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

        function countf2() {
            var text = document.getElementById('news_text');
            var valuecounter = text.value;
            var lengthcounter = valuecounter.length;
            var maxlength = document.getElementById('news_text').getAttribute('maxlength');

            var vestige = maxlength - lengthcounter;
            var delta = document.getElementById('news_count');
            delta.innerHTML = 'осталось ' + vestige + ' знаков';
        }

    </script>

</head>

<body>

<div class="pushblock">

    <div>
        <form>
            <input type="button" id="button_modal" value="Добавить" onclick="modal_open()" />
        </form>
    </div>

    <ul class="pushstack1">
        <jsp:useBean id="listofpush" scope="request" type="java.util.List<ru.spb.push.Pushdata>" />
        <c:forEach items="${listofpush}" var="pushdata">
            <li>
                <input type="text" name="news_title" value="<c:out value="${pushdata.title}"/>">
                <input type="textarea" name="news_content" cols="45" maxlength="100"
                       value="<c:out value="${pushdata.content}"/>">
            </li>
        </c:forEach>
    </ul>


    <div class="modalpush" id="modalDialog">
        <form method="post" action="newsPage">

            <input type="text" name="title">

            <textarea cols="45" maxlength="100" onkeyup="countf()" id="text" name="content"></textarea>
            <p style="font-size: 20px" id="count"></p>

            <input type="submit" value="Сохранить" name="modalForm1">
        </form>
        <input type="button" value="Закрыть" onclick="modal_close()">

    </div>

</div>


<div class="newsblock">

    <div>
        <form>
            <input type="button" id="news_button_modal" value="Добавить новость" onclick="modal_news_open()" />
        </form>
    </div>


    <ul class="pushstack2">
        <jsp:useBean id="listofnews" scope="request" type="java.util.List<ru.spb.push.Newsdata>" />
        <c:forEach items="${listofnews}" var="newsdata">
            <li>
                <input type="text" name="news_title" value="<c:out value="${newsdata.title_news}"/>">
                <input type="textarea" name="news_content" cols="45" maxlength="100"
                       value="<c:out value="${newsdata.content_news}"/>">
                <img src="${pageContext.request.contextPath}/${newsdata.urlimage}">
                </form>
            </li>
        </c:forEach>
    </ul>

    <div class="modalnews" id="newsModalDialog">
        <form method="post" action="newsPage">

             <textarea cols="45" maxlength="100" onkeyup="countf2()"
                       name="title_news" value="title_news"></textarea>

            <textarea cols="45" maxlength="100" onkeyup="countf2()" id="news_text"
                      name="content_news" value="content_news"></textarea>
            <p style="font-size: 20px" id="news_count"></p>

            <input type="submit" value="Сохранить" name="modalForm2">
        </form>
        <input type="button" value="Закрыть" onclick="modal_close()">

    </div>

</div>

<div>
    <form method="post" action="newsPage">
        <input type="hidden" name="forDirection">
        <input type="submit" value="Для руководителя" name="forDirection">

    </form>

</div>


</body>

</html>

