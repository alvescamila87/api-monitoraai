package com.senai.monitoraai.controller.commons;

import com.senai.monitoraai.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @PostMapping
    public String obterLogout(HttpServletRequest request){

        ControleSessao.encerrar(request);
        return "redirect:/login-usuario";
    }
}
