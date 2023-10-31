<%@page contentType="text/html; charset=UTF-8" %>

<p>ログイン情報をご入力ください</p>
<form action="welcome.jsp" method="post" onsubmit="return validateForm()">
  <p>メールアドレス:<input type="email" name="adress" id="email"></p>
  <p id="email-error"></p>
  <p>パスワード:<input type="password" name="password" id="password"></p>
  <p id="password-error"></p>
  <p><a href="kakunin.jsp">メールアドレスまたまたはパスワードを忘れた場合はこちら</a></p>
  <input type="submit" value="ログイン" style="background-color: #4caf50; color: #fff; border: none; padding: 5px 10px; cursor: pointer;">

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