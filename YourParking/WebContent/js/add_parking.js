function validateForm() {
  var park_genre = document.getElementsByName("park_genre")[0].value.trim();
  var parking_name = document.getElementsByName("parking_name")[0].value.trim();
  var prefectures_id = document.getElementsByName("prefectures_id")[0].value.trim();
  var cd_id = document.getElementsByName("cd_id")[0].value.trim();
  var street = document.getElementsByName("street")[0].value.trim();
  var fee = document.getElementsByName("fee")[0].value.trim();
  var park_money = document.getElementsByName("park_money")[0].value.trim();
  var park_payment = document.getElementsByName("park_payment")[0].value.trim();
  var park_space = document.getElementsByName("park_space")[0].value.trim();
  var park_time = document.getElementsByName("park_time")[0].value.trim();
  var park_length = document.getElementsByName("park_length")[0].value.trim();
  var park_high = document.getElementsByName("park_high")[0].value.trim();
  var park_width = document.getElementsByName("park_width")[0].value.trim();
  var ground_height = document.getElementsByName("ground_height")[0].value.trim();
  var park_weight = document.getElementsByName("park_weight")[0].value.trim();

  if ( park_genre=== "" ||  parking_name=== "" || prefectures_id === "" || cd_id === "" || street === "" || fee === ""|| park_money === "" || park_payment === "" || park_space === "" || park_time === "" ||park_length === "" || park_high === ""  || park_width === "" || ground_height === ""|| park_weight === "") {
    alert("未入力のものがあります。");
    return false;
  }
  return true;
}
