package com.senai.monitoraai.controller.colaborador;

import com.senai.monitoraai.dtos.colaborador.ColaboradorDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/visualizar-colaborador")
public class VisualizarCadastroColaboradorController {

    @Autowired
    ColaboradorService service;

    @GetMapping("/{id}")
    public String obterColaborador(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            ColaboradorDTO visualizarColaboradorDTO = service.obterColaboradorPorID(id);
            model.addAttribute("visualizarColaboradorDTO", visualizarColaboradorDTO);

            return "visualizarcadastrocolaborador";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-colaborador";
        }
    }

}
