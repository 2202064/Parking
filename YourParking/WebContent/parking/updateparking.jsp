<%@ page contentType="text/html; charset=UTF-8" %>
<meta name="viewport" content="width=device-width,user-scalable=no,maximum-scale=1" />

<h2>駐車場更新</h2>

<div class="addparking">
	<form action="サーブレットのURL" method="post">

	<table>

		<tr>
			<td>駐車場名</td>
			<td><input type="text" id="cost" name="parking_name"required="required"></td>
		</tr>

		<tr>
			<td>都道府県</td>
			<td><input type="text" id="cost" name="prefectures"required="required"></td>
		</tr>

		<tr>
			<td>市区町村</td>
			<td><input type="text" id="cost" name="municiplities"required="required"></td>
		</tr>

		<tr>
			<td>番地</td>
			<td><input type="text" id="cost" name="street"required="required"></td>
		</tr>

		<tr>
			<td>車高制限</td>
			<td><input type="text" id="cost" name="parking_haight"required="required"></td>
		</tr>

		<tr>
			<td>車幅制限</td>
			<td><input type="text" id="cost" name="park_width"required="required"></td>
		</tr>

		<tr>
			<td>車長制限</td>
			<td><input type="text" id="cost" name="park_length"required="required"></td>
		</tr>

		<tr>
			<td>重量制限</td>
			<td><input type="text" id="cost" name="park_weight"required="required"></td>
		</tr>

		<tr>
			<td>駐車スペース数</td>
			<td><input type="text" id="cost" name="park_space"required="required"></td>
		</tr>

		<tr>
			<td>営業時間</td>
			<td><input type="text" id="cost" name="park_time"required="required"></td>
		</tr>

		<tr>
			<td>料金</td>
			<td><input type="text" id="cost" name="park_money"required="required"></td>
		</tr>

		<tr>
			<td>支払い情報</td>
			<td><input type="text" id="cost" name="park_payment"required="required"></td>
		</tr>

		<tr>
			<td>ジャンル</td>
			<td><input type="text" id="cost" name="park_genre"required="required"></td>
		</tr>

		<tr>
			<td>実寸地＿高さ</td>
			<td><input type="text" id="cost" name="actual_height"required="required"></td>
		</tr>

		<tr>
			<td>実寸地＿幅</td>
			<td><input type="text" id="cost" name="actual_width"required="required"></td>
		</tr>

		<tr>
			<td>実寸地＿長さ</td>
			<td><input type="text" id="cost" name="actual_length"required="required"></td>
		</tr>

		<tr>
			<td>実寸地＿重量</td>
			<td><input type="text" id="cost" name="actual_weight"required="required"></td>
		</tr>

		<tr>
			<td>Ｘ座標</td>
			<td><input type="text" id="cost" name="Xcoord"required="required"></td>
		</tr>

		<tr>
			<td>Ｙ座標</td>
			<td><input type="text" id="cost" name="Ycoord"required="required"></td>
		</tr>
	</table>
		<input type="checkbox" id="delate" name="delate">
		<label for="delate">削除</label>
		<input type="submit" value="更新">
	</form>
</div>

