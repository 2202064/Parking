function btnConsent() {
    if (consent.checked) {
        document.getElementById("btn-consent").disabled = "";
    } else {
        document.getElementById("btn-consent").disabled = "disabled";
    }
}
window.onload = btnConsent;