package com.senai.monitoraai.controller.usuario;

import com.senai.monitoraai.dtos.usuario.UsuarioDTO;
import com.senai.monitoraai.dtos.usuario.UsuarioRequestDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/atualizar-usuario")
public class AtualizarCadastroUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping("/{id}")
    public String obterAtualizarUsuario(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes){
        try {
            UsuarioDTO atualizarUsuarioDTO = service.obterUsuarioPorId(id);
            model.addAttribute("atualizarUsuarioDTO", atualizarUsuarioDTO);
            return "atualizarcadastrousuario";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-usuario";
        }
    }

    @PostMapping("/{id}")
    public String atualizarUsuario(
            @PathVariable Long id,
            @ModelAttribute("atualizarUsuarioDTO")UsuarioRequestDTO usuarioRequestDTO,
            RedirectAttributes redirectAttributes
    ) {
        try {
            service.atualizarUsuario(id, usuarioRequestDTO);
            return "redirect:/lista-usuario?sucesso_atualizacao";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/atualizar-usuario/" + id;
        }
    }

}

