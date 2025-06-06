package com.senai.monitoraai.dtos.emprestimo;

import com.senai.monitoraai.entities.EmprestimoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class EmprestimoRequestDTO {

    private Long colaboradorId;
    private Long equipamentoId;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String observacao;

    public static EmprestimoRequestDTO of(EmprestimoEntity emprestimoEntity) {
        EmprestimoRequestDTO emprestimoRequestDTO = new EmprestimoRequestDTO();
        emprestimoRequestDTO.setColaboradorId(emprestimoEntity.getColaborador().getId());
        emprestimoRequestDTO.setEquipamentoId(emprestimoEntity.getEquipamento().getId());
        emprestimoRequestDTO.setDataEmprestimo(emprestimoEntity.getDataEmprestimo());
        //emprestimoDTO.setDataDevolucao(emprestimoEntity.getDataDevolucao());
        //emprestimoDTO.setObservacao(emprestimoEntity.getObservacao());

        return emprestimoRequestDTO;
    }
}
