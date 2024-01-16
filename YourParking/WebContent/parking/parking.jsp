<%@page contentType = "text/html; charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>

<link rel="stylesheet" type="text/css" href="../css/parking.css">

<label for="info_btn">駐車場情報</label>
<label for="review_btn">レビュー</label>
<input type="radio" name="switch" id="info_btn" checked>
<input type="radio" name="switch" id="review_btn">
<hr>

<!-- 駐車場情報表示 -->
<div id="info">
	<h2>駐車場名 ${parking.parking_name}</h2>
	<p>住所 ${parking.prefectures}${parking.municipalities}${parking.street}</p>
	<!-- <p>評価${parking.score} -->

  	<div id="map" class="map"></div>

  	<form action="root_parking.jsp" method="post">
  		<input type="hidden" value="${parking.parking_name}" name="parking_name">
  		<input type="hidden" value="${parking.prefectures}" name="prefectures">
  		<input type="hidden" value="${parking.municipalities}" name="municipalities">
  		<input type="hidden" value="${parking.street}" name="street">
  		<input type="hidden" value="${parking.xcoord}" name="xcoord">
  		<input type="hidden" value="${parking.ycoord}" name="ycoord">
  		<input type="submit" value="ここへ行く">
  	</form>

	<table>
		<tr>
			<td>料金</td><td>${parking.park_money}</td>
		</tr>
		<tr>
			<td>支払い方法</td><td>${parking.park_payment}</td>
		</tr>
		<tr>
			<td>営業時間</td><td>${parking.park_time}</td>
		</tr>
		<tr>
			<td>収容台数</td><td>${parking.park_space}</td>
		</tr>
		<tr>
			<td>重量制限</td><td>${parking.park_weight}</td>
		</tr>
	</table>

	<table>
	<tr>
		<th></th><th>車高</th><th>車幅</th><th>車長</th>
	</tr>
		<tr>
			<td>規定値</td><td>${parking.park_high}</td><td>${parking.park_width}</td><td>${parking.park_length}</td>
		</tr>
		<tr>
			<td>実寸値</td><td>${parking.actual_height}</td><td>${parking.actual_width}</td><td>${parking.actual_length}</td>
		</tr>
	</table>
</div>

<div id="review">
	<a href="review.jsp">レビュー投稿はこちら</a>
	<c:forEach var="review" items="${review}">
		${review.user_name}<br>
		${review.comment}
		<!-- <c:choose>
			<c:when test="${parking.parkRating == '0'}"> -->
				<!-- ☆0のイメージを挿入 -->
			<!--
			</c:when>
			<c:when test="${parking.parkRating == '1'}"> -->
				<!-- ☆1の応じたイメージを挿入 -->
			<!--
			</c:when>
			<c:when test="${parking.parkRating == '2'}"> -->
				<!-- ☆2に応じたイメージを挿入 -->
			<!--
			</c:when>
			<c:when test="${parking.parkRating == '3'}"> -->
				<!-- ☆3に応じたイメージを挿入 -->
			<!--
			</c:when>
			<c:when test="${parking.parkRating == '4'}"> -->
				<!-- ☆4に応じたイメージを挿入 -->
			<!--
			</c:when>
			<c:when test="${parking.parkRating == '5'}"> -->
				<!-- ☆5に応じたイメージを挿入 -->
			<!--
			</c:when>
		</c:choose>
		-->
	</c:forEach>
</div>

<script>
    window.onload = function() {
        // Google マップ API スクリプトの読み込み
        var script = document.createElement('script');
        script.src = 'https://maps.googleapis.com/maps/api/js?key=AIzaSyA1uZORqEffnBYn9GV7e9WiOZiYAeEfObw&callback=initMap';
        document.head.appendChild(script);
    };
</script>
<script src="../js/parking_map.js"></script>
<script src="../js/parking.js"></script>

<%@include file="../tool/footer.html" %>