<%@page contentType = "text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../tool/sample_menu.jsp" %>

<form action="Search" method="post">
	<input type="text" name="search" placeholder="ここに入力">
	<input type="submit" value="検索">
</form>

<%@include file="../footer.html" %>