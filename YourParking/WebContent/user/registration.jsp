<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../tool/menu.jsp" %>
<link rel="stylesheet" type="text/css" href="../css/registration.css">
<meta name="viewport" content="width=device-width,initial-scale=1">
<script src="../js/registration.js"></script>

<c:out value="${ message}"/>
<!-- onsubmitで送信を押された時に未入力があるか判断-->
<form action="Registration.action" method="POST" onsubmit="return validateForm()">
	<p>名前：<input name="name" required></p>
	<p>電話番号：<input type="tel" name="phone"pattern="[0-9]{11}" title="ハイフンなし、数字11桁"required></p>
	<p>メール：<input type="email" name="mail" required></p>
	<p>ユーザー名：<input name="user_id" required></p>
	<p>クレカ：<input type="text"name="credit"pattern="[0-9]{16}" title="数字16桁"required></p>
	<p>パス：<input type="password" name="pass"  pattern=".{8,50}" title="8文字以上50文字以下のパスワードを入力してください" required id="pass" oninput="validatePasswords()"><br>
	<p>パス２：<input type="password" name="kakunin"  pattern=".{8,50}" title="8文字以上のパスワードを入力してください" required id="pass" oninput="validatePasswords()"><br>
	<input type="submit" value="送信">
</form>


