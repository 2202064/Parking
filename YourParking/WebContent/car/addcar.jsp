<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../tool/menu.jsp" %>
<c:out value="${suc_message}"/>
<c:out value="${fai_message}"/>
<form action="AddCar.action" method="POST">
    車の名前：<input name="CAR_NAME">
    車高：<input name="HIGH">
    車幅：<input name="WIDTH">
    車長：<input name="LENGTH">
    重量：<input name="WEIGHT">
    地上高:<input name="GROUND_HEIGHT">
    <input type="submit" value="送信">
</form>
