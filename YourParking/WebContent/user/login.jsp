<%@page contentType="text/html; charset=UTF-8" %>

<link rel="stylesheet" type="text/css" href="../css/login.css">
<script src="../js/login.js"></script>
<p>ログイン情報をご入力ください</p>
<form action="Login.action" method="post">
  <p>メールアドレス:<input type="email" name="address" id="email"></p>
  <p id="email-error"></p>
  <p>パスワード <input type="password" name="pass" pattern=".{8,}" title="8文字以上のパスワードを入力してください" required></p>
  <p id="password-error"></p>
  <p><a href="confirmation_in.jsp">メールアドレスまたはパスワードを忘れた場合はこちら</a></p>
  <input type="submit" value="ログイン" class="example4">
</form>
