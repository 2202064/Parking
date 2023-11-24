function validateForm() {
  var HIGH = document.getElementsByName("HIGH")[0].value.trim();
  var WIDTH = document.getElementsByName("WIDTH")[0].value.trim();
  var LENGTH = document.getElementsByName("LENGTH")[0].value.trim();
  var GROUND_HEIGHT = document.getElementsByName("GROUND_HEIGHT")[0].value.trim();
  var WEIGHT = document.getElementsByName("WEIGHT")[0].value.trim();


  if (HIGH=== "" || WIDTH === "" || LENGTH === "" || GROUND_HEIGHT === "" || WEIGHT === "" ) {
    alert("未入力のものがあります。");
    return false;
  }
  return true;
}
