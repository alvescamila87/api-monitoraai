package com.senai.monitoraai.controller.equipamento;

import com.senai.monitoraai.dtos.equipamento.EquipamentoRequestDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/cadastro-equipamento")
public class CadastroEquipamentoController {

    @Autowired
    EquipamentoService service;

    @GetMapping
    public String obterEquipamento(Model model, RedirectAttributes redirectAttributes) {
        try {
            EquipamentoRequestDTO equipamentoRequestDTO = new EquipamentoRequestDTO();
            model.addAttribute("equipamentoRequestDTO", equipamentoRequestDTO);

            return "cadastroequipamento";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-equipamento";
        }
    }

    @PostMapping
    public String adicionarEquipamento(@ModelAttribute("equipamentoRequestDTO") EquipamentoRequestDTO equipamentoRequestDTO, RedirectAttributes redirectAttributes) {
        try {
            service.adicionarEquipamento(equipamentoRequestDTO);
            return "redirect:/lista-equipamento?sucesso";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/cadastro-equipamento";
        }

    }

}
