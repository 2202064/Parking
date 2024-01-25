
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
