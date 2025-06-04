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
        equipamentoDTO.setTipo(equipamentoEntity.getTipo());
        equipamentoDTO.setDescricao(equipamentoEntity.getDescricao());

        return equipamentoDTO;
    }
}
