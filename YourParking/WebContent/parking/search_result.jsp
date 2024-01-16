<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Parking</title>
</head>
<body>

<h2>検索結果一覧</h2>

<c:forEach var="parking" items="${parking}">
	<form action="../parking/ParkingInfo" method="post">
		${parking.prefectures}${parking.municipalities}${parking.street}<br>
    	${parking.parking_name}<br>
    	<input type="hidden" value="${parking.parking_id}" name="parking_id">
    	<input type="submit" value="詳しく見る">
    </form>
    <hr>
</c:forEach>

</body>
</html>