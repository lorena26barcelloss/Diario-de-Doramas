package com.diario.projetodiario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;

import com.diario.projetodiario.model.User;
import com.diario.projetodiario.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarCadastro(User user) {
        userRepository.save(user);
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(String email, String senha) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.getSenha().equals(senha)) {
            return "index"; // login OK
        }

        return "login"; // login inválido
    }
}
