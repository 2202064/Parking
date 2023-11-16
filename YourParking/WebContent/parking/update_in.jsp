<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<meta charset="UTF-8">

<p>登録情報修正</p>
<body>
<form action="Update.action" method="post" onsubmit="return validateForm()">
  <p>氏名 <input type="text" name="name" required placeholder="${user.name}"></p>
  <p>電話番号 <input type="text" name="phone" required placeholder="${user.phone}"></p>
  <p>メールアドレス <input type="email" name="mail" id="email" required placeholder="${user.mail}"></p>
  <p>ユーザー <input type="text" name="user_name" required placeholder="${user.user_name}"></p>
  <p>支払い情報 <input type="text" name="credit" required placeholder="${user.credit}"></p>
  <p id="errorMessage" style="display: none; color: red;">パスワードが一致しません。</p>
  <p>パスワード<input type="password" name="pass" pattern=".{8,}" title="8文字以上のパスワードを入力してください" required id="pass" oninput="validatePasswords()"><br>
  <p>確認用パスワード<input type="password" name="pass_confirmation" id="pass_confirmation" oninput="validatePasswords()"><br>
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
