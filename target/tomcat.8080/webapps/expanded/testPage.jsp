<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>

    <meta http-equiv="Content-Type" content="text/html charset=UTF-8">

    <title>testPage</title>

    <style>

    </style>


    <script type='text/javascript' src='js/jquery-3.3.1.js'></script>

    <script type="text/javascript">

            $('a[name=downlist]').click(function(){
                $('#downlist').slideToggle(500);
            });


            $(function() {
                alert ('jQuery подключен и отлично работает!');
            });

    </script>

</head>

<body>

<a name="downlist" href="javascript:void(0);">Открыть/закрыть</a>
<div id="downlist" style="display:none">
    <p>Содержимое блока, который<br />
        открывается после клика.</p>
    <p>Содержимое блока, который<br />
        открывается после клика.</p>
    <p>Содержимое блока, который<br />
        открывается после клика.</p>
</div>


</body>

</html>

</html>

