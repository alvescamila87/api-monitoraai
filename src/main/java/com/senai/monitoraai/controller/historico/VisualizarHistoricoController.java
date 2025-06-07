package com.senai.monitoraai.controller.historico;

import com.senai.monitoraai.dtos.emprestimo.EmprestimoDTO;
import com.senai.monitoraai.dtos.emprestimo.HistoricoDTO;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/visualizar-historico")
public class VisualizarHistoricoController {

    @Autowired
    EmprestimoService service;

    @GetMapping("/{id}")
    public String obterHistoricoDoItem(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {

        try {
            HistoricoDTO visualizarHistoricoDTO = service.obterHistoricoPorId(id);
            model.addAttribute("visualizarHistoricoDTO", visualizarHistoricoDTO);

            return "visualizarhistorico";
        } catch (InvalidOperationException exception) {
            redirectAttributes.addFlashAttribute("erro", exception.getMessage());
            return "redirect:/lista-emprestimo";
        }
    }

}
