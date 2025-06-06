package com.senai.monitoraai.controller.emprestimo;

import com.senai.monitoraai.dtos.emprestimo.EmprestimoListaDTO;
import com.senai.monitoraai.services.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("lista-emprestimo")
public class ListarEmprestimoController {

    @Autowired
    EmprestimoService service;

    @GetMapping
    public String obterListaEmprestimo(Model model) {

        List<EmprestimoListaDTO> emprestimoListaDTO = service.listaEmprestimo();
        model.addAttribute("emprestimoListaDTO", emprestimoListaDTO);

        return "listaemprestimo";
    }

}
