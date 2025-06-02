package com.senai.monitoraai.controller.commons;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @PostMapping
    public String obterLogout(){

        //falta o controle de acesso
        return "redirect:/login";
    }
}
