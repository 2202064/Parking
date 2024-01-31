<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>


<head>
<link href="../css/top_user.css" rel="stylesheet">

<!-- 全体用 -->
<link href="../css/style.css" rel="stylesheet">

<!-- tag -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<meta name="viewport" content="width=device-width,initial-scale=1">
</head>
 <div id="splash">
    <div id="splash_text"></div>
  </div>
<%@include file="../tool/menu.jsp" %>

<body class="appear">



<div id="container">
	<div class="kouhei">
		<form action="../parking/Search" method="post">
			<input type="text" id="input" name="search" placeholder="ここに入力" required>
			<input type="submit" value="検索"><br>
			<p class="info">※新宿区、板橋区、の形式で入力してください</p>
		</form>
		<input type="checkbox" id="consent" name="consent" value="notnull" onclick="btnConsent();">
		<label for="consent">実寸地検索</label>

		<!-- 地方選択-->
		<form action="../parking/Search" method="post">
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
			 	<select id="thirdSelect" name="search" style="margin: auto;">
					<option value="" >市区町村を選択</option>
				</select>
			</span>

			<input type="submit" id="area_button" value="検索"  >
		</form>
	</div>
</div>
<div id="map"></div>

 <script>
    // sessionのuserがnullでない場合にロード画面を非表示にする
    //ちょっと突貫なのでここに書いてます
    //てか、これjsふぁいるでい
    <% if (session.getAttribute("user") != null) { %>
      document.addEventListener("DOMContentLoaded", function() {
        document.getElementById("splash").style.display = "none";
      });
    <% } %>
  </script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA1uZORqEffnBYn9GV7e9WiOZiYAeEfObw&callback=initMap" async defer></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js" integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
<script src="https://rawgit.com/kimmobrunfeldt/progressbar.js/master/dist/progressbar.min.js"></script>
<!--IE11用※対応しなければ削除してください-->
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/6.26.0/babel.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/babel-polyfill/6.26.0/polyfill.min.js"></script>
<!--自作のJS-->
<script src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/4-1-2/js/4-1-2.js"></script>

</body>

<!-- JS -->
<script src="../js/top_user.js"></script>

<%@include file="../tool/footer.html" %>
