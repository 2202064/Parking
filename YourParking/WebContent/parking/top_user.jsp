<%@page contentType = "text/html; charset=UTF-8" %>
<%@include file="../header.html" %>
<%@include file="../tool/menu.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<form action="Search" method="post">
	<input type="text" name="search" placeholder="ここに入力">
	<input type="submit" value="検索"><br>

	<input type="checkbox" id="real" onchange="clickreal">実寸地検索
	<input type="checkbox" id="eriaselect" onchange="clickeria">エリア選択
	<%int count = 0;%>
	<c:forEach var="i" begin="0" end="${fn:length( eria )}">
	<input type="checkbox" id="region" onchange="clickreg">${eria.name[i]}
	<%count++;%>
	<%if(count == 4) {%>
	<br>
	<%count = 0;%>
	<%}%>
	</c:forEach>
</form>

<script>
document.getElementById("region").style.display="none";
// 実寸地検索が押下された場合
function fanA() {

}

// エリア選択が押下された場合
function funB() {
	const eriaSelect = document.getElementById("eriaselect")
	if (eriaSelect.style.display = "none") {
		eriaSelect.style.display = "block"
	}else{
		eriaSelect.style.display = "none"
	}
}
</script>
<%@include file="../footer.html" %>