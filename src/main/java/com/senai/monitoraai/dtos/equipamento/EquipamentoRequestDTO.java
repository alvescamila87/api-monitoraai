package com.senai.monitoraai.dtos.equipamento;

import com.senai.monitoraai.entities.EquipamentoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EquipamentoRequestDTO {

    private String descricao;
    private String tipo;

    public static EquipamentoRequestDTO of(EquipamentoEntity equipamentoEntity) {
        EquipamentoRequestDTO equipamentoRequestDTO = new EquipamentoRequestDTO();
        equipamentoRequestDTO.setTipo(equipamentoEntity.getTipo());
        equipamentoRequestDTO.setDescricao(equipamentoEntity.getDescricao());

        return equipamentoRequestDTO;
    }
}
