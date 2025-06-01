package com.senai.monitoraai.controller;

import com.senai.monitoraai.dtos.UsuarioRequestDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastro-usuario")
public class CadastroUsuarioController {

    @Autowired
    UsuarioService service;

    @GetMapping
    public String obterUsuario(Model model, RedirectAttributes redirectAttributes) {

        try {
            UsuarioRequestDTO usuarioRequestDTO = new UsuarioRequestDTO();
            model.addAttribute("usuarioRequestDTO", usuarioRequestDTO);

            return "cadastrousuario";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-usuario";
        }
    }


    @PostMapping
    public String adicionarUsuario(@ModelAttribute("usuarioRequestDTO") UsuarioRequestDTO usuarioRequestDTO, RedirectAttributes redirectAttributes) {

        try {
            service.adicionarUsuario(usuarioRequestDTO);
            return "redirect:/lista-usuario?sucesso";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/cadastro-usuario";
        }

    }

}
