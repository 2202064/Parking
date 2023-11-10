<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/menu.jsp" %>

<link rel="stylesheet" href="../css/addcar.css">
<body>
<div class="style-1-1">
<h1 class= confirmation>登録されているメールアドレスを入力してください</h1>
<form action="confirmation_out.jsp" method="post">
<p>メールアドレス <input type="email" name="address" id="email"required></p>
<input type="submit" value="送信">
</form>

<form action="login.jsp" method="post">
<input type="submit" value="戻る">
</form>
</div>
</body>
</body>