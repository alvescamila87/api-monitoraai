package com.senai.monitoraai.entities;

import com.senai.monitoraai.dtos.equipamento.EquipamentoRequestDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "equipamento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descricao", nullable = false)
    private String descricao;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    public static EquipamentoEntity from(EquipamentoRequestDTO equipamentoRequestDTO) {
        EquipamentoEntity equipamentoEntity = new EquipamentoEntity();
        equipamentoEntity.setTipo(equipamentoRequestDTO.getTipo());
        equipamentoEntity.setDescricao(equipamentoRequestDTO.getDescricao());
        return equipamentoEntity;
    }
}
