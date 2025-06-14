package com.senai.monitoraai.controller.commons;

import com.senai.monitoraai.dtos.usuario.UsuarioSessaoDTO;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String obterHome(@AuthenticationPrincipal UsuarioSessaoDTO usuario, Model model) {
        model.addAttribute("nomeUsuario", usuario.getNome());
        return "home";
    }
}
