package com.senai.monitoraai.sessao;

import com.senai.monitoraai.dtos.usuario.UsuarioSessaoDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

public class ControleSessao{

    public static void registrar(HttpServletRequest request, UsuarioSessaoDTO usuarioSessaoDTO){
        HttpSession session = request.getSession(true);
        session.setAttribute("codigoUsuario", usuarioSessaoDTO.getId());
        session.setAttribute("nomeUsuario", usuarioSessaoDTO.getNome());
    }

    public static UsuarioSessaoDTO obter(HttpServletRequest request){
        HttpSession session = request.getSession(true);
        UsuarioSessaoDTO usuarioSessaoDTO = new UsuarioSessaoDTO();
        if(session != null){
            usuarioSessaoDTO.setId((long) session.getAttribute("codigoUsuario"));
            usuarioSessaoDTO.setNome((String) session.getAttribute("nomeUsuario"));
        }
        return usuarioSessaoDTO;
    }

    public static void encerrar(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }
    }
}
