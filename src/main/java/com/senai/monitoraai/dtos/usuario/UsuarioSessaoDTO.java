package com.senai.monitoraai.dtos.usuario;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UsuarioSessaoDTO {

    private Long id;
    private String nome;
}
