package com.senai.monitoraai.entities;

import com.senai.monitoraai.dtos.colaborador.ColaboradorRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Table(name = "colaborador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ColaboradorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "cargo", nullable = false)
    private String cargo;

    @Column(name = "data_nascimento", nullable = false)
    private LocalDate dataNascimento;

    public static ColaboradorEntity of(ColaboradorRequestDTO colaboradorRequestDTO) {
        ColaboradorEntity colaboradorEntity = new ColaboradorEntity();
        colaboradorEntity.setNome(colaboradorRequestDTO.getNome());
        colaboradorEntity.setEmail(colaboradorRequestDTO.getEmail());
        colaboradorEntity.setCargo(colaboradorRequestDTO.getCargo());
        colaboradorEntity.setDataNascimento(colaboradorRequestDTO.getDataNascimento());
        return colaboradorEntity;
    }
}
