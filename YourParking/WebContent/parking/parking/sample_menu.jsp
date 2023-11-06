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
<!-- メニューコンテンツをここに配置 -->
<ul>
<li><a href="#">登録情報修正</a></li>
<li><a href="#">車情報修正</a></li>
<li><a href="#">ログアウト</a></li>
<!-- 他のメニュー項目を追加 -->
</ul>

<label for="menu-toggle" class="menu-button">
<span class="bar"></span>
<span class="bar"></span>
<span class="bar"></span>
</label>
</div>
<script src="../js/menu.js"></script>
</body>
</html>