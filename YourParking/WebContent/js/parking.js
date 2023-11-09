const info_Btn = document.getElementById('info_btn');

const review_Btn = document.getElementById('review_btn');

const info = document.getElementById('info');

const review = document.getElementById('review');

info.style.display = 'block';

review.style.display = 'none';

info_Btn.addEventListener('click', () => {

    info.style.display = 'block';

    review.style.display = 'none';
});

review_Btn.addEventListener('click', () => {

    info.style.display = 'none';

    review.style.display = 'block';
});