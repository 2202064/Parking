<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Your Parking</title>
<link rel="stylesheet" type="text/css" href="../css/menu.css">
</head>
<h1>Your Parking</h1>
<input type="checkbox" id="menu-toggle">
<input type="checkbox" id="correction">
<div id="menu">

<c:if test="${empty user.flag or user.flag == 2 or user.flag == 0}">
	<!-- ログアウト状態 -->
	<ul>
		<li><a href="../parking/top_user.jsp">トップページ</a>
		<li><a href="../user/login.jsp">ログイン</a></li>
		<li><a href="../user/registration.jsp">新規会員登録</a></li>
	</ul>
</c:if>

<c:if test="${user.flag == 1}">
	<!-- 利用者ログイン状態 -->
	<ul>
		<li><a href="../parking/top_user.jsp">トップページ</a>
		<li><a href="../user/upd_user.jsp">登録情報修正</a></li>
		<li><label for="correction" class="cor">車情報修正▽</label>
		<ul id="cor_url">
			<li><a href="../car/ChangeCar" id="change">使用車変更</a>
			<li><a href="../car/add_car.jsp">車追加</a></li>
			<li><a href="../car/ChangeCar" id="update">車更新</a></li>
		</ul></li>
		<li><a href="../user/Logout.action">ログアウト</a>
	</ul>
</c:if>

<c:if test="${user.flag == 3}">
<!-- 管理者ログイン状態 -->
	<ul>
		<li><a href="top_user.jsp">トップページ</a>
		<li><a href="../parking/add_parking.jsp">駐車場追加</a></li>
		<li><a href="../parking/add_parking.jsp">駐車場更新</a></li>
		<li><a href="../user/logout.action">ログアウト</a></li>
	</ul>
</c:if>

<label for="menu-toggle" class="menu-button">
<span class="bar"></span>
<span class="bar"></span>
<span class="bar"></span>
</label>
</div>
<script src="../js/menu.js"></script>
