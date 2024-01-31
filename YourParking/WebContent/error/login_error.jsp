<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<style>
.gaming{
    font-size: 36px;
    background-clip: text;
    font-weight: bold;
    -webkit-background-clip: text;
    color: transparent;
    background-image: linear-gradient(45deg,
        red,
        orange,
        yellow,
        green,
        aqua,
        blue,
        purple);
    background-size: 1200%;
    animation: 4s linear 0s infinite alternate slide;
}

@keyframes slide {
    from { background-position: 0% 0%; }
    to { background-position: 100% 0%; }
}
</style>

<p class="gaming">ログイン名またはパスワードが違います。</p>
<a href="./login.jsp">ログイン画面</a>

<%@include file="../tool/footer.html" %>
