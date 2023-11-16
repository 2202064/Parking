<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../tool/menu.jsp" %>
<!DOCTYPE html>

<meta charset="UTF-8">


<p>登録情報修正</p>
<body>
<form action="Fix.action" method="post" onsubmit="return validateForm()">
  <p>氏名 <input type="text" name="name"required></p>
  <p>電話番号 <input type="text" name="phone"required></p>
  <p>メールアドレス <input type="email" name="address" id="email"required></p>
  <p>ユーザー <input type="text" name="user_id"required></p>
  <p>支払い情報 <input type="text" name="credit"required></p>
  <p id="errorMessage" style="display: none; color: red;">パスワードが一致しません。</p>
  <p>パスワード<input type="password" name="pass"  pattern=".{8,}" title="8文字以上のパスワードを入力してください" required id="pass" oninput="validatePasswords()"><br>
  <p>確認用パスワード<input type="password" name="pass_confirmation" id="pass_confirmation" oninput="validatePasswords()"><br>
  <p>車高 <input type="text" name="HIGH"required>m</p>
  <p>車幅 <input type="text" name="WIDTH"required>m </p>
  <p>車長 <input type="text" name="LENGTH"required>m </p>
  <p>地上高 <input type="text" name="GROUND_HEIGHT"required>m</p>
  <p>重量  <input type="text" name="WEIGHT"required>kg </p>
<input type="submit" value="確定" id="submitButton" disabled>
</form>
<form action="delete.jsp" method="post" onsubmit="return validateForm()">
<input type="submit" value="退会">
</form>
<script>
function validatePasswords() {
    var pass = document.getElementById("pass").value;
    var pass_confirmation = document.getElementById("pass_confirmation").value;
    var errorMessage = document.getElementById("errorMessage");
    var submitButton = document.getElementById("submitButton");

    if (pass === pass_confirmation) {
        errorMessage.style.display = "none"; // エラーメッセージを非表示
        submitButton.disabled = false; // 送信ボタンを有効化
    } else {
        errorMessage.style.display = "block"; // エラーメッセージを表示
        errorMessage.style.color = "red";
        submitButton.disabled = true; // 送信ボタンを非活性化
    }
}
</script>
