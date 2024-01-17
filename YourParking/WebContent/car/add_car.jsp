<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/menu.jsp" %>
<script src="../js/add_car.js"></script>
<c:out value="${suc_message}"/>
<c:out value="${fai_message}"/>

<p>車追加</p>
<form action="../car/AddCar.action" method="post" onsubmit="return validateForm()">
  <p>車名 <input name="CAR_NAME" required></p>
  <p>車高 <input  name="HIGH" required>m</p>
  <p>車幅 <input type="text" name="WIDTH" required>m </p>
  <p>車長 <input type="text" name="LENGTH" required>m </p>
  <p>重量  <input type="text" name="WEIGHT" required>kg </p>
  <p>地上高 <input type="text" name="GROUND_HEIGHT" required>m</p>
  <input type="checkbox" name="flag" value="flag">使用車に設定する
  <input type="submit" value="追加">
</form>
</html>
