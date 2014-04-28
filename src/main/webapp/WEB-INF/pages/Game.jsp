<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<!DOCTYPE HTML>
<html>
<head>
    <style>
        body {
            margin: 0px;
            padding: 0px;
        }
    </style>
</head>

<body>
<div id="container"></div>

<script type="text/javascript" src="${url}/resources/js/jquery-2.1.0.min.js" th:src="@{/resources/js/jquery-2.1.0.min.js}"></script>
<script type="text/javascript" src="${url}/resources/js/kinetic-v5.1.0.js" th:src="@{/resources/js/kinetic-v5.1.0.js"></script>
<script defer="defer">

    var i = 0;

    var gWidth = 800;
    var gHeight = 600;

    var userData = {};

    var kimages = {};

    var profile_pic = {
        dkjo91: 'https://fbcdn-profile-a.akamaihd.net/hprofile-ak-frc3/t1.0-1/c35.35.443.443/s160x160/484064_384552564940063_232438685_n.jpg',
        tkdxo0624: 'https://fbcdn-profile-a.akamaihd.net/hprofile-ak-prn2/t1.0-1/p160x160/10256603_833148846699423_3550347983526187_n.jpg'
    };

    var bg_pic = "http://wsp.wooribank.com/download/0008830890_041/0008830890_18467.JPG";
    var bgimage = null;

    var stage = null;

    var layer = null;
    // Ball
    var ball = null;

    //Fence
    var fence = null;

    // Ground
    var ground = null;

    // ScoreBoard
    var scoreBoard_1 = null;
    var score_A = 0;
    var scoreBoard_2 = null;
    var score_B = 0;

    var ballMode = 'move';

    // Gravity
    var grav_x = 0;
    var grav_y = 9;

    // Start Point
    var start_x;
    var start_y;

    // BAll Speed
    var speed_x;
    var speed_y;

    var debugTxt = null;
    
    var numUser = 0;


    /*var timer = setInterval(function () {
     //alert('Timer Start');
     //clearInterval(timer);

     $.callAjax();
     }, 1000);*/

    $.Init = function() {
        $.initStage();
        $.initRes();
        $.initVar();
        $.initAnim();

        $.gameStart();

        //$.callAjax();
    }

    $.initStage = function() {
        stage = new Kinetic.Stage({
            container: 'container',
            width: gWidth,
            height: gHeight
        });

        layer = new Kinetic.Layer();
    }

    $.initRes = function() {
        // Ball
        ball = new Kinetic.Circle({
            x: 150,
            y: 50,
            radius: 30,
            fill: 'red',
            stroke: 'black',
            strokeWidth: 1
        });

        ball.setOffset(100, 30);

        // Fence
        fence = new Kinetic.Rect({
            x:stage.getWidth() / 2,
            y:400,
            width:10,
            height:200,
            fill:'blue',
            stroke: 'black',
            strokeWidth: 4
        });

        // Ground
        ground = new Kinetic.Rect({
            x:0,
            y:595,
            width:800,
            height:5,
            fill:'grey',
            strokeWidth: 0
        });

        // ScoreBoard
        scoreBoard_1 = new Kinetic.Text({
            x:200,
            y:30,
            text: '0',
            fontSize: 30,
            fontFamily: 'Calibri',
            fill: 'white'
        });

        // ScoreBoard
        scoreBoard_2 = new Kinetic.Text({
            x:700,
            y:30,
            text: '0',
            fontSize: 30,
            fontFamily: 'Calibri',
            fill: 'white'
        });

        // Debug Text
        debugTxt = new Kinetic.Text({
            x: 0,
            y: 15,
            text: 'Debug',
            fontSize: 10,
            fontFamily: 'Calibri',
            fill: 'green'
        });

        bgimage = new Image();

        var imageObj = new Image();
        imageObj.onload = function() {
            var yoda = new Kinetic.Image({
                x: 0,
                y: 0,
                image: imageObj,
                width: 800,
                height: 600
            });

            // add the shape to the layer
            layer.add(yoda);
            layer.add(debugTxt);


            // add the shape to the layer
            layer.add(ball);
            layer.add(fence);
            layer.add(scoreBoard_1);
            layer.add(scoreBoard_2);
            layer.add(ground);

            stage.add(layer);
        };
        imageObj.src = bg_pic;


    }

    $.initVar = function() {
        speed_x = 0;
        speed_y = 0;
    }

    $.callAjax = function() {
        var requestUrl = '${url}/User/getUser';

        $.ajax({
            url:requestUrl,
            type:'GET',
            error: function(){
                alert("Ajax Loading Error");
            },
            success: function(data){
                var images = {};
                var k = 0;
                //var results = $.parseJSON(data);
                for(var i = 0 ; i < data.length ; i++){
                    var oUser = data[i];

                    if(numUser != 0){
                        kimages[i].setX(oUser.x);
                        kimages[i].setY(oUser.y);
                        kimages[i].setOffset(40, 40);
                    }else{
                        //$.addImg(oUser.x,oUser.y,oUser.id);
                        images[oUser.id] = new Image();

                        images[oUser.id].onload = function() {
                            //alert(images[numUser].src);
                            kimages[numUser] = new Kinetic.Image({
                                image: images[data[numUser].id],
                                x: data[numUser].x,
                                y: data[numUser].y,
                                width:80,
                                height:80,
                                draggable: true
                            });

                            kimages[numUser].setOffset(40, 40);

                            //alert(data[numUser].id+"/"+data[numUser].x+"/"+data[numUser].y);
                            layer.add(kimages[numUser]);

                            numUser++;
                            stage.add(layer);
                        };

                        images[oUser.id].src = profile_pic[oUser.id];
                    }

                }




                // finally, we need to redraw the layer hit graph
                layer.drawHit();



                /*
                 if($.checkRelease(data)){
                 $.clearCanvas();
                 for(var i = 0 ; i < data.length ; i++){
                 var oUser = data[i];
                 $.addImg(oUser.x,oUser.y,oUser.id);
                 }
                 }*/

                userData = data;


            }

        });
    };

    $.initAnim = function() {
        var firstTime = 0;
        $.callAjax();
        anim = new Kinetic.Animation(function(frame){
            //console.log((frame.time / 1000) - firstTime);
            if((frame.time / 35) - firstTime >= 1){
                //console.log("check");
                firstTime = frame.time / 35;
                $.callAjax();
            }
            if (ballMode == 'move'){

                var tmod = (frame.timeDiff) * 0.005;

                // 속도 만큼 공을 움직인다.
                ball.setX(ball.getX() + (speed_x * tmod));
                ball.setY(ball.getY() + (speed_y * tmod));

                // 속도가 중력가속도의 영향을 받는다.
                //speed_x += tmod;
                speed_y += grav_y * tmod;

                // Boundary Check
                if(ball.getX() <=30){
                    if(speed_x < 0)
                        speed_x = speed_x * -1;

                }
                if(ball.getX() >= 770){
                    if(speed_x > 0)
                        speed_x = speed_x * -1;

                }
                if(ball.getY() <= 30){
                    if(speed_y < 0)
                        speed_y = speed_y * -1;

                }
                debugTxt.setText("A : "+score_A+"B : "+score_B);
                if(ball.getY() > gHeight){
                    //ballMode = 'stop';
                    if(ball.getX() < 400){
                        score_B++;
                        scoreBoard_2.setText(score_B);
                    }else{
                        score_A++;
                        scoreBoard_1.setText(score_A);
                    }
                    ball.setX(150);
                    ball.setY(50);


                    speed_x = 0;
                    speed_y = 0;



                }

                $.isCollision(ball.getX(),ball.getY()); // 사람체크
                $.isCollision2(ball.getX(),ball.getY()); // 울타리체크
            }

        },layer);
    }

    $.isCollision = function(x1,y1){

        //debugTxt.setText("kimages : "+numUser);
        for(i = 0 ; i < numUser ; i++){
            var x2 = kimages[i].getX();
            var x3 = kimages[i].getX() +80;

            var y2 = kimages[i].getY();
            var y3 = kimages[i].getY() +80;
            
            

            //debugTxt.setText("x : "+speed_x);

            if((x2 <= x1 && x1 <= x3) && (y2 <= y1 && y1 <= y3)){
                //debugTxt.setText("collision!"+speed_x);
                speed_y = -50;

                speed_x = (x1 - (kimages[i].getX()+40)) * 1.5;
            }else{

                //debugTxt.setText("no collision");
            }
        }

    }

    $.isCollision2 = function(x1,y1){

        var x2 = fence.getX() ;
        var x3 = fence.getX() +10;

        var y2 = fence.getY() ;
        var y3 = fence.getY() + 200;

        /*if(((x2 <= x1 && x1 < fence.getX()) || ((fence.getX() < x1 && x1 <= x3)) && (y2 < y1 && y1 <= y3))){
            speed_x = (x1 - fence.getX()) * 0.8;
        }
        else{
            speed_y = -50;

        }      x2 = 왼쪽벽 x3가 오른쪽 벽     y2가 네트 위
        */
        if((x2 <= x1 && x1 <= x3) && (y2  <= y1 && y1 <= y3)){
            debugTxt.setText("collision!"+speed_x);
            speed_x = speed_x * -0.9;
            speed_y = -20;

        }else{

            //debugTxt.setText("no collision");
        }

    }

    $.gameStart = function() {
        anim.start();
    }

    $.Init
            ();
</script>
</body>
</html>