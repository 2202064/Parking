<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ja">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" type="text/css" href="../css/review.css">
  <script type="text/javascript" src="../js/review.js" defer></script>
  <h1>レビュー投稿画面</h1>
</head>

<body>

  <div class="star-container">
    <c:forEach var="i" begin="1" end="5">
      <img src="../img/star.png" alt="Star" class="star" id="star${i}" onclick="changeImage(${i})">
    </c:forEach>
  </div>

  <div>
    <label><input type="checkbox" id="saveCheckbox" onclick="valueChange()">駐車場に入れなかったか</label>
  </div>

  <p id="msg"></p>

  <form action="../parking/parking.jsp" method="post" id="parkingForm" style="display:none;">
    <input type="checkbox">車高 <input type="checkbox">車幅 <input type="checkbox">車長 <input type="checkbox">地上高
  </form>

  <form action="/parking/Review.Action" method="post" onsubmit="return checkForInappropriateWords()">
    <p>*任意</p>
    <textarea id="comment" name="comment"></textarea>
    <input type="hidden" id="good" name="good">
    <p><input type="submit" value="投稿する"></p>
  </form>

</body>

</html>
