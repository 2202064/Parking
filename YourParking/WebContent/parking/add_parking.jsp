<%@page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>
<script src="../js/add_parking.js"></script>
<p>駐車場追加</p>
<form action="AddParking.action" method="POST" onsubmit="return validateForm()">
    駐車場種類<input type="text" name="park_genre"><br>
    駐車場名<input type="text" name="parking_name"><br>
    都道府県コード<input type="number" name="cd_id"><br>
    都道府県<input type="text" name="prefectures"><br>
    市区<input type="text" name="municipalities"><br>
    町村・番地<input type="text" name="street"><br>
    最大料金<textarea name="park_money" placeholder="概要を入力してください"></textarea><br>
    支払い方法<input type="text" name="park_payment"><br>
    台数<input type="number" name="park_space">台<br>
    営業時間<input type="text" name="park_time"><br>
    車長<input type="number" name="park_length" step="0.01">m<br>
    車高<input type="number" name="park_high" step="0.01">m<br>
    車幅<input type="number" name="park_width" step="0.01">m<br>
    地上高<input type="number" name="ground_height" step="0.01">m<br>
    重量<input type="number" name="park_weight" step="0.01">kg<br>
	X座標<input name ="xcoord"><br>
	Y座標<input name ="ycoord"><br>
    <input type="submit" value="追加">
</form>
<%@include file="../tool/footer.html" %>
