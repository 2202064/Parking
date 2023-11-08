<%@page contentType = "text/html; charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../tool/sample_menu.jsp" %>

<link rel="stylesheet" type="text/css" href="../css/top.css">

<label for="switch_info">駐車場情報</label>
<label for="switch_review">レビュー</label>
<input type="radio" name="switch" id="switch_info">
<input type="radio" name="switch" id="switch_review">
<hr>

<div id="info">
<h2>${park.name}</h2>
<p>${park.address}
<table>
<tr>
<td>料金</td><td>${park.price}</td>
</tr>
<tr>
<td>営業時間</td><td>${park.hours}</td>
</tr>
<tr>
<td>収容台数</td><td>${park.camp}</td>
</tr>
<tr>
<td>重量制限</td><td>${park.weight}</td>
</tr>
</table>

<table>
<tr>
<th></th><th>車高</th><th>車幅</th><th>車長</th>
</tr>
<tr>
<td>規定値</td><td>${park.parkHigh}</td><td>${park.parkWidth}</td><td>${park.parkLength}</td>
</tr>
<tr>
<td>実寸値</td><td>${park.realHigh}</td><td>${park.realWidth}</td><td>${park.realLength}</td>
</tr>
</table>

</div>


