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
<h2>駐車場名${park.parkingName}</h2>
<p>住所${park.prefectures}${park.municipalities}${park.street}
<p>評価${park.parkReview}

  	<div id="map" class="map"></div>

	<table>
<tr>
<td>料金</td><td>${park.parkMoney}</td>
</tr>
<tr>
<td>支払い方法</td><td>${park.parkPayment}</td>
</tr>
<tr>
<td>営業時間</td><td>${park.parkTime}</td>
</tr>
<tr>
<td>収容台数</td><td>${park.parkSpace}</td>
</tr>
<tr>
<td>重量制限</td><td>${park.parkWeight}</td>
</tr>
</table>

	<table>
<tr>
<th></th><th>車高</th><th>車幅</th><th>車長</th>
</tr>
<tr>
<td>規定値</td><td>${park.parkHigh}</td><td>${park.parkWidth}</td><td>${park.parkLength}</td>
</tr>
<tr>
<td>実寸値</td><td>${park.actualHigh}</td><td>${park.actualWidth}</td><td>${park.actualLength}</td>
</tr>
</table>
</div>

<div id="review">
<a href="review.jsp">レビュー投稿はこちら</a>
<c:forEach var="i" begin="0" end="${fn:length(review)}">
		${review.userName}<br>
		${review.userComment}
<c:choose>
<c:when test="${park.parkRating == '0'}">
<!-- ☆0のイメージを挿入 -->
</c:when>
<c:when test="${park.parkRating == '1'}">
<!-- ☆1の応じたイメージを挿入 -->
</c:when>
<c:when test="${park.parkRating == '2'}">
<!-- ☆2に応じたイメージを挿入 -->
</c:when>
<c:when test="${park.parkRating == '3'}">
<!-- ☆3に応じたイメージを挿入 -->
</c:when>
<c:when test="${park.parkRating == '4'}">
<!-- ☆4に応じたイメージを挿入 -->
</c:when>
<c:when test="${park.parkRating == '5'}">
<!-- ☆5に応じたイメージを挿入 -->
</c:when>
</c:choose>
</c:forEach>
</div>

<!-- "#" の部分に、作成したAPIキーを貼り付ける -->
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1uZORqEffnBYn9GV7e9WiOZiYAeEfObw&callback=initMap" async defer></script>

<script src="../js/parking_map.js"></script>
<script src="../js/parking.js"></script>

<%@include file="../tool/footer.html" %>