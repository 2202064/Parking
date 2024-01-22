<%@page contentType="text/html; charset=UTF-8" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>

<p>入力されたメールアドレスにURLを送信しました</p>
<form action="/user/EmailReg" method="post">
	<p>メールが送信されていない場合、以下のボタンをクリックしてください。
	<input type="submit" value="再送信">
</form>

<%@include file="../tool/footer.html" %>
