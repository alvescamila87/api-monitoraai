package com.senai.monitoraai.controller;

import com.senai.monitoraai.dtos.UsuarioListaDTO;
import com.senai.monitoraai.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lista-usuario")
public class ListarUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterListaUsuario(Model model) {
        UsuarioListaDTO usuarioListaDTO = new UsuarioListaDTO();
        model.addAttribute("usuarioListaDTO", usuarioListaDTO);

        return "listausuario";
    }
}
