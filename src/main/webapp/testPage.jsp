<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">

    <title>testPage</title>

    <style>

        #recieverImg {
            width: 300px;
            height: 300px;
            background: #faf2c7;
            background-size: 100%;
            text-align: center;
            background-repeat: no-repeat;
        }

    </style>

    <script type="text/javascript" charset="UTF-8">

        var recieverImg;

        window.onload = function(){
            recieverImg = document.getElementById("recieverImg");
            recieverImg.ondragenter = ignoreDrag;
            recieverImg.ondragover = ignoreDrag;
            recieverImg.ondrop = drop;
        }

        function ignoreDrag(e){
            e.stopPropagation();
            e.preventDefault();
        }

        function drop(e){
            e.stopPropagation();
            e.preventDefault();

            var data = e.dataTransfer;
            var files = data.files;

            processFiles(files);
        }

        function processFiles(files) {
            var file = files[0];

            var reader = new FileReader();

            reader.onload = function (e) {
                recieverImg.style.backgroundImage = "url('" + e.target.result + "')";

            };
            reader.readAsDataURL(file);
        }

    </script>

</head>

<body>


        <div id="recieverImg">
            <div>Перетащите изображение сюда</div>
        </div>
        <input id="imgInput" type="file" onchange="processFiles(this.files)">

</div>


</body>

</html>

