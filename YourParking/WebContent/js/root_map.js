var directionsService;
var directionsRenderer;
var map;

/*
var destination_X = document.getElementById("dest_x")
var destination_Y = document.getElementById("dest_y")
*/

function initMap() {
	directionsService = new google.maps.DirectionsService();
	directionsRenderer = new google.maps.DirectionsRenderer({ suppressMarkers: true });

    var mapOptions = {
    	zoom: 10,
        center: { lat: 35.6895, lng: 139.6917 }  // Tokyo
    };

    map = new google.maps.Map(document.getElementById('map'), mapOptions);
    directionsRenderer.setMap(map);

    calculateRoute();
}

function calculateRoute() {
	function success(pos) {
		var lat = pos.coords.latitude;
		var lng = pos.coords.longitude;
		var start = new google.maps.LatLng(lat, lng); // 利用者
		var end = /* { lat: dest_X, lng: dest_y }; */ { lat: 35.667379, lng: 139.7054965}; // 大阪
		var service = new google.maps.DistanceMatrixService();
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

	    service.getDistanceMatrix({
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
	            var routeDuration = document.getElementById("route-duration");
	            var routeDistance = document.getElementById("route-distance");

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
