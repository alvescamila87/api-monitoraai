package com.senai.monitoraai.controller.colaborador;

import com.senai.monitoraai.services.ColaboradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/atualizar-colaborador")
public class AtualizarColaboradorController {

    @Autowired
    ColaboradorService service;
}
