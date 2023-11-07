<%@ page contentType="text/html; charset=UTF-8" %>

<h2>車変更</h2>

<div style="text-align:center;display:inline-block; background:#fcfcff; padding:15px; border:1px solid #333333; border-radius:10px; word-break:break-all">
今選んでいる車
</div>
<div class="change">
	<form action="サーブレットのURL" method="post">
	<table border="1" style="border-collapse: collapse">
		<tr>
		<th>request.getAttribute("carinfor")</th>
		<td><input type="checkbox" id="check1"name="check1"></td>
		</tr>

		<tr>
		<th>request.getAttribute("carinfor")</th>
		<td><input type="checkbox" id="check1"name="check1"></td>
		</tr>
	</table>
			<input type="submit" value="変更する">
	</form>

</div>

