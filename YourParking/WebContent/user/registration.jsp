<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<head>
<%@include file="../tool/menu.jsp" %>
<link href="../css/upd_user.css" rel="stylesheet">
<meta name="viewport" content="width=device-width,initial-scale=1">
</head>

<body>
	<div id="container">

		<form  action="UpdUser.action" method="post" onsubmit="return validateForm()">
		  <h3 id="info">登録情報修正</h3><hr>
		  <p id="success"><c:out value="${suc_message}"/></p>
		  <p id="failed"><c:out value="${fai_message}"/></p>
		  <p><label for="name">氏名 </label><br><input type="text" id="name" name="name" required value="${user.name}"></p>
		  <p><label for="phone">電話番号</label><br> <input type="text" id="phone" name="phone"pattern="[0-9]{11}" required value="${user.phone}"></p>
		  <p><label for="mail">メールアドレス</label> <br><input type="email" id="mail" name="mail" id="email" required value="${user.mail}"></p>
		  <p><label for="user_name">ユーザー</label><br> <input type="text" id="user_name" name="user_name" required value="${user.user_name}"></p>
		  <p><label for="credit">支払い情報</label><br> <input type="text" id="credit" name="credit" required value="${user.credit}"></p>
		  <p id="errorMessage" style="display: none; color: red;">パスワードが一致しません。</p>
		  <p><label for="pass">パスワード</label><br><input type="password" id="pass" name="pass" pattern=".{8,}" title="8文字以上のパスワードを入力してください" required id="pass" oninput="validatePasswords()"><br>
		  <p><label for="pass_confirmation">確認用パスワード</label><br><input type="password" id="pass_confirmation" name="pass_confirmation" pattern=".{8,50}"  oninput="validatePasswords()"><br>
		<input type="submit" value="確定" id="submitButton" disabled>
		</form>

		<a href="../user/del_user_in.jsp">退会</a>
	</div>
</body>
<script src="../js/upd_user.js"></script>
