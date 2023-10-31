<%@page contentType="text/html; charset=UTF-8" %>

<p>新規会員登録</p>
<form action="addcar.jsp" method="post" onsubmit="return validateForm()">
  <p>氏名 <input type="text" name="name"></p>
  <p>電話番号 <input type="text" name="phone"></p>
  <p>メールアドレス <input type="text" name="mail"></p>
  <p>ユーザー <input type="text" name="user_id"></p>
  <p>支払い情報 <input type="text" name="credit"></p>
  <p>パスワード <input type="password" name="pass"></p>
  <p>パスワード確認 <input type="password" name="kakunin"></p>
  <input type="submit" value="車情報入力">
</form>

<script>
function validateForm() {
  var name = document.getElementsByName("name")[0].value.trim();
  var phone = document.getElementsByName("phone")[0].value.trim();
  var mail = document.getElementsByName("mail")[0].value.trim();
  var user_id = document.getElementsByName("user_id")[0].value.trim();
  var credit = document.getElementsByName("credit")[0].value.trim();
  var pass = document.getElementsByName("pass")[0].value.trim();
  var kakunin = document.getElementsByName("kakunin")[0].value.trim();

  if (pass !== kakunin) {
	    alert("パスワードと確認用パスワードが一致しません。");
	    return false;
	  }

  if (email === "" || password === "") {
    alert("入力されてありません。");
    return false;
  }
  return true;
}
</script>