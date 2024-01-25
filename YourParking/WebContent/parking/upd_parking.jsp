<%@page contentType = "text/html; charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>
<script src="../js/add_parking.js"></script>

<p>駐車場更新
<form action="../user/login.jsp" method="POST" onsubmit="return validateForm()">
	駐車場種類<input type="text" name="park_genre"><br>
	駐車場名<input type="text" name="parking_name"><br>
	都道府県コード<input type="number" name="prefectures_id"><br>
	市区コード<input type="number" name="cd_id"><br>
	町村・番地<input type="text" name="street"><br>
	料金<textarea name="fee" placeholder="概要を入力してください"></textarea><br>
	最大料金<textarea name="park_money" placeholder="概要を入力してください"></textarea><br>
	支払い方法<input type="text" name="park_payment"><br>
	台数<input type="number" name="park_space">台<br>
	営業時間<input type="text" name="park_time"><br>
	車長<input type="number" name="park_length" step="0.01">m<br>
	車高<input type="number" name="park_high" step="0.01">m<br>
	車幅<input type="number" name="park_width" step="0.01">m<br>
	地上高<input type="number" name="ground_height" step="0.01">m<br>
	重量<input type="number" name="park_weight" step="0.01">kg<br>
	X座標<input type="number" name="xcoord" step="0.01"><br>
	Y座標<input type="number" name="ycoord" step="0.01"><br>
	<br><input type="submit" value="追加"><br>

</form>
<script src="../js/upd_parking.js"></script>


<div class="form-box">
<form action="delete_parking.jsp" method="POST" >
<div class="form-box__item">
<input type="checkbox" id="consent" name="consent" onclick="btnConsent();">
<label for="consent">削除</label>
</div>
<input type="submit" value="確定" class="btn"  id="btn-consent">
</form>
</div>
<%@include file="../tool/footer.html"%>
