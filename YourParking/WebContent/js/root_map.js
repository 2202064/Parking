var directionsService;
var directionsRenderer;
var map;

var dest_X = document.getElementById("dest_x")
var dest_Y = document.getElementById("dest_y")
var onOff = document.getElementById("onoff")
var navi_On = document.getElementById("navi_on")
var navi_Off = document.getElementById("navi_off")
var starting = document.getElementById("starting")
var routeOutLine = document.getElementById("route_outline")
var naviOutLine = document.getElementById("navi_outline")
var flag = false

onOff.style.display = 'none';
navi_On.style.display = 'block';
navi_Off.style.display = 'none';
starting.style.display = 'none';
routeOutLine.style.display = 'block';
naviOutLine.style.display = 'none';

function initMap() {
	directionsService = new google.maps.DirectionsService();
	directionsRenderer = new google.maps.DirectionsRenderer({ suppressMarkers: true });

    var mapOptions = {
    	zoom: 10,
    	center: { lat: dest_X, lng: dest_Y }
    };

    map = new google.maps.Map(document.getElementById('map'), mapOptions);
    directionsRenderer.setMap(map);

    calculateRoute();

    onOff.addEventListener('change',function(){
        if(this.checked) {
        	navi_On.style.display = 'none';
        	navi_Off.style.display = 'block';
        	starting.style.display = 'block';
        	routeOutLine.style.display = 'none';
        	naviOutLine.style.display = 'block';

        	navigator.geolocation.watchPosition(updateLocation, handleLocationError);
        } else{
        	navi_On.style.display = 'block';
        	navi_Off.style.display = 'none';
        	starting.style.display = 'none';
        	routeOutLine.style.display = 'block';
        	naviOutLine.style.display = 'none';

        	calculateRoute();
        }
    });
}

// ルート表示
function calculateRoute() {
	function success(pos) {
		var lat = pos.coords.latitude;
		var lng = pos.coords.longitude;
		var start = new google.maps.LatLng(lat, lng); // 利用者
		var end = { lat: dest_X, lng: dest_Y }; // 目的地
		var serviceMatrix = new google.maps.DistanceMatrixService();
	    var request = {
	        origin: start,
	        destination: end,
	        travelMode: 'DRIVING',
	        unitSystem: google.maps.UnitSystem.METRIC,  // メートル単位表示
			provideRouteAlternatives: false, // 複数の代替ルート表示不可
			avoidHighways: true, // 高速道路参照不可
			avoidTolls: true, // 有料交通道路参照不可
	    };

	    directionsService.route(request, function(result, status) {
	        if (status == 'OK') {
	            directionsRenderer.setDirections(result);

	            var startMarker = new google.maps.Marker({ // 利用者のピン
	                position: start,
	                map: map,
	                icon: {
	                	url:'../img/user.png',
	                	scaledSize: new google.maps.Size(30, 30),
	                	scale: 1,
	                },
	            });

	            var endMarker = new google.maps.Marker({ // 目的地のピン
	                position: end,
	                map: map,
	                icon: {
	                	url:'../img/parking.png',
	                	scaledSize: new google.maps.Size(50, 50),
	                	scale: 1,
	                },
	            });
	        } else {
	            console.error('Error:', status);
	        }
	    });

	    serviceMatrix.getDistanceMatrix({
	    	origins: [start],
	        destinations: [end],
	        travelMode: 'DRIVING',
	        unitSystem: google.maps.UnitSystem.METRIC,  // メートル単位表示
	    	avoidHighways: true, // 高速道路参照不可
	    	avoidTolls: true, // 有料交通道路参照不可
	    }, callback);

	    function callback(response, status) {
	    	if (status == "OK") {
	            var element = response.rows[0].elements[0];
	            var duration = element.duration.text;
	            var distance = element.distance.text;
	            var routeDuration = document.getElementById("route_duration");
	            var routeDistance = document.getElementById("route_distance");

	            routeDuration.innerHTML = "目的地までおよそ" + duration + "です。";
	            routeDistance.innerHTML = "距離は" + distance + "です。";
	        } else {
	            console.error('Error:', status);
	        }
	    }
	}

	function fail(error) {
		alert('位置情報の取得に失敗しました。エラーコード：' + error.code);
		var latlng = new google.maps.LatLng(35.6895,139.6917 ); //東京
		var map = new google.maps.Map(document.getElementById('maps'), {
			zoom: 10,
			center: latlng
		});
	}
	navigator.geolocation.getCurrentPosition(success, fail);
}

// ナビゲーション
function updateLocation(pos) {
	var lat = pos.coords.latitude;
	var lng = pos.coords.longitude;
	var start = new google.maps.LatLng(lat, lng); // 利用者
	var end = { lat: dest_X, lng: dest_Y }; // 目的地

	navigationRoute(start, end);
}

function handleLocationError(error) {
    alert('位置情報の取得に失敗しました。エラーコード：' + error.code);
}

function navigationRoute(start, end) {
	var serviceMatrix = new google.maps.DistanceMatrixService();
	var serviceImperial = new google.maps.DistanceMatrixService();
	var request = {
        origin: start,
        destination: end,
        travelMode: 'DRIVING',
        unitSystem: google.maps.UnitSystem.METRIC,  // メートル単位表示
		provideRouteAlternatives: false, // 複数の代替ルート表示不可
		avoidHighways: true, // 高速道路参照不可
		avoidTolls: true, // 有料交通道路参照不可
	};

	directionsService.route(request, function(result, status) {
	    if (status == 'OK') {
	        directionsRenderer.setDirections(result);

	        var startMarker = new google.maps.Marker({ // 利用者のピン
	            position: start,
	            map: map,
	            icon: {
	                url:'../img/user.png',
	                scaledSize: new google.maps.Size(30, 30),
	                scale: 1,
	            },
	        });

	        var endMarker = new google.maps.Marker({ // 目的地のピン
	        	position: end,
	            map: map,
	            icon: {
	                url:'../img/parking.png',
	                scaledSize: new google.maps.Size(50, 50),
	                scale: 1,
	            },
	        });
	    } else {
	        console.error('Error:', status);
	    }
	});

	// メートル単位で距離を取得
	serviceMatrix.getDistanceMatrix({
	    origins: [start],
	    destinations: [end],
	    travelMode: 'DRIVING',
	    unitSystem: google.maps.UnitSystem.METRIC,  // メートル単位表示
	    avoidHighways: true, // 高速道路参照不可
	    avoidTolls: true, // 有料交通道路参照不可
	}, callbackMetric);

	// マイル単位で距離を取得
	serviceImperial.getDistanceMatrix({
	    origins: [start],
	    destinations: [end],
	    travelMode: 'DRIVING',
	    unitSystem: google.maps.UnitSystem.IMPERIAL,
	}, callbackImperial);

	function callbackMetric(response, status) {
	    if (status == "OK") {
	        var element = response.rows[0].elements[0];
	        var duration = element.duration.text;
	        var distance = element.distance.text;
	        var naviDuration = document.getElementById("navi_duration");
	        var naviDistance = document.getElementById("navi_distance");

	        naviDuration.innerHTML = "目的地までおよそ" + duration + "です。";
	        naviDistance.innerHTML = "距離は" + distance + "です。";

	    } else {
	    	console.error('エラー (メートル):', status);
	    }
	}

	function callbackImperial(response, status) {
	    if (status == 'OK') {
	        var element = response.rows[0].elements[0];
	        var distance = element.distance.value;  // メートル単位での距離
	        var distanceInMiles = distance * 0.000621371;  // マイル単位に変換
	        if (distanceInMiles <= 0.0621371 && !flag) {
	        	flag = true;
	        	alert("運転お疲れ様です！\n15秒後にレビュー画面が開きます\nより良い駐車場案内のためにぜひレビューをお願いします!")
	        	setTimeout(function() {
	        		document.getElementById("go_review").submit();
	        	}, 15000);
	        }
	    } else {
	        console.error('エラー (マイル):', status);
	    }
	}

	function fail(error) {
		alert('位置情報の取得に失敗しました。エラーコード：' + error.code);
	}
}
