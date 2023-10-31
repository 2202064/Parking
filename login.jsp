<%@page contentType="text/html; charset=UTF-8" %>

<p>ログイン情報をご入力ください</p>
<form action="login-out.jsp" method="post" onsubmit="return validateForm()">
  <p>メールアドレス:<input type="text" name="adress"></p>
  <p>パスワード:<input type="password" name="password"></p>
  <p><a href="login">メールアドレスまたはパスワードを忘れた場合はこちら</a></p>
  <input type="submit" value="ログイン">
</form>

<script>
function validateForm() {
  var email = document.getElementsByName("adress")[0].value.trim();
  var password = document.getElementsByName("password")[0].value.trim();

  if (email === "" || password === "") {
    alert("入力されてありません。");
    return false; // フォームが送信されないようにします
  }
  return true; // フォームが送信される
}
</script>
</html>
