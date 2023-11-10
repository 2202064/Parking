var map;

var coord_X = (request.getAttribute("coord_x"));
var coord_Y = (request.getAttribute("coord_y"));

function initMap() {
    map = new google.maps.Map(document.getElementById('map'), {
    center: { lat: coord_X, lng: coord_Y }, // 初期の中心座標を設定
    zoom: 15,
    mapTypeId: google.maps.MapTypeId.ROADMAP,
    draggable: false
    });
}

/*
サンプル用の緯度経度
lat: 35.667379,
lng: 139.7054965
*/