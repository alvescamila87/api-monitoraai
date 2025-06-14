package com.senai.monitoraai.controller.colaborador;

import com.senai.monitoraai.dtos.colaborador.ColaboradorListaDTO;
import com.senai.monitoraai.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/lista-colaborador")
public class ListarColaboradorController {

    @Autowired
    ColaboradorService service;

    @GetMapping
    public String obterListaColaborador(Model model){
        List<ColaboradorListaDTO> colaboradorListaDTO = service.listarColaborador();
        model.addAttribute("colaboradorListaDTO", colaboradorListaDTO);
        return "listacolaborador";
    }
}
