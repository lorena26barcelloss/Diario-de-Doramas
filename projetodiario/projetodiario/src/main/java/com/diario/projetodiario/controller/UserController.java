package com.diario.projetodiario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.diario.projetodiario.model.User;
import com.diario.projetodiario.repository.UserRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/cadastro")
    public String cadastro() {
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String salvarCadastro(User user, Model model, HttpSession session) {
        // opcional: checar duplicidade
        if (userRepository.findByEmail(user.getEmail()) != null) {
            model.addAttribute("erroCadastro", true);
            return "cadastro";
        }

        userRepository.save(user);

        // alternativa: logar automaticamente
        session.setAttribute("usuarioLogado", user);

        // queremos mostrar o alerta na própria página cadastro e depois redirecionar via JS
        model.addAttribute("cadastroOk", true);
        return "cadastro";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String validarLogin(@RequestParam String email,
                               @RequestParam String senha,
                               Model model,
                               HttpSession session) {

        User user = userRepository.findByEmail(email);

        if (user != null && user.getSenha().equals(senha)) {
            session.setAttribute("usuarioLogado", user);
            // sucesso de login - passar para template
            model.addAttribute("loginOk", true);
            return "login";
        }

        // erro de autenticação - o template login.html mostrará o alerta
        model.addAttribute("erroLogin", true);
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}
