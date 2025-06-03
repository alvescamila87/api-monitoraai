package com.senai.monitoraai.controller.usuario;

import com.senai.monitoraai.dtos.usuario.UsuarioDTO;
import com.senai.monitoraai.dtos.usuario.UsuarioSessaoDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.UsuarioService;
import com.senai.monitoraai.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/visualizar-usuario")
public class VisualizarCadastroUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("/{id}")
    public String obterVisualizacaoUsuario(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes, HttpServletRequest request) {

        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(request);
        if(usuarioSessaoDTO.getId() == 0L){
            return "redirect:/login-usuario";
        }

        try {
            UsuarioDTO visualizarUsuarioDTO = service.obterUsuarioPorId(id);
            model.addAttribute("visualizarUsuarioDTO", visualizarUsuarioDTO);

            return "visualizarcadastrousuario";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-usuario";

        }
    }

}
