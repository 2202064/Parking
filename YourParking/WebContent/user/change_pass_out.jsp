<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/menu.jsp" %>
<%@include file="../tool/header.jsp" %>
<c:out value="${message}"/>

<form action="../user/ChangePassComp" method="post">
	パス：<input type="password" name="pass">
	パス２：<input type="password" name="kakunin">
	<input type="submit" value="送信">
</form>

<%@include file="../tool/footer.html" %>