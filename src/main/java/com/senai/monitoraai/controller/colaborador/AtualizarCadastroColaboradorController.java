package com.senai.monitoraai.controller.colaborador;

import com.senai.monitoraai.dtos.colaborador.ColaboradorDTO;
import com.senai.monitoraai.dtos.colaborador.ColaboradorRequestDTO;
import com.senai.monitoraai.dtos.equipamento.EquipamentoDTO;
import com.senai.monitoraai.dtos.equipamento.EquipamentoRequestDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.ColaboradorService;
import com.senai.monitoraai.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/atualizar-colaborador")
public class AtualizarCadastroColaboradorController {

    @Autowired
    ColaboradorService service;

    @GetMapping("/{id}")
    public String obterColaborador(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {

        try {
            ColaboradorDTO atualizarColaboradorDTO = service.obterColaboradorPorID(id);
            model.addAttribute("atualizarColaboradorDTO", atualizarColaboradorDTO);

            return "atualizarcadastrocolaborador";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-colaborador";
        }
    }

    @PostMapping("/{id}")
    public String atualizarEquipamento(@PathVariable Long id, @ModelAttribute("atualizarColaboradorDTO") ColaboradorRequestDTO colaboradorRequestDTO, RedirectAttributes redirectAttributes) {

        try {
            service.atualizarColaborador(id, colaboradorRequestDTO);
            return "redirect:/lista-colaborador?sucesso";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/atualizar-colaborador/" + id;
        }
    }

}
