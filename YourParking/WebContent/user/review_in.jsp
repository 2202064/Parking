<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link rel="stylesheet" type="text/css" href="../css/review.css">

<!DOCTYPE html>
<html lang="ja">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<h1>レビュー投稿画面</h1>
</head>

<body>

  <div class="star-container">
<c:forEach var="i" begin="1" end="5">
<img src="../img/star.png" alt="Star" class="star" id="star${i}" onclick="changeImage(${i})">
</c:forEach>
</div>

  <script>
    function changeImage(starNumber) {
<c:forEach var="i" begin="1" end="5">
        var starElement = document.getElementById("star${i}");
        if (${i} <= starNumber) {
          starElement.src = `../img/sano${i}.png`;
        } else {
          starElement.src = '../img/star.png';
        }
</c:forEach>
    }
</script>
  <div>
    <label><input type="checkbox" id="saveCheckbox">駐車場に入れなかったか</label>
  </div>

  <p id="msg"></p>

  <form action="../parking/parking.jsp" method="post" id="parkingForm" style="display:none;">
    <input type="checkbox">車高 <input type="checkbox">車幅 <input type="checkbox">車長 <input type="checkbox">地上高
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

  <form action="/parking/Review.Action" method="post">
    <p>*任意</p>
    <textarea id="comment"></textarea>
    <input type="hidden" id="good">
    <p><input type="submit" value="投稿する"></p>
  </form>

</body>

</html>
