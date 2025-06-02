package com.senai.monitoraai.dtos.equipamento;

import com.senai.monitoraai.entities.EquipamentoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EquipamentoListaDTO {

    private Long id;
    private String descricao;
    private String tipo;

    public static EquipamentoListaDTO of(EquipamentoEntity equipamentoEntity) {
        EquipamentoListaDTO equipamentoListaDTO = new EquipamentoListaDTO();
        equipamentoListaDTO.setId(equipamentoEntity.getId());
        equipamentoListaDTO.setDescricao(equipamentoEntity.getTipo());
        equipamentoListaDTO.setTipo(equipamentoEntity.getTipo());

        return equipamentoListaDTO;
    }
}
