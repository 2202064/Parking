<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../tool/menu.jsp" %>
<form action="../user/Registration" method="post">
	<c:out value="${ message}"/>
	名前：<input name="name">
	電話番号：<input name="phone">
	メール：<input type="email" name="mail">
	ユーザー名：<input name="user_id">
	クレカ：<input name="credit">
	パス：<input type="password" name="pass">
	パス２：<input type="password" name="kakunin">
	<input type="submit" value="送信">
</form>
