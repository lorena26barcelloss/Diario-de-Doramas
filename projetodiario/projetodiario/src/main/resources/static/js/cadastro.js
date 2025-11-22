document.addEventListener('DOMContentLoaded', function () {
    if (window.erroCadastro) {
        alert("Esse e-mail já está cadastrado!");
    }

    if (window.cadastroOk) {
        alert("Cadastro realizado com sucesso!");
        window.location.href = "/";
    }
});
