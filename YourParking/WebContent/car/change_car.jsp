<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../tool/menu.jsp" %>

<table border="1" style="border-collapse: collapse">
    <tr>
      <th>車名</th><th>車高</th><th>車幅</th><th>車長</th><th>重量</th><th>地上高</th><th>変更</th>
    </tr>
    <tr>
    	<td>${car_use.car_name}</td>
        <td>${car_use.car_high}</td>
        <td>${car_use.car_width}</td>
        <td>${car_use.car_length}</td>
        <td>${car_use.car_weight}</td>
        <td>${car_use.ground_height}</td>
        <td>使用中<td>
    <tr>
    <c:forEach items="${car}" var="car">
	    <tr>
	        <td>${car.car_name}</td>
	        <td>${car.car_high}</td>
	        <td>${car.car_width}</td>
	        <td>${car.car_length}</td>
	        <td>${car.car_weight}</td>
	        <td>${car.ground_height}</td>
	      	<form action="../car/ChaCarAction" method="get">
	      		<input type="hidden" value="${car.car_id }" name="car_id">
	        	<td><input type="submit" value="使用車変更"></td>
	      	</form>
	    <tr>
	</c:forEach>
    </tr>
</table>
