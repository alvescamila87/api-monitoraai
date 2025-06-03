package com.senai.monitoraai.controller.commons;

import com.senai.monitoraai.dtos.usuario.UsuarioSessaoDTO;
import com.senai.monitoraai.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/home")
public class HomeController {

    @GetMapping
    public String obterHome(Model model, HttpServletRequest request){

        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(request);

        if(usuarioSessaoDTO.getId() == 0){
            return "redirect:/loginusuario";
        }

        model.addAttribute("nomeUsuario", usuarioSessaoDTO.getNome());
        return "home";
    }
}
