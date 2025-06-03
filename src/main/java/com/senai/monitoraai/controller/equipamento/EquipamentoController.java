package com.senai.monitoraai.controller.equipamento;

import com.senai.monitoraai.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud/equipamento")
public class EquipamentoController {

    @Autowired
    EquipamentoService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEquipamento(Long id) {

        // implementar lógica

        return ResponseEntity.ok().build();
    }

}
