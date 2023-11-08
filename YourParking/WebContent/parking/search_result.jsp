<%@page contentType = "text/html; charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@include file="../header.html" %>
<%@include file="../tool/sample_menu.jsp" %>

<h2>検索結果一覧</h2>
<c:forEach var="i" begin="0" end="${fn:length(list)}">
<form action="#" method="post">
<p>${list.name[i]}
<p>${list.mail[i]}
<input type="submit" value="GO!" name="${list.id[i]}">
<hr>
</form>
</c:forEach>
<%@include file="../footer.html" %>