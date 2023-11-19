<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../tool/menu.jsp" %>

<c:out value="${suc_message}"/>
<c:out value="${fai_message}"/>
<table border="1" style="border-collapse: collapse">
  <c:forEach items="${sessionScope.cars}" var="car">
    <tr>
      <th>CarName</th><th>CarHigh</th><th>CarWidth</th><th>CarLength</th><th>CarWeight</th><th>GroundHeight</th><th>Action</th>
    </tr>
    <tr>
      <form action="UpdCar.action" method="post">
        <input type="hidden" name="car_id" value="${car.car_id}">
        <td><input name="car_name" value="${car.car_name}"></td>
        <td><input name="car_high" value="${car.car_high}"></td>
        <td><input name="car_width" value="${car.car_width}"></td>
        <td><input name="car_length" value="${car.car_length}"></td>
        <td><input name="car_weight" value="${car.car_weight}"></td>
        <td><input name="ground_height" value="${car.ground_height}"></td>
        <td><input type="submit" value="修正"></td>
      </form>

    </tr>
  </c:forEach>
</table>

