<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/menu.jsp" %>

<% request.setCharacterEncoding("UTF-8"); %>
<p>入力されたメールアドレスに確認用URLを送信しました。</p>

<form action="login.jsp" method="post">
<input type="submit" value="ログイン画面に戻る">
</form>
