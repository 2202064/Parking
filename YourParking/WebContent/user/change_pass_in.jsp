<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/menu.jsp" %>
<%@include file="../tool/header.jsp" %>
<c:out value="${fai_message}"/>

<p>登録されているメールアドレスを入力してください</p>
<form action="/user/ChangePassIn" method="post">
<p>メールアドレス <input type="email" name="mail" required></p>
<input type="submit" value="送信">
</form>

<form action="login.jsp" method="post">
<input type="submit" value="戻る">
</form>
<%@include file="../tool/footer.html" %>