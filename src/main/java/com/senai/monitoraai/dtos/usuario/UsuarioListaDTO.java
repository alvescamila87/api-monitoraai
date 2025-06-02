package com.senai.monitoraai.dtos.usuario;

import com.senai.monitoraai.entities.UsuarioEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class UsuarioListaDTO {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    public static UsuarioListaDTO of(UsuarioEntity usuarioEntity) {
        UsuarioListaDTO usuarioListaDTO = new UsuarioListaDTO();
        usuarioListaDTO.setId(usuarioEntity.getId());
        usuarioListaDTO.setNome(usuarioEntity.getNome());
        usuarioListaDTO.setEmail(usuarioEntity.getEmail());

        return usuarioListaDTO;
    }
}
