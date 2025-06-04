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
public class ColaboradorDTO {

    private Long id;

    @NotBlank
    private String nome;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String cargo;

    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataNascimento;

    public static ColaboradorDTO of(ColaboradorEntity colaboradorEntity){
        ColaboradorDTO colaboradorDTO = new ColaboradorDTO();
        colaboradorDTO.setId(colaboradorEntity.getId());
        colaboradorDTO.setNome(colaboradorEntity.getNome());
        colaboradorDTO.setEmail(colaboradorEntity.getEmail());
        colaboradorDTO.setCargo(colaboradorEntity.getCargo());
        colaboradorDTO.setDataNascimento(colaboradorEntity.getDataNascimento());

        return colaboradorDTO;
    }
}
