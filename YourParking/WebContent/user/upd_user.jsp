<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<meta charset="UTF-8">
<%@include file="../tool/menu.jsp" %>

<body>

<p>登録情報修正</p>
<c:out value="${suc_message}"/>
<c:out value="${fai_message}"/>
<form action="UpdUser.action" method="post" onsubmit="return validateForm()">
  <p>氏名 <input type="text" name="name" required placeholder="${user.name}"></p>
  <p>電話番号 <input type="text" name="phone" pattern="[0-9]{11}" title="数字11桁を入力してください" required placeholder="${user.phone}"></p>
  <p>メールアドレス <input type="email" name="mail" id="email" required placeholder="${user.mail}"></p>
  <p>ユーザー <input type="text" name="user_name" required placeholder="${user.user_name}"></p>
  <p>支払い情報 <input type="text" name="credit" pattern="[0-9]{16}" title="数字16桁を入力してください"required placeholder="${user.credit}"></p>
  <p id="errorMessage" style="display: none; color: red;">パスワードが一致しません。</p>
  <p>パスワード<input type="password" name="pass" pattern=".{8,50}" title="8文字以上50文字以下のパスワードを入力してください" required id="pass" oninput="validatePasswords()"><br>
  <p>確認用パスワード<input type="password" name="pass_confirmation" pattern=".{8,50}" title="8文字以上50文字以下のパスワードを入力してください" required id="pass_confirmation" oninput="validatePasswords()"><br>
<input type="submit" value="確定" id="submitButton" disabled>
</form>
<form action="del_user_in.jsp" method="post" onsubmit="return validateForm()">
<input type="submit" value="退会">
</form>
<script src="../js/registration.js">

</script>
