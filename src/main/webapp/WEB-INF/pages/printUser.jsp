<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>

<html>
<head>

</head>

<body>
<canvas id='canvas' width='600' height='400'>
    Canvas not supported
</canvas>
<script>

    var i = 0;
    <c:forEach var="element" items="${users}">
    addImg(${element.x},${element.y},"${element.id}")

    </c:forEach>

    function addImg(x,y,txt) {
        var canvas = document.getElementById('canvas');
        var context = canvas.getContext('2d');

        context.lineJoin = 'round';
        context.lineWidth = 30;

        context.font = '24px Helvetica';
        context.fillText(txt, x, y);


        var image = new Image();

        image.onload = function() {
            context.drawImage(image, x, y);
        }

        image.src = "http://megaicons.net/static/img/icons_sizes/40/110/128/pikachu-icon.png";
        i++;
    }

</script>
</body>
</html>