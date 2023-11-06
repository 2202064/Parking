<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>メール認証</title>
</head>
<body>
    <form action="SendVerificationEmail" method="post">
        <label for="email">メールアドレス:</label>
        <input type="text" id="email" name="email" required>
        <input type="submit" value="送信">
    </form>
</body>
</html>
