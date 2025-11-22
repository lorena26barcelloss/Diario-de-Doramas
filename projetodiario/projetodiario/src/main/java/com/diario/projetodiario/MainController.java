package com.diario.projetodiario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller 
public class MainController {
    
    @GetMapping("/")
    public String index(HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        return "index";
    }

    @GetMapping("/assistidos")
    public String assistidos(HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        return "assistidos";
    }

    @GetMapping("/andamento")
    public String andamento(HttpSession session) { 
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        return "andamento";
    }       

    @GetMapping("/desejados")
    public String desejados(HttpSession session) {
        if (session.getAttribute("usuarioLogado") == null) {
            return "redirect:/login";
        }
        return "desejados";
    }
}