<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../tool/menu.jsp" %>
yeah
<c:out value="${ user.flag}"/>
<c:out value="${ user.user_id}"/>
<c:out value="${ user.name}"/>
<c:out value="${ user.mail}"/>
<c:out value="${ user.phone}"/>
<c:out value="${ user.pass}"/>
<c:out value="${ user.user_name}"/>
<c:out value="${ user.flag}"/>

<c:out value="${suc_message}"/>
<table border="1" style="border-collapse: collapse">
  <c:forEach items="${sessionScope.cars}" var="car">
    <tr>
      <th>CarName</th><th>CarHigh</th><th>CarWidth</th><th>CarLength</th><th>CarWeight</th><th>GroundHeight</th><th>Action</th>
    </tr>
    <tr>
      <form action="UpdCar.action" method="post"> <!-- Move form tag outside the table row -->
        <input type="hidden" name="car_id" value="${car.car_id}">
        <td><input name="car_name" value="${car.car_name}"></td>
        <td><input name="car_high" value="${car.car_high}"></td>
        <td><input name="car_width" value="${car.car_width}"></td>
        <td><input name="car_length" value="${car.car_length}"></td>
        <td><input name="car_weight" value="${car.car_weight}"></td>
        <td><input name="ground_height" value="${car.ground_height}"></td>
        <td><input type="submit" value="修正"></td>
      </form> <!-- Close the form tag here -->

    </tr>
  </c:forEach>
</table>

