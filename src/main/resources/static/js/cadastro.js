document.addEventListener('DOMContentLoaded', function () {
    console.debug('cadastro.js:', 'cadastroOk=', window.cadastroOk, 'erroCadastro=', window.erroCadastro);

    if (window.erroCadastro) {
        alert("Esse e-mail já está cadastrado!");
    }

    if (window.cadastroOk) {
        alert("Cadastro realizado com sucesso!");
        window.location.href = "/";
    }
});
