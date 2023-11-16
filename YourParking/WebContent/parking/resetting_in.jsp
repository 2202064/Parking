<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="../tool/menu.jsp" %>
<!DOCTYPE html>

<meta charset="UTF-8">

<body>
<form action="resetting_out.jsp" method="post">
        新しいパスワード<input type="password" name="pass"  pattern=".{8,}" title="8文字以上のパスワードを入力してください" required id="pass" oninput="validatePasswords()"><br>
        確認用パスワード<input type="password" name="pass_confirmation" id="pass_confirmation" oninput="validatePasswords()"><br>
<input type="submit" value="送信" id="submitButton" disabled>
</form>
<p id="errorMessage" style="display: none; color: red;">パスワードが一致しません。</p>
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
