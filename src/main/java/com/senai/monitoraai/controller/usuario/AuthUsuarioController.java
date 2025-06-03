package com.senai.monitoraai.controller.usuario;

import com.senai.monitoraai.dtos.usuario.UsuarioAuthDTO;
import com.senai.monitoraai.dtos.usuario.UsuarioSessaoDTO;
import com.senai.monitoraai.services.UsuarioService;
import com.senai.monitoraai.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login-usuario")
public class AuthUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterLogin(Model model){

        UsuarioAuthDTO usuarioAuthDTO = new UsuarioAuthDTO();
        model.addAttribute("usuarioAuthDTO", usuarioAuthDTO);

        return "loginusuario";
    }

    @PostMapping
    public String autenticarUsuario(@ModelAttribute("usuarioAuthDTO") UsuarioAuthDTO usuarioAuthDTO, HttpServletRequest request){

        UsuarioSessaoDTO usuarioSessaoDTO = service.autenticarUsuario(usuarioAuthDTO);
        ControleSessao.registrar(request, usuarioSessaoDTO);

        if(usuarioSessaoDTO.getId() == 0L){
            return "redirect:/login-usuario";
        }
        return "redirect:/home";
    }
}
