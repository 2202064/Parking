const menuToggle = document.getElementById('menu-toggle');

const menu = document.getElementById('menu');

menuToggle.addEventListener('click', () => {

    if (menu.style.right === '0px') {

        menu.style.right = '-250px';

    } else {

        menu.style.right = '0px';

    }

});
