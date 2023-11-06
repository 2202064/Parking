const menuToggle = document.getElementById('menu-toggle');

const menu = document.getElementById('menu');

menuToggle.addEventListener('click', () => {

    if (menu.style.right === '0px') {

        menu.style.right = '-250px';

    } else {

        menu.style.right = '0px';

    }

});

const correction = document.getElementById('correction');

const corUrl = document.getElementById('cor_url');

correction.style.display = 'none';

cor_url.style.display = 'none';

correction.addEventListener('click', () => {

    if (corUrl.style.display == 'block') {

        corUrl.style.display = 'none';

    } else {

        corUrl.style.display = 'block';

    }
});
