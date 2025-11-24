package com.diario.projetodiario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.diario.projetodiario.model.User;
import com.diario.projetodiario.services.DoramaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class AndamentoController {

    @Autowired
    private DoramaService doramaService;

    @GetMapping("/andamento")
    public String listar(Model model, HttpSession session) {

        User user = (User) session.getAttribute("usuarioLogado");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("listaAndamento", doramaService.listarAndamento(user));
        return "andamento";
    }
}
