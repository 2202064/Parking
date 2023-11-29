<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<p>レビュー投稿画面</p>

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <style>
    .star-container {
      display: flex;
    }

    .star {
      width: 150px;
      height: 150px;
      cursor: pointer;
    }
  </style>
  <title>佐野浩平</title>
</head>
<body>
  <div class="star-container">
    <img src="../img/star.png" alt="Star" class="star" id="star1" onclick="changeImage(1)">
    <img src="../img/star.png" alt="Star" class="star" id="star2" onclick="changeImage(2)">
    <img src="../img/star.png" alt="Star" class="star" id="star3" onclick="changeImage(3)">
    <img src="../img/star.png" alt="Star" class="star" id="star4" onclick="changeImage(4)">
    <img src="../img/star.png" alt="Star" class="star" id="star5" onclick="changeImage(5)">
  </div>

  <script>
    function changeImage(starNumber) {
      for (let i = 1; i <= 5; i++) {
        const starElement = document.getElementById(`star${i}`);
        if (i <= starNumber) {
          starElement.src = `<%= request.getContextPath() %>../img/sano${i}.png`; // Corrected path for JSP
        } else {
          starElement.src = `<%= request.getContextPath() %>../img/star.png`; // Corrected path for JSP
        }
      }
    }
  </script>
  <!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Checkbox Form Example</title>
</head>
<body>

<div>
  <label><input type="checkbox" id="saveCheckbox">駐車場に入れなかったか</label>
</div>

<p id="msg"></p>

<form action="../parking/parking.jsp" method="post" id="parkingForm" style="display:none;">

  <input type="checkbox">車高  <input type="checkbox">車幅  <input type="checkbox">車長  <input type="checkbox">地上高
</form>
<script>
  function valueChange(event) {
    if (saveCheckbox.checked) {
      msg.innerText = '入れなかった理由を教えてください';
      parkingForm.style.display = 'block';
    } else {
      msg.innerText = '';
      parkingForm.style.display = 'none';
    }
  }

  let saveCheckbox = document.getElementById('saveCheckbox');
  saveCheckbox.addEventListener('change', valueChange);
  let msg = document.getElementById('msg');
  let parkingForm = document.getElementById('parkingForm');
</script>
</body>
</html>
  <form action="../parking/parking.jsp" method="post">
<p>*任意</p>
<input type="text" name="message">
<p><input type="submit" value="投稿する"></p>
</body>
</html>
</form>