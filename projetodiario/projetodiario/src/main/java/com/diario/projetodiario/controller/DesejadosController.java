package com.diario.projetodiario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.diario.projetodiario.model.Dorama;
import com.diario.projetodiario.model.User;
import com.diario.projetodiario.services.DoramaService;

import jakarta.servlet.http.HttpSession;

@Controller
public class DesejadosController {

    @Autowired
    private DoramaService doramaService;

    @GetMapping("/desejados")
    public String listar(Model model, HttpSession session) {

        User user = (User) session.getAttribute("usuarioLogado");

        if (user == null) {
            return "redirect:/login";
        }

        model.addAttribute("listaDesejados", doramaService.listarDesejados(user));
        return "desejados";
    }

    @PostMapping("/desejados/add")
    public String adicionar(Dorama dorama, HttpSession session) {

        User user = (User) session.getAttribute("usuarioLogado");

        if (user == null) {
            return "redirect:/login";
        }

        doramaService.adicionarDesejado(user, dorama);
        return "redirect:/desejados";
    }

    @PostMapping("/desejados/toAndamento")
    public String moverParaAndamento(@RequestParam Long id, HttpSession session) {

        User user = (User) session.getAttribute("usuarioLogado");

        if (user == null) {
            return "redirect:/login";
        }

        doramaService.moverDesejadoParaAndamento(id);
        return "redirect:/desejados";
    }

    @PostMapping("/desejados/toAssistidos")
    public String moverParaAssistidos(@RequestParam Long id, HttpSession session) {

        User user = (User) session.getAttribute("usuarioLogado");

        if (user == null) {
            return "redirect:/login";
        }

        doramaService.moverDesejadoParaAssistido(id);
        return "redirect:/desejados";
    }

    @PostMapping("/desejados/delete")
    public String deletar(@RequestParam Long id, HttpSession session) {

        User user = (User) session.getAttribute("usuarioLogado");

         if (user == null) {
             return "redirect:/login";
         }

        doramaService.deletar(id);

        return "redirect:/desejados";
    }
}
