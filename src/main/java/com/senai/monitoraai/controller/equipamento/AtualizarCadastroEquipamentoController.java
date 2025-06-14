package com.senai.monitoraai.controller.equipamento;

import com.senai.monitoraai.dtos.equipamento.EquipamentoDTO;
import com.senai.monitoraai.dtos.equipamento.EquipamentoRequestDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/atualizar-equipamento")
public class AtualizarCadastroEquipamentoController {

    @Autowired
    EquipamentoService service;

    @GetMapping("/{id}")
    public String obterEquipamento(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            EquipamentoDTO atualizarEquipamentoDTO = service.obterEquipamentoPorId(id);
            model.addAttribute("atualizarEquipamentoDTO", atualizarEquipamentoDTO);
            return "atualizarcadastroequipamento";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-equipamento";
        }
    }

    @PostMapping("/{id}")
    public String atualizarEquipamento(@PathVariable Long id, @ModelAttribute("atualizarEquipamentoDTO") EquipamentoRequestDTO equipamentoRequestDTO, RedirectAttributes redirectAttributes) {
        try {
            service.atualizarEquipamento(id, equipamentoRequestDTO);
            return "redirect:/lista-equipamento?sucesso";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/atualizar-equipamento/" + id;
        }
    }

}
