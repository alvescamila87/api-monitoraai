package com.senai.monitoraai.controller;

import com.senai.monitoraai.dtos.UsuarioDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.UsuarioService;
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
    public String obterVisualizacaoUsuario(@PathVariable Long id, Model model,  RedirectAttributes redirectAttributes) {
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
