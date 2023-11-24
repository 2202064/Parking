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
