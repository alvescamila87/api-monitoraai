package com.senai.monitoraai.dtos.colaborador;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.senai.monitoraai.entities.ColaboradorEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@RequiredArgsConstructor
public class ColaboradorListaDTO {

    private Long id;
    private String nome;
    private String email;
    private String cargo;

    @JsonFormat(pattern = "MM/dd/yyyy")
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

    public String getDataNascimentoFormatada() {
        if (dataNascimento == null) return "";
        return dataNascimento.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
