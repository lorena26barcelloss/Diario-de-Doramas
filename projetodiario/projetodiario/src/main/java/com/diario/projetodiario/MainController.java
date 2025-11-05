package com.diario.projetodiario;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller 
public class MainController {
    
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/assistidos")
    public String assistidos() {
        return "assistidos";
    }

    @GetMapping("/andamento")
    public String andamento() { 
        return "andamento";
    }       

    @GetMapping("/desejados")
    public String desejados() {
        return "desejados";
    }
}