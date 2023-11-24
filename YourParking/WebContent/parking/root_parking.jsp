<%@page contentType = "text/html; charset=UTF-8" %>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>

<link rel="stylesheet" type="text/css" href="../css/parking.css">

<p>${park.parkingName}
<p>${park.prefectures}${park.municipalities}${park.street}

<div>
	<span  id="route-duration"></span>
	<span  id="route-distance"></span>
</div>

<div class="map" id="map"></div>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1uZORqEffnBYn9GV7e9WiOZiYAeEfObw&callback=initMap" async defer></script>

<script src="../js/root_map.js"></script>

<%@include file="../tool/footer.html" %>