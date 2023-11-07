<%@page contentType = "text/html; charset=UTF-8" %>
<%@page import="java.util.List" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../header.html" %>
<%@include file="../tool/sample_menu.jsp" %>

<c:forEach var="i" begin="0" end="${list.size}">
<form action="#" method="post">
<p>${list.name[i]}
<p>${list.address[i]}
<input type="submit" value="GO!" name="${list.id[i]}">
<hr>
</form>
</c:forEach>
<%@include file="../footer.html" %>