<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="../tool/header.jsp" %>
<%@include file="../tool/menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Result</title>
</head>
<body>

<h2>${parking.getPrefectures }</h2>

<c:forEach var="parking" items="${parking}">
    <p><a href="/parking/SearchCd?cd_id=${parking.parking_name}">${parking.parng_name}</a></p>
</c:forEach>

</body>
</html>
