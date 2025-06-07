package com.senai.monitoraai.dtos.emprestimo;

import com.senai.monitoraai.entities.EmprestimoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@RequiredArgsConstructor
public class EmprestimoDTO {

    private Long id;
    private Long colaboradorId;
    private Long equipamentoId;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataEmprestimo;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
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

    public String getDataEmprestimoFormatada() {
        if (dataEmprestimo == null) return "";
        return dataEmprestimo.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public String getDataDevolucaoFormatada() {
        if (dataDevolucao == null) return "";
        return dataDevolucao.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
