package com.senai.monitoraai.dtos.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioSessaoDTO {

    private Long id;
    private String nome;

    public UsuarioSessaoDTO() {
        this.id = 0L;
        this.nome = "";
    }
}
