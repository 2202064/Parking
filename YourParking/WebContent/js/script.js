const menuButton = document.getElementById('menu-button');
const menu = document.getElementById('menu');

menuButton.addEventListener('click', () => {
    if (menu.style.right === '0px') {
        menu.style.right = '-250px';
    } else {
        menu.style.right = '0px';
    }
});