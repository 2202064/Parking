var map;
const sample_X = 35.667379;
const sample_Y = 139.7054965;

function initMap() {
    const initialLatLng = new google.maps.LatLng(sample_X, sample_Y);

    const mapOptions = {
        center: initialLatLng,
        zoom: 15,
        mapTypeId: google.maps.MapTypeId.ROADMAP,
        draggable: false,
    };

    map = new google.maps.Map(document.getElementById('map'), mapOptions);

    const marker = new google.maps.Marker({
        position: initialLatLng,
        icon: {
        	url: "../img/parking.png",
        	scaledSize : new google.maps.Size(50, 50)
        },
    });

    marker.setMap(map);
}

window.initMap = initMap;