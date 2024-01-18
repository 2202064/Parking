var starClicked = false;

function changeImage(starNumber) {
  starClicked = true;
  for (var i = 1; i <= 5; i++) {
    var starElement = document.getElementById("star" + i);
    if (i <= starNumber) {
      starElement.src = "../img/sano" + i + ".png";
    } else {
      starElement.src = '../img/star.png';
    }
  }
}

var Words = ["死ね", "カス", "しね"];

function containsInappropriateWords(text) {
  for (var i = 0; i < Words.length; i++) {
    if (text.includes(Words[i])) {
      return true;
    }
  }
  return false;
}

function checkForInappropriateWords() {
  var userInput = document.getElementById("comment").value;
  if (!starClicked) {
    alert("佐野にしてください！");
    return false;
  }
  if (containsInappropriateWords(userInput)) {
    alert("不適切な単語が含まれています。投稿できません。");
    return false;
  }
  return true;
}

function valueChange() {
  if (saveCheckbox.checked) {
    msg.innerText = '入れなかった理由を教えてください';
    parkingForm.style.display = 'block';
  } else {
    msg.innerText = '';
    parkingForm.style.display = 'none';
  }
}

let saveCheckbox = document.getElementById('saveCheckbox');
let msg = document.getElementById('msg');
let parkingForm = document.getElementById('parkingForm');
