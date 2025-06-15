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

    @NotBlank(message = "Nome é obrigatório.")
    private String nome;

    @NotBlank(message = "Email é obrigatório.")
    @Email(message = "Email inválido.")
    private String email;

    @NotBlank(message = "Cargo é obrigatório.")
    private String cargo;

    @DateTimeFormat(pattern ="dd/MM/yyyy")
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
