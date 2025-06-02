package com.senai.monitoraai.dtos.equipamento;

import com.senai.monitoraai.entities.EquipamentoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EquipamentoDTO {

    private Long id;
    private String descricao;
    private String tipo;

    public static EquipamentoDTO of(EquipamentoEntity equipamentoEntity) {
        EquipamentoDTO equipamentoDTO = new EquipamentoDTO();
        equipamentoDTO.setId(equipamentoEntity.getId());
        equipamentoDTO.setDescricao(equipamentoEntity.getDescricao());
        equipamentoDTO.setTipo(equipamentoEntity.getTipo());

        return equipamentoDTO;
    }
}
