<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width,initial-scale=1">
	<link rel="stylesheet" type="text/css" href="../css/review.css">
	<%@include file="../tool/menu.jsp" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<script type="text/javascript" src="../js/review.js" defer></script>
</head>

<body>
	<div id="container">
		<div class="star-container">
			<c:forEach var="i" begin="1" end="5">
			<img src="../img/star.png" alt="Star" class="star" id="star${i}" onclick="changeImage(${i})">
			</c:forEach>
		</div>

		<div>
			<label><input type="checkbox" id="saveCheckbox" onclick="valueChange()">駐車場に入れなかったか</label>
		</div>

		<p id="msg"></p>

		<form action="../parking/Review.action" method="post" onsubmit="return scoreconfirm()">
			<div id="parkingForm">
				<input type="checkbox" value="high" name="high">車高 <input type="checkbox" value="width" name="width">車幅 <input type="checkbox" value="length" name="length">車長 <input type="checkbox" value="weight" name="weight">重量 <input type="checkbox" value="ground_height" name="ground_height">地上高
			</div>
			<p>*任意</p>
			<input type="hidden" value="<%= request.getParameter("parking_id") %>" name="parking_id">
			<textarea id="comment" name="comment"></textarea>
			<input type="hidden" name="good" id="good">
			<div id="good2"></div>
			<p><input type="submit" value="投稿する"></p>
		</form>
	</div>
</body>
