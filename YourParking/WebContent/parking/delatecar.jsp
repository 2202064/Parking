<%@ page contentType="text/html; charset=UTF-8" %>
<h2>車削除</h2>
<div class ="carinfor">
	<form  action="サーブレットのファイル"method="post">
	<input type="checkbox"id ="check1" name ="check1"><br>
	${car.carname}<input type="checkbox"id ="check2" name ="check2"><br>
	${car.carname}<input type="checkbox" id="check3" name ="check3"><br>
	<p><input type="submit"value="削除する"></p>
	</form>
</div>
