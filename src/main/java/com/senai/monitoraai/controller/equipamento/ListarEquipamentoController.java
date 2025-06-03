package com.senai.monitoraai.controller.equipamento;

import com.senai.monitoraai.dtos.equipamento.EquipamentoListaDTO;
import com.senai.monitoraai.services.EquipamentoService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("lista-equipamento")
public class ListarEquipamentoController {

    @Autowired
    EquipamentoService service;

    @GetMapping
    public String obterListaEquipamento(Model model) {

        List<EquipamentoListaDTO> equipamentoListaDTO = service.listarEquipamentos();
        model.addAttribute("equipamentoListaDTO", equipamentoListaDTO);

        return "listaequipamento";
    }

}
