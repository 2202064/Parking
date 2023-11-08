<%@page contentType = "text/html; charset=UTF-8" %>
<%@include file="./sample_menu.jsp" %>

<form action="#" method="post">
	<input type="text" name="search" placeholder="ここに入力">
	<input type="submit" value="検索"><br>

	<input type="checkbox" id="real" onchange="clickreal">実寸地検索
	<input type="checkbox" id="eriaselect" onchange="clickeria">エリア選択
	<!--
	<%
		//for(i=0; i > eria.size(); i+=4){
	%>
			<input type="checkbox" id="region" onchange="clickreg">${eria.name[i]}
			<input type="checkbox" id="region" onchange="clickreg">${eria.name[i+1]}
			<input type="checkbox" id="region" onchange="clickreg">${eria.name[i+2]}
			<input type="checkbox" id="region" onchange="clickreg">${eria.name[i+3]}

	<%
		//}
	%>
	 -->
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