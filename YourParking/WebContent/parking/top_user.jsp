<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>

<!-- CSS -->
<link href="../css/top_user.css" rel="stylesheet">
<link href="../css/logo2.css" rel="stylesheet">

<!-- tag -->
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!-- logo -->
<div id="splash">
  <div id="splash_logo">
    <img src="../img/icon.png" alt="" class="fadeUp">
  </div>
</div>

<main>
	<div id="container">
		<form action="Search" method="post">

    		<div class="kouhei">
        		<input type="text" name="search" placeholder="ここに入力">
        		<input type="submit" value="検索"><br>

		        <a href="#" id="realLink" onclick="clickreal()">実寸地検索</a>
		        <a href="#" id="eriaLink" onclick="clickeria()">エリア選択</a>

		        <div class="kouhei message" id="regionList" style="display:none;">
		        </div>
		    </div>

		    <div id="prefectureListKanto" class="prefectureList kouhei" style="display:none;">
		    </div>
		</form>
	</div>
</main>

<!-- JS -->
<script src="../js/top_user.js"></script>

<!-- JQuery -->
  <script src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=" crossorigin="anonymous"></script>
  <script src="https://coco-factory.jp/ugokuweb/wp-content/themes/ugokuweb/data/4-1-4/js/4-1-4.js"></script>

<%@include file="../tool/footer.html" %>
