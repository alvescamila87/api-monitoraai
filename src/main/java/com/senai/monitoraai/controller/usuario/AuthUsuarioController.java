package com.senai.monitoraai.controller.usuario;

import com.senai.monitoraai.dtos.usuario.UsuarioAuthDTO;
import com.senai.monitoraai.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class AuthUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterLogin(Model model){
        model.addAttribute("usuarioAuthDTO", new UsuarioAuthDTO());
        return "loginusuario";
    }
}
