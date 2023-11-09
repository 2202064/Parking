<%@page contentType="text/html; charset=UTF-8" %>

<p>登録されているメールアドレスを入力してください</p>
<form action="confirmation_out.jsp" method="post">
<p>メールアドレス <input type="email" name="address" id="email"required></p>
<input type="submit" value="送信">
</form>

<form action="login.jsp" method="post">
<input type="submit" value="戻る">
</form>
