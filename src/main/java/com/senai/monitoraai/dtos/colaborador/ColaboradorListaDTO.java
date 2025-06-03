package com.senai.monitoraai.dtos.colaborador;

import com.senai.monitoraai.entities.ColaboradorEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class ColaboradorListaDTO {

    private Long id;
    private String nome;
    private String email;
    private String cargo;
    private LocalDate dataNascimento;

    public static ColaboradorListaDTO of(ColaboradorEntity colaboradorEntity){
        ColaboradorListaDTO colaboradorListaDTO = new ColaboradorListaDTO();
        colaboradorListaDTO.setId(colaboradorEntity.getId());
        colaboradorListaDTO.setNome(colaboradorEntity.getNome());
        colaboradorListaDTO.setEmail(colaboradorEntity.getEmail());
        colaboradorListaDTO.setCargo(colaboradorEntity.getCargo());
        colaboradorListaDTO.setDataNascimento(colaboradorEntity.getDataNascimento());

        return colaboradorListaDTO;
    }
}
