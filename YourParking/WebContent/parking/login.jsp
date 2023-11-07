<%@page contentType="text/html; charset=UTF-8" %>

<style>
.example4 {
    background: linear-gradient(to right, #e60000, #f39800, #fff100, #009944, #0068b7, #1d2088, #920783, #e60000) 0 / 200%;
    height: 30px;
    animation: 5s example4 linear infinite;
}

@keyframes example4 {
    100% {
        background-position: 200%;
    }
}
</style>

<p>ログイン情報をご入力ください</p>
<form action="Login.action" method="post">
  <p>メールアドレス:<input type="email" name="address" id="email"></p>
  <p id="email-error"></p>
  <p>パスワード <input type="password" name="pass" pattern=".{8,}" title="8文字以上のパスワードを入力してください" required></p>
  <p id="password-error"></p>
  <p><a href="confirmation_in.jsp">メールアドレスまたはパスワードを忘れた場合はこちら</a></p>
  <input type="submit" value="ログイン" class="example4">
</form>


<script>
function validateForm() {
  var email = document.getElementById("email").value.trim();
  var password = document.getElementById("password").value.trim();
  var emailErrorMessage = document.getElementById("email-error");
  var passwordErrorMessage = document.getElementById("password-error");
  var formIsValid = true;

  if (email === "") {
    emailErrorMessage.style.color = "red";
    emailErrorMessage.textContent = "メールアドレスを入力してください";
    formIsValid = false;
  } else {
    emailErrorMessage.textContent = "";
  }

  if (password === "") {
    passwordErrorMessage.style.color = "red";
    passwordErrorMessage.textContent = "パスワードを入力してください";
    formIsValid = false;
  } else {
    passwordErrorMessage.textContent = "";
  }

  return formIsValid;
}
</script>