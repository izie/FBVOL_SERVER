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
<script src="https://code.jquery.com/jquery-1.11.0.min.js"></script>
<script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
<script>

    var i = 0;

    var tempData = null;

    var timer = setInterval(function () {
        //alert('Timer Start');
        //clearInterval(timer);

        $.callAjax();
    }, 100);

    $.clearCanvas = function() {
        var canvas = document.getElementById('canvas');
        var context = canvas.getContext('2d');

        context.clearRect(0,0,600,400);
    }

    $.callAjax = function() {
        var requestUrl = '/FBVOL_SERVER/Character/getUser';

        $.ajax({
            url:requestUrl,
            type:'GET',
            error: function(){
                alert("Ajax Loading Error");
            },
            success: function(data){
                //var results = $.parseJSON(data);

                if($.checkRelease(data)){
                    $.clearCanvas();
                    for(var i = 0 ; i < data.length ; i++){
                        var oUser = data[i];
                        $.addImg(oUser.x,oUser.y,oUser.id);
                    }
                }

                tempData = data;
            }

        });
    };

    $.checkRelease = function(data) {
        if(tempData != null){
            for(var i = 0 ; i < data.length ; i++){
                var oUser = data[i];
                if(tempData[i].x != data[i].x)  return true;
                if(tempData[i].y != data[i].y)  return true;
            }
        }else   return true;
        return false;
    }

    $.addImg = function(x,y,txt) {
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