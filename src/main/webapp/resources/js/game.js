var i = 0;

var userData = {};

var kimages = {};

var profile_pic = {
    prugio: 'https://fbcdn-profile-a.akamaihd.net/hprofile-ak-frc3/t1.0-1/c35.35.443.443/s160x160/484064_384552564940063_232438685_n.jpg',
    izie: 'https://fbcdn-profile-a.akamaihd.net/hprofile-ak-prn2/t1.0-1/p160x160/10256603_833148846699423_3550347983526187_n.jpg'
};

var stage = new Kinetic.Stage({
    container: 'container',
    width: 578,
    height: 200
});

var layer = new Kinetic.Layer();

/*var timer = setInterval(function () {
    //alert('Timer Start');
    //clearInterval(timer);

    $.callAjax();
}, 1000);*/



$.callAjax = function() {
    var requestUrl = '/Character/getUser';

    $.ajax({
        url:requestUrl,
        type:'GET',
        error: function(){
            alert("Ajax Loading Error");
        },
        success: function(data){
            var images = {};
            //var results = $.parseJSON(data);
            for(var i = 0 ; i < data.length ; i++){
                var oUser = data[i];
                //$.addImg(oUser.x,oUser.y,oUser.id);
                images[oUser.id] = new Image();

                images[oUser.id].onload = function() {

                };

                images[oUser.id].src = profile_pic[oUser.id];

                kimages[oUser.id] = new Kinetic.Image({
                    image: images.monkey,
                    x: 120,
                    y: 50
                });

                layer.add(kimages[oUser.id]);
            }

            stage.add(layer);

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

            tempData = data;
        }

    });
};

$.callAjax();