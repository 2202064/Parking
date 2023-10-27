<%@page pageEncoding="UTF-8" %>

<style>
/* 全体のスタイル */
body {
  margin: 0;
  font-family: Arial, sans-serif;
}

/* メニューコンテナ全体のスタイル */
.menu-container {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  overflow: hidden;
  text-align: right;
}

/* メニューボタンのスタイル */
.menu-button {
  display: block;
  position: fixed;
  top: 20px;
  right: 20px;
  cursor: pointer;
  z-index: 2;
}

/* メニューバーのスタイル */
.bar {
  display: block;
  width: 25px;
  height: 3px;
  margin: 5px 0;
  background-color: #333;
  transition: 0.4s;
}

/* メニューボタンがチェックされた場合の1つ目のバーのアニメーション */
#menu-toggle:checked ~ .menu-button .bar:nth-child(1) {
  transform: scale(0.5) rotate(45deg) translate(-2px, 3px);
}

/* メニューボタンがチェックされた場合の2つ目のバーのアニメーション */
#menu-toggle:checked ~ .menu-button .bar:nth-child(2) {
  opacity: 0;
}

/* メニューボタンがチェックされた場合の3つ目のバーのアニメーション */
#menu-toggle:checked ~ .menu-button .bar:nth-child(3) {
  transform: scale(0.5) rotate(-45deg) translate(8px, -13px);
}

/* メニュートグルのスタイル */
#menu-toggle {
  display: none;
}

/* メニューのスタイル */
.menu {
  position: fixed;
  top: 0;
  right: 0; /* メニューが画面の右から表示される位置 */
  width: 50%; /* メニューの幅を50%に設定 */
  height: 100%;
  background-color: #f3f3f3;
  transition: 0.4s;
  z-index: 1;
  overflow-y: auto;
  transform: translateX(100%); /* 初期状態で画面外にスライド */
}

/* メニュートグルがチェックされた場合のメニューの表示アニメーション */
#menu-toggle:checked ~ .menu {
  transform: translateX(0); /* メニューを画面内にスライド */
}

/* メニュー内のリストのスタイル */
.menu ul {
  list-style: none;
  padding: 20px;
}

/* メニュー内リストのリンクのスタイル */
.menu ul li a {
  text-decoration: none;
  color: #333;
  font-size: 18px;
  display: block;
  padding: 10px 0;
  transition: 0.2s;
}

/* メニュー内リストのリンクのホバー時のスタイル */
.menu ul li a:hover {
  color: #bf7497;
}
</style>
</head>

<body>
<h1>Your Parking</h1>
<div class="menu-container">
  <input type="checkbox" id="menu-toggle">
  <nav class="menu">
  <% Customer customer = (Customer)session.getAttribute("customer");
  if (customer != null){ %>
    <!-- ログイン時 -->
    <ul>
      <li><a href="#">ログアウト</a></li>
      <li><a href="#">登録情報修正</a></li>
      <li><a href="#">車情報修正</a></li>
    </ul>
  <%}else{%>
    <!-- ログアウト時 -->
    <ul>
      <li><a href="#" id = "out">ログイン</a></li>
      <li><a href="#" id = "out">会員登録</a></li>
    </ul>
  <%}%>
  <label for="menu-toggle" class="menu-button">
    <span class="bar"></span>
    <span class="bar"></span>
    <span class="bar"></span>
  </label>
  </nav>
</div>