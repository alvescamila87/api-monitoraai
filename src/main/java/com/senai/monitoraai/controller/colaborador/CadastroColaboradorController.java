package com.senai.monitoraai.controller.colaborador;

import com.senai.monitoraai.dtos.colaborador.ColaboradorRequestDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastro-colaborador")
public class CadastroColaboradorController {

    @Autowired
    ColaboradorService service;

    @GetMapping
    public String obterCadastro(Model model, RedirectAttributes redirectAttributes){
        try {
            ColaboradorRequestDTO colaboradorRequestDTO = new ColaboradorRequestDTO();
            model.addAttribute("colaboradorRequestDTO", colaboradorRequestDTO);
            return "cadastrocolaborador";
        } catch (InvalidOperationException exception){
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-colaborador";
        }

    }

    @PostMapping
    public String cadastroColaborador(
            @ModelAttribute("colaboradorRequestDTO") ColaboradorRequestDTO colaboradorRequestDTO,
            RedirectAttributes redirectAttributes
    ) {
        try {
            service.adicionarColaborador(colaboradorRequestDTO);
            return "redirect:/lista-colaborador?sucesso";
        } catch (InvalidOperationException exception){
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/cadastro-colaborador";
        }
    }
}
