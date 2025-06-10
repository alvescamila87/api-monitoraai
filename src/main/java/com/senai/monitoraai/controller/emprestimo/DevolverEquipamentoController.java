package com.senai.monitoraai.controller.emprestimo;

import com.senai.monitoraai.dtos.colaborador.ColaboradorListaDTO;
import com.senai.monitoraai.dtos.emprestimo.DevolucaoDTO;
import com.senai.monitoraai.dtos.emprestimo.DevolverRequestDTO;
import com.senai.monitoraai.dtos.equipamento.EquipamentoListaDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.ColaboradorService;
import com.senai.monitoraai.services.EmprestimoService;
import com.senai.monitoraai.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/devolver-equipamento")
public class DevolverEquipamentoController {

    @Autowired
    EmprestimoService emprestimoService;

    @Autowired
    ColaboradorService colaboradorService;

    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping("/{id}")
    public String obterDevolucaoDeEmprestimo(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {

        try {
            DevolucaoDTO devolverRequestDTO = emprestimoService.obterDevolucaoPorId(id);
            devolverRequestDTO.setDataDevolucao(LocalDate.now());
            model.addAttribute("devolverRequestDTO", devolverRequestDTO);

            List<ColaboradorListaDTO> listaColaboradorDTO = colaboradorService.listarColaborador();
            model.addAttribute("listaColaboradorDTO", listaColaboradorDTO);

            List<EquipamentoListaDTO> listaEquipamentoDTO = equipamentoService.listarEquipamentos();
            model.addAttribute("listaEquipamentoDTO", listaEquipamentoDTO);

            return "cadastrodevolucao";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-emprestimo";
        }
    }

    @PostMapping("/{id}")
    public String devolverEquipamento(@PathVariable Long id, @ModelAttribute("devolverRequestDTO") DevolverRequestDTO devolverRequestDTO, RedirectAttributes redirectAttributes) {
        try {
            emprestimoService.devolverEquipamento(id, devolverRequestDTO);
            return "redirect:/lista-emprestimo?sucesso_devolucao";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/devolver-equipamento/" + id;
        }
    }
}
