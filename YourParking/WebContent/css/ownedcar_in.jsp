<%@page contentType="text/html; charset=UTF-8" %>
<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../tool/menu.jsp" %>

<link rel="stylesheet" href="../css/addcar.css">
<body>
<div class="style-1-1">
<p>所有車設定</p>
<h1 class="owned_car">指定している車情報 車載物</h1>
<form action="ownedcar_out.jsp" method="post" onsubmit="return validateForm()">
  <p>車高: <input type="text" name="VehicleHeight">m <input type="text" name="VehicleHeight1">m</p>
  <p>車幅: <input type="text" name="VehicleWidth">m <input type="text" name="VehicleWidth1">m</p>
  <p>車長: <input type="text" name="Commander">m <input type="text" name="Commander1">m</p>
  <p>地上高: <input type="text" name="GroundHeight">cm <input type="text" name="GroundHeight1">cm</p>
  <input type="submit" value="確定">
</form>
</div>
</body>
<script>
function validateForm() {
  var inputs = document.getElementsByTagName("input");
  for (var i = 0; i < inputs.length; i++) {
    if (inputs[i].type === "text") {
      var value = inputs[i].value.trim();
      if (value === "") {
        alert("すべての項目を入力してください。");
        return false;
      }
      if (!isNumeric(value)) {
        alert("数字での入力をお願いします");
        return false;
      }
    }
  }
  return true;
}

function isNumeric(value) {
  return !isNaN(parseFloat(value)) && isFinite(value);
}
</script>
</html>