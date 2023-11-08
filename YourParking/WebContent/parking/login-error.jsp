<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@include file="../header.html" %>

<style>
.rainbow-text {
    background: linear-gradient(to right, #e60000, #f39800, #fff100, #009944, #0068b7, #1d2088, #920783, #e60000);
    -webkit-background-clip: text;
    color: transparent;
    display: inline;
}
</style>

<p class="rainbow-text">ログイン名またはパスワードが違います。</p>
<p class="rainbow-text"><a href="./login.jsp">ログイン画面</a></p>

<%@include file="../footer.html" %>
