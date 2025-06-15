package com.senai.monitoraai.dtos.equipamento;

import com.senai.monitoraai.entities.EquipamentoEntity;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EquipamentoRequestDTO {

    @NotNull
    private String descricao;
    @NotNull
    private String tipo;

    public static EquipamentoRequestDTO of(EquipamentoEntity equipamentoEntity) {
        EquipamentoRequestDTO equipamentoRequestDTO = new EquipamentoRequestDTO();
        equipamentoRequestDTO.setTipo(equipamentoEntity.getTipo());
        equipamentoRequestDTO.setDescricao(equipamentoEntity.getDescricao());

        return equipamentoRequestDTO;
    }
}
