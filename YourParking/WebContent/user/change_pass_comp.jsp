<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/menu.jsp" %>
<%@include file="../tool/header.jsp" %>
<c:out value="${message}"/>

<p>パスワードの変更が完了しました

<form action="/user/login.jsp" method="post">
	<input type="submit" value="ログイン画面に戻る">
</form>

<%@include file="../tool/footer.html" %>