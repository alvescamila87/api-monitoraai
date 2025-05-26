package com.senai.monitoraai.dtos;

import com.senai.monitoraai.entities.UsuarioEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
        UsuarioListaDTO usuarioDTO = new UsuarioListaDTO();
        usuarioDTO.setId(usuarioEntity.getId());
        usuarioDTO.setNome(usuarioEntity.getNome());
        usuarioDTO.setEmail(usuarioEntity.getEmail());

        return usuarioDTO;
    }
}
