<%@page contentType = "text/html; charset=UTF-8" %>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>

<link rel="stylesheet" type="text/css" href="../css/parking.css">

<p>${park.parkingName}
<p>${park.prefectures}${park.municipalities}${park.street}

<div id="route_outline">
	<span  id="route_duration"></span>
	<span  id="route_distance"></span>
</div>

<div id="navi_outline">
	<span  id="navi_duration"></span>
	<span  id="navi_distance"></span>
	<span id="location_count"></span>
</div>

<span id="starting">ナビ中...</span>

<div class="map" id="map"></div>

<label for="onoff" id="navi_on">ナビを開始する</label>
<label for="onoff" id="navi_off">ナビを停止する</label>
<input type="checkbox" id="onoff">

<form id="go_review" action="#" method="post">
	<input type="submit" value="レビュー" name="${park.parkingName}">
</form>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1uZORqEffnBYn9GV7e9WiOZiYAeEfObw&callback=initMap" async defer></script>

<script src="../js/root_map2.js"></script>

<%@include file="../tool/footer.html" %>