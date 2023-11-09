<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>

<meta charset="UTF-8">

<p>新規会員登録</p>
<body>
<form action="addcar.jsp" method="post">
  <p>氏名 <input type="text" name="name"required></p>
  <p>電話番号 <input type="text" name="phone"required></p>
  <p>メールアドレス <input type="email" name="address" id="email"required></p>
  <p>ユーザー <input type="text" name="user_id"required></p>
  <p>支払い情報 <input type="text" name="credit"required></p>
  <p>パスワード<input type="password" name="pass"  pattern=".{8,}" title="8文字以上のパスワードを入力してください" required id="pass" oninput="validatePasswords()"><br>
  <p>確認用パスワード<input type="password" name="pass_confirmation" id="pass_confirmation" oninput="validatePasswords()"><br>
<input type="submit" value="車情報入力" id="submitButton" disabled>
<p id="errorMessage" style="display: none; color: red;">パスワードが一致しません。</p>
</form>
</body>

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
