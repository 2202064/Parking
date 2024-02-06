<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/menu.jsp" %>
<head>
<script src="../js/add_car.js"></script>
<meta name="viewport" content="width=device-width,initial-scale=1">
<link href="../css/add_car.css" rel="stylesheet">
</head>
<body>
<div id ="container">


<form action="../car/AddCar.action" method="post" onsubmit="return validateForm()">
  	<p id="success"><c:out value="${suc_message}"/></p>
  	<p id="fialed"><c:out value="${fai_message}"/></p>
  	<h3 id="info">車追加</h3><hr>
  	<label for="CAR_NAME">車名</label> <input  name="CAR_NAME" required><br>
  	<p><label for="HIGH">車高</label> <input type="number" name="HIGH" required step="0.01" pattern="[0-9]+(\.[0-9]+)?">m</p>
  	<p><label for="WIDTH">車幅</label> <input type="number" name="WIDTH" required step="0.01" pattern="[0-9]+(\.[0-9]+)?">m </p>
  	<p><label for="LENGTH">車長</label> <input type="number" name="LENGTH" required step="0.01" pattern="[0-9]+(\.[0-9]+)?">m </p>
  	<p><label for="WEIGHT">重量</label> <input type="number" name="WEIGHT" required step="0.01" pattern="[0-9]+(\.[0-9]+)?">kg </p>
  	<p><label for="GROUND_HEIGHT">地上高</label> <input type="number" id="g_height"  name="GROUND_HEIGHT" required step="0.01" pattern="[0-9]+(\.[0-9]+)?">m</p>
  	<c:if test="${first > 0}">
   		<p><input type="checkbox" name="flag" value="flag">使用車に設定する</p>
	</c:if>
	<input type="submit" value="追加">
		</form>
	</div>
</body>