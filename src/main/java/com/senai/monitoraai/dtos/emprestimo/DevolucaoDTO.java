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
public class DevolucaoDTO {

    private Long id;
    private String nomeColaborador;
    private String tipoEquipamento;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataEmprestimo;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataDevolucao;
    private String observacao;

    public static DevolucaoDTO of(EmprestimoEntity emprestimoEntity) {
        DevolucaoDTO devolucaoDTO = new DevolucaoDTO();
        devolucaoDTO.setId(emprestimoEntity.getId());
        devolucaoDTO.setNomeColaborador(emprestimoEntity.getColaborador().getNome());
        devolucaoDTO.setTipoEquipamento(emprestimoEntity.getEquipamento().getTipo());
        devolucaoDTO.setDataEmprestimo(emprestimoEntity.getDataEmprestimo());
        devolucaoDTO.setDataDevolucao(emprestimoEntity.getDataDevolucao());
        devolucaoDTO.setObservacao(emprestimoEntity.getObservacao());

        return devolucaoDTO;
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
