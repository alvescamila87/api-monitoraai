package com.senai.monitoraai.controller.equipamento;

import com.senai.monitoraai.dtos.equipamento.EquipamentoDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/visualizar-equipamento")
public class VisualizarCadastroEquipamentoController {

    @Autowired
    EquipamentoService service;

    @GetMapping("/{id}")
    public String obterEquipamento(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            EquipamentoDTO visualizarEquipamentoDTO = service.obterEquipamentoPorId(id);
            model.addAttribute("visualizarEquipamentoDTO", visualizarEquipamentoDTO);
            return "visualizarcadastroequipamento";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-equipamento";
        }
    }

}
