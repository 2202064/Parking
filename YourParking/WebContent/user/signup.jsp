<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>会員登録</title>
</head>
<body>
    <form action="ProvisionalSignup" method="post">
        <label for="username">ユーザー名:</label>
        <input type="text" id="name" name="name" required><br>

        <label for="email">メールアドレス:</label>
        <input type="email" id="mail" name="mail" required><br>

		<label for="email">パスワード:</label>
        <input type="password" id="password" name="password" required><br>

		<label for="tel">電話番号:</label>
        <input type="tel" id="tel" name="tel" required><br>

        <input type="submit" value="確定">
    </form>
</body>
</html>
