package com.senai.monitoraai.dtos.colaborador;

import com.senai.monitoraai.entities.ColaboradorEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class ColaboradorRequestDTO {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String cargo;

    @DateTimeFormat(pattern ="dd/mm/yyyy")
    private LocalDate dataNascimento;

    public static ColaboradorRequestDTO of(ColaboradorEntity colaboradorEntity){
        ColaboradorRequestDTO colaboradorRequestDTO = new ColaboradorRequestDTO();
        colaboradorRequestDTO.setId(colaboradorEntity.getId());
        colaboradorRequestDTO.setNome(colaboradorEntity.getNome());
        colaboradorRequestDTO.setEmail(colaboradorEntity.getEmail());
        colaboradorRequestDTO.setCargo(colaboradorEntity.getCargo());
        colaboradorRequestDTO.setDataNascimento(colaboradorEntity.getDataNascimento());

        return colaboradorRequestDTO;
    }
}
