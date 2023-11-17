<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../tool/menu.jsp" %>
<link rel="stylesheet" type="text/css" href="../css/top_user.css">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

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

<script src="../js/top_user.js"></script>

<%@include file="../footer.html" %>
