<%@page contentType="text/html; charset=UTF-8" %>

<p>車追加</p>
<form action="ownedcar_out" method="post" onsubmit="return validateForm()">
  <p>車高: <input type="text" name="HIGH">m</p>
  <p>車幅: <input type="text" name="WIDTH">m </p>
  <p>車長: <input type="text" name="LENGTH">m </p>
  <p>地上高: <input type="text" name="GROUND_HEIGHT">m</p>
  <p>重量:  <input type="text" name="WEIGHT">kg </p>
  <input type="submit" value="確定">
</form>



<script>
function validateForm() {
  var VehicleHeight = document.getElementsByName("HIGHt")[0].value.trim();
  var VehicleWidth = document.getElementsByName("WIDTH")[0].value.trim();
  var Commander = document.getElementsByName("LENGTH")[0].value.trim();
  var GroundHeight = document.getElementsByName("GROUND_HEIGHT")[0].value.trim();
  var weight = document.getElementsByName("WEIGHT")[0].value.trim();


  if (VehicleHeight=== "" || VehicleWidth === "" || Commander === "" || GroundHeight === "" || weight === "" ) {
    alert("未入力のものがあります。");
    return false;
  }
  return true;
}
</script>
</html>>