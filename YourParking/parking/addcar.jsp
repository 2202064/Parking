<%@page contentType="text/html; charset=UTF-8" %>

<p>車追加</p>
<form action="syoyusya-kakunin.jsp" method="post" onsubmit="return validateForm()">
  <p>車高: <input type="text" name="VehicleHeight">m</p>
  <p>車幅: <input type="text" name="VehicleWidth">m </p>
  <p>車長: <input type="text" name="Commander">m </p>
  <p>地上高: <input type="text" name="GroundHeight">m</p>
  <p>重量:  <input type="text" name="weight">kg </p>
  <input type="submit" value="確定">
</form>

<script>
function validateForm() {
  var VehicleHeight = document.getElementsByName("VehicleHeight")[0].value.trim();
  var VehicleWidth = document.getElementsByName("VehicleWidth")[0].value.trim();
  var Commander = document.getElementsByName("Commander")[0].value.trim();
  var GroundHeight = document.getElementsByName("GroundHeight")[0].value.trim();
  var weight = document.getElementsByName("weight")[0].value.trim();


  if (VehicleHeight=== "" || VehicleWidth === "" || Commander === "" || GroundHeight === "" || weight === "" ) {
    alert("未入力のものがあります。");
    return false;
  }
  return true;
}
</script>
</html>>