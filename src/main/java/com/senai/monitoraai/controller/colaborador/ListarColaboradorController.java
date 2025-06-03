package com.senai.monitoraai.controller.colaborador;

import com.senai.monitoraai.dtos.colaborador.ColaboradorListaDTO;
import com.senai.monitoraai.dtos.usuario.UsuarioSessaoDTO;
import com.senai.monitoraai.services.ColaboradorService;
import com.senai.monitoraai.sessao.ControleSessao;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/lista-colaborador")
public class ListarColaboradorController {

    @Autowired
    ColaboradorService service;

    @GetMapping
    public String obterListaColaborador(Model model, HttpServletRequest request){
        UsuarioSessaoDTO usuarioSessaoDTO = ControleSessao.obter(request);

        if (usuarioSessaoDTO.getId() == 0){
            return "redirect:/loginusuario";
        }

        ColaboradorListaDTO colaboradorListaDTO = new ColaboradorListaDTO();
        model.addAttribute("colaboradorListaDTO", colaboradorListaDTO);
        return "listacolaborador";
    }
}
