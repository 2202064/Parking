<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Your Parking</title>
<link rel="stylesheet" type="text/css" href="../css/menu.css">
<link rel="stylesheet" type="text/css" href="../css/style.css" >
</head>
<h1 id="top_menu">Your Parking</h1>
<input type="checkbox" id="menu-toggle">
<input type="checkbox" id="correction">
<div id="menu">

<c:if test="${empty user.flag or user.flag == 2 or user.flag == 0}">
	<!-- ログアウト状態 -->
	<ul>
		<li><a class="menu_font" href="../parking/top_user.jsp">トップページ</a>
		<li><a class="menu_font" href="../user/login.jsp">ログイン</a></li>
		<li><a class="menu_font" href="../user/registration.jsp">新規会員登録</a></li>
	</ul>
</c:if>

<c:if test="${user.flag == 1}">
	<!-- 利用者ログイン状態 -->
	<ul>
		<li><a class="menu_font" href="../parking/top_user.jsp">トップページ</a>
		<li><a class="menu_font" href="../car/ChangeCar">使用する車の変更</a></li>
		<li><a class="menu_font" href="../user/upd_user.jsp">登録情報修正</a></li>
		<li><label for="correction" class="cor">車情報修正▽</label>
		<ul id="cor_url">
			<li><a class="menu_font" href="../car/add_car.jsp">車追加</a></li>
			<li><a class="menu_font" href="../car/SearchCar.action">車更新</a></li>
		</ul></li>
		<li><a href="../user/Logout.action">ログアウト</a>
	</ul>
</c:if>

<c:if test="${user.flag == 3}">
<!-- 管理者ログイン状態 -->
	<ul>
		<li><a class="menu_font" href="top_user.jsp">トップページ</a>
		<li><a class="menu_font" href="#">駐車場追加</a></li>
		<li><a class="menu_font" href="#">駐車場更新</a></li>
		<li><a class="menu_font" href="logout.action">ログアウト</a></li>
	</ul>
</c:if>

<label for="menu-toggle" class="menu-button">
<span class="bar"></span>
<span class="bar"></span>
<span class="bar"></span>
</label>
</div>
<script src="../js/menu.js"></script>
