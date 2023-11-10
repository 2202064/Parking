<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/menu.jsp" %>

<link rel="stylesheet" href="../css/addcar.css">
<body>
<div class="style-1-1">
<h1 class="delete">退会の理由等ございましたらご入力ください</h1>
<form action="delete_user_out.jsp" method="post">
<p>*任意</p>
<input type="text" name="message">
<p><input type="submit" value="退会"></p>
</form>
</div>
</body>