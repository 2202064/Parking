<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>

<!-- CSS -->
<!--文字制御 -->
<link href="../css/top_user.css" rel="stylesheet">

<!-- ロゴアニメーション -->
<link href="../css/logo2.css" rel="stylesheet">

<!-- 全体用 -->
<link href="../css/style.css" rel="stylesheet">

<!-- tag -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- logo -->
<div id="splash">
<div id="splash_logo">
<img src="../img/icon.png" alt="" class="fadeUp">
</div>
</div>

<body>
<div id="container">
<form action="../parking/Search" method="post">

    		<div class="kouhei">
<input type="text" id="input" name="search" placeholder="ここに入力">
<input type="submit" value="検索"><br>
<p class="info">※新宿区、板橋区、の形式で入力してください</p>ss


				<input type="checkbox" id="consent" name="consent" value="notnull" onclick="btnConsent();">
<label for="consent">実寸地検索</label>

				<!-- 地方選択-->
<label for="firstSelect"></label>
<select id="firstSelect">
<option value="">地方を選択</option>
<option value="北海道">北海道</option>
<option value="関東">関東</option>
<option value="東北">東北</option>
<option value="中部">中部</option>
<option value="近畿">近畿</option>
<option value="中国">中国</option>
<option value="四国">四国</option>
<option value="九州">九州</option>
</select>
</div>
				  <!-- 都道府県 -->
<label for="secondSelect"></label><br>
<span style="display: block; text-align: center;">
  <select id="secondSelect" style="margin: auto;">
  <option value="">都道府県を選択</option>
  </select>
</span>

				  <!-- 市区町村 -->
<label for="thirdSelect"></label><br>
<span style="display: block; text-align: center;">
  <select id="thirdSelect" style="margin: auto;">
  <option value="">市区町村を選択</option>
  </select>
</span>



		    <div id="prefectureListKanto" class="prefectureList kouhei" style="display:none;">
</div>

</form>
</div>
</body>

<!-- JS -->
<script src="../js/top_user.js"></script>

<!-- JQuery -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/4-1-4/js/4-1-4.js"></script>

<%@include file="../tool/footer.html" %>
