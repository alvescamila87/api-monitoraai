package com.senai.monitoraai.controller.equipamento;

import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.EquipamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/crud/equipamento")
public class EquipamentoController {

    @Autowired
    EquipamentoService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEquipamento(@PathVariable Long id) {
        try {
            service.deletarEquipamento(id);
            return ResponseEntity.ok().build();
        } catch (InvalidOperationException exception){
            return ResponseEntity.status(404).build();
        }
    }
}
