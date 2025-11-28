document.addEventListener("DOMContentLoaded", function () {
    console.debug('login.js:', 'loginOk=', window.loginOk, 'loginErro=', window.loginErro);

    if (window.loginOk) {
        alert("Login realizado com sucesso!");
        window.location.href = "/";
    }

    if (window.loginErro) {
        alert("E-mail ou senha inválidos! Tente novamente.");
    }

});
