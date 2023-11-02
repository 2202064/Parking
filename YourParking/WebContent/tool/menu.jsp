<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Your Parking</title>
<link rel="stylesheet" type="text/css" href="../css/menu.css">
</head>
<body>
<h1>Your Parking</h1>
<input type="checkbox" id="menu-toggle">
<div id="menu">
<%
User user = (User)session.getAttribute("user");
if (user != null){
%>
	<%if (user = "###") { %>
		<!-- 管理者ログイン状態 -->
		<ul>
		<li><a href="#">駐車場追加</a></li>
		<li><a href="#">駐車場更新</a></li>
		<li><a href="#">ログアウト</a></li>
		</ul>
	<%}else{ %>
		<!-- 利用者ログイン状態 -->
		<ul>
		<li><a href="#">登録情報修正</a></li>
		<li><div class="cor-container">
			<input type="checkbox" id="correction"><a href="#">車情報修正</a>
  			<!-- 車情報修正が押下された場合 -->
  			<ul>
  			<li><a href="#" id="cor-link" class="hidden">車追加</a></li>
  			<li><a href="#" id="cor-link" class="hidden">車変更</a></li>
  			<li><a href="#" id="cor-link" class="hidden">車削除</a></li>
  			</ul>
		</div></li>
		<li><a href="#">ログアウト</a></li>
		</ul>
	<%} %>
<%}else{ %>
<!-- ログアウト状態 -->
	<ul>
	<li><a href="#">ログイン</a></li>
	<li><a href="#">新規会員登録</a></li>
	</ul>
<%} %>
<label for="menu-toggle" class="menu-button">
<span class="bar"></span>
<span class="bar"></span>
<span class="bar"></span>
</label>
</div>
<script src="../js/menu.js"></script>
</body>
</html>