package com.senai.monitoraai.dtos.emprestimo;

import com.senai.monitoraai.entities.EmprestimoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class DevolverRequestDTO {

    private Long id;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataDevolucao;
    private String observacao;

    public static DevolverRequestDTO of(EmprestimoEntity emprestimoEntity) {
        DevolverRequestDTO devolverEquipamentoDTO = new DevolverRequestDTO();
        devolverEquipamentoDTO.setId(emprestimoEntity.getId());
        devolverEquipamentoDTO.setDataDevolucao(emprestimoEntity.getDataDevolucao());
        devolverEquipamentoDTO.setObservacao(emprestimoEntity.getObservacao());

        return devolverEquipamentoDTO;
    }
}
