package com.senai.monitoraai.controller.usuario;

import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/crud/usuario")
public class UsuarioController {

    @Autowired
    UsuarioService service;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable Long id) {
        try{
            service.deletarUsuario(id);
            return ResponseEntity.ok().build();
        } catch (InvalidOperationException exception){
            return ResponseEntity.status(404).build();
        }
    }
}
