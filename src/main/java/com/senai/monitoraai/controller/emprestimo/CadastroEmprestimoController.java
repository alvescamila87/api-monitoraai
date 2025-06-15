package com.senai.monitoraai.controller.emprestimo;

import com.senai.monitoraai.dtos.colaborador.ColaboradorListaDTO;
import com.senai.monitoraai.dtos.emprestimo.EmprestimoRequestDTO;
import com.senai.monitoraai.dtos.equipamento.EquipamentoListaDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.ColaboradorService;
import com.senai.monitoraai.services.EmprestimoService;
import com.senai.monitoraai.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/cadastro-emprestimo")
public class CadastroEmprestimoController {

    @Autowired
    EmprestimoService emprestimoService;

    @Autowired
    ColaboradorService colaboradorService;

    @Autowired
    EquipamentoService equipamentoService;

    @GetMapping
    public String obterEmprestimo(Model model, RedirectAttributes redirectAttributes) {
        try {
            EmprestimoRequestDTO emprestimoRequestDTO = new EmprestimoRequestDTO();
            emprestimoRequestDTO.setDataEmprestimo(LocalDate.now());
            model.addAttribute("emprestimoRequestDTO", emprestimoRequestDTO);

            List<ColaboradorListaDTO> listaColaboradorDTO = colaboradorService.listarColaborador();
            model.addAttribute("listaColaboradorDTO", listaColaboradorDTO);

            List<EquipamentoListaDTO> listaEquipamentoDTO = equipamentoService.listarEquipamentos();
            model.addAttribute("listaEquipamentoDTO", listaEquipamentoDTO);
            return "cadastroemprestimo";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-emprestimo";
        }
    }


    @PostMapping
    public String emprestarEquipamento(
            @ModelAttribute("emprestimoRequestDTO") EmprestimoRequestDTO emprestimoRequestDTO,
            RedirectAttributes redirectAttributes
    ) {
        try {
            emprestimoService.emprestarEquipamento(emprestimoRequestDTO);
            return "redirect:/lista-emprestimo?sucesso_emprestimo";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/cadastro-emprestimo";
        }
    }
}