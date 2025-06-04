package com.senai.monitoraai.controller.colaborador;

import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud/colaborador")
public class ColaboradorController {

    @Autowired
    ColaboradorService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarColaborador(@PathVariable Long id) {

        try{
            service.deletarColaborador(id);
            return ResponseEntity.ok().build();
        } catch (InvalidOperationException exception){
            return ResponseEntity.status(404).build();
        }
    }
}
