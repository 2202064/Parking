<%@page contentType = "text/html; charset=UTF-8" %>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>

<link rel="stylesheet" type="text/css" href="../css/parking.css">

<%
String parkingName = request.getParameter("parking_name");
String prefectures = request.getParameter("prefectures");
String municipalities = request.getParameter("municipalities");
String street = request.getParameter("street");
Float xcoord = Float.parseFloat(request.getParameter("xcoord"));
Float ycoord = Float.parseFloat(request.getParameter("ycoord"));
%>

<p><%= parkingName %>
<p><%= prefectures %><%= municipalities %><%= street %>

<input type="hidden" value="<%= xcoord %>" name="xcoord">
<input type="hidden" value="<%= ycoord %>" name="ycoord">

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
	<input type="hidden" value="<%= parkingName %>" name="parking_name">
	<input type="submit" value="レビュー">
</form>

<script>
    window.onload = function() {
        // Google マップ API スクリプトの読み込み
        var script = document.createElement('script');
        script.src = 'https://maps.googleapis.com/maps/api/js?key=AIzaSyA1uZORqEffnBYn9GV7e9WiOZiYAeEfObw&callback=initMap';
        document.head.appendChild(script);
    };
</script>

<script src="../js/root_map.js"></script>

<%@include file="../tool/footer.html" %>