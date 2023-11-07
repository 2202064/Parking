<%@page contentType="text/html; charset=UTF-8" %>


<p>こちらの内容でお間違いないでしょうか</p>
<%request.setCharacterEncoding("UTF-8");%>
<%=request.getParameter("message") %>
<form action="delete_out.jsp" method="post">
<input type="submit" value="確定">
</form>