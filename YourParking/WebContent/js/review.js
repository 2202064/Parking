var starClicked = false;

function changeImage(starNumber) {
  starClicked = true;
  for (var i = 1; i <= 5; i++) {
    var starElement = document.getElementById("star" + i);
    if(i <= starNumber){
      starElement.src = "../img/sano.png";
    }else {
      starElement.src = '../img/star.png';
    }
  }
  str = document.querySelector('input[name="good"]');
  str.value = starNumber;
  console.log(str)

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

function scoreconfirm(event) {
  const selectedScore = document.querySelector('input[name="good"]');
  if (!selectedScore.value) {
    alert("評価してください");
    event.preventDefault();
    return false;
  }
}

const form = document.querySelector('form');
form.addEventListener('submit', scoreconfirm);

function checkForInappropriateWords() {
  if (containsInappropriateWords(comment)) {
    alert("不適切な単語が含まれています。投稿できません。");
    return false;
  }
  return true;
}

let saveCheckbox = document.getElementById('saveCheckbox');
let msg = document.getElementById('msg');
let parkingForm = document.getElementById('parkingForm');

parkingForm.style.display = 'none';

function valueChange() {
  if (saveCheckbox.checked) {
    msg.innerText = '入れなかった理由を教えてください';
    parkingForm.style.display = 'block';
  } else {
    msg.innerText = '';
    parkingForm.style.display = 'none';
  }
}
