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
        scrollwheel: false
    };

    map = new google.maps.Map(document.getElementById('map'), mapOptions);

    const icon = "../img/parking.png";
    const marker = new google.maps.Marker({
        position: initialLatLng,
        icon: icon,
        map: map,
    });
    marker.addListener('error', function(e) {
        console.error('Marker failed to load:', e);
    });

}

window.initMap = initMap;