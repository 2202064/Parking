<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/menu.jsp" %>

<p>退会の理由等ございましたらご入力ください</p>
<form action="DelUser.action" method="post">
<p>*任意</p>
<input type="text" name="message">
<p><input type="submit" value="退会"></p>
</form>
