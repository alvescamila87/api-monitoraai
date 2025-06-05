package com.senai.monitoraai.dtos.emprestimo;

import com.senai.monitoraai.entities.EmprestimoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class EmprestimoDTO {

    private Long id;
    private Long colaboradorId;
    private Long equipamentoId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String observacao;

    public static EmprestimoDTO of(EmprestimoEntity emprestimoEntity) {
        EmprestimoDTO emprestimoDTO = new EmprestimoDTO();
        emprestimoDTO.setId(emprestimoEntity.getId());
        emprestimoDTO.setColaboradorId(emprestimoEntity.getColaborador().getId());
        emprestimoDTO.setEquipamentoId(emprestimoEntity.getEquipamento().getId());
        emprestimoDTO.setDataEmprestimo(emprestimoEntity.getDataEmprestimo());
        emprestimoDTO.setDataDevolucao(emprestimoEntity.getDataDevolucao());
        emprestimoDTO.setObservacao(emprestimoEntity.getObservacao());

        return emprestimoDTO;
    }
}
