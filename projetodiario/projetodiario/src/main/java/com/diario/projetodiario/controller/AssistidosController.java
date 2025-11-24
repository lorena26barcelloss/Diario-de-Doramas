package com.diario.projetodiario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.diario.projetodiario.model.Dorama;
import com.diario.projetodiario.model.User;
import com.diario.projetodiario.services.DoramaService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/assistidos")
public class AssistidosController {

    @Autowired
    private DoramaService doramaService;

    @GetMapping
    public String listar(Model model, HttpSession session) {
        User user = (User) session.getAttribute("usuarioLogado");

        if (user == null) {
            return "redirect:/login";
        }

        List<Dorama> assistidos = doramaService.listarAssistidos(user);
        model.addAttribute("doramas", assistidos);

        return "assistidos";
    }


    @PostMapping("/avaliar")
    public String avaliar(Long id, Integer nota) {
        doramaService.avaliar(id, nota);
        return "redirect:/assistidos";
    }

    @GetMapping("/voltar-andamento/{id}")
    public String moverParaAndamento(@PathVariable Long id) {
        doramaService.moverAssistidoParaAndamento(id);
        return "redirect:/assistidos";
    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable Long id) {
        doramaService.deletar(id);
        return "redirect:/assistidos";
    }
}
