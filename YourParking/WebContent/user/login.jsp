<%@page contentType="text/html; charset=UTF-8" %>

<style>
    body {
        background-color: #f3f3f3;
        margin: 0;
        font-family: 'Arial', sans-serif;
    }

    form {
        width: 400px;
        padding: 40px;
        margin: auto;
        background-color: #fff;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }

    form h1,
    form p {
        color: #333;
        font-weight: 500;
    }

    form p {
        font-size: 14px;
    }

    form input[type="email"],
    form input[type="password"] {
        border: 1px solid #a9a9a9;
        padding: 15px 10px;
        width: 100%;
        margin: 10px 0;
        box-sizing: border-box;
        border-radius: 5px;
        outline: none;
    }

    form input[type="email"]:focus,
    form input[type="password"]:focus {
        border-color: #ff9900;
    }

    form input[type="submit"] {
        border: 0;
        background: #ff9900;
        display: block;
        margin: 20px auto;
        padding: 15px 10px;
        width: 100%;
        outline: none;
        color: #fff;
        border-radius: 25px;
        cursor: pointer;
        font-size: 16px;
        font-weight: bold;
    }

    form input[type="submit"]:hover {
        background-color: #e68a00;
    }

    form a {
        color: #333;
        font-size: 12px;
        text-decoration: none;
        display: block;
        margin-top: 15px;
    }
</style>

<script src="../js/login.js"></script>
<form action="Login.action" method="post">
<h3>ログイン情報をご入力ください</h3>
  <p>メールアドレス:<input type="email" name="address" id="email"></p>
  <p id="email-error"></p>
  <p>パスワード <input type="password" name="pass" pattern=".{8,}" title="8文字以上のパスワードを入力してください" required></p>
  <p id="password-error"></p>
  <p><a href="confirmation_in.jsp">メールアドレスまたはパスワードを忘れた場合はこちら</a></p>
  <input type="submit" value="ログイン" class="example4">
</form>
