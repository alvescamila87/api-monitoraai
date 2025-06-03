package com.senai.monitoraai.controller.usuario;

import com.senai.monitoraai.dtos.usuario.UsuarioListaDTO;
import com.senai.monitoraai.dtos.usuario.UsuarioSessaoDTO;
import com.senai.monitoraai.services.UsuarioService;
import com.senai.monitoraai.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lista-usuario")
public class ListarUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterListaUsuario(Model model, HttpServletRequest request) {

        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(request);
        if(usuarioSessaoDTO.getId() == 0){
            return "redirect:/login-usuario";
        }

        List<UsuarioListaDTO> usuarioListaDTO = service.listarUsuarios();
        model.addAttribute("usuarioListaDTO", usuarioListaDTO);

        return "listausuario";
    }
}
