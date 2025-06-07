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
public class HistoricoDTO {

    private Long id;
    private String nomeColaborador;
    private String tipoEquipamento;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataEmprestimo;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataDevolucao;
    private String observacao;

    public static HistoricoDTO of(EmprestimoEntity emprestimoEntity) {
        HistoricoDTO historicoDTO = new HistoricoDTO();
        historicoDTO.setId(emprestimoEntity.getId());
        historicoDTO.setNomeColaborador(emprestimoEntity.getColaborador().getNome());
        historicoDTO.setTipoEquipamento(emprestimoEntity.getEquipamento().getTipo());
        historicoDTO.setDataEmprestimo(emprestimoEntity.getDataEmprestimo());
        historicoDTO.setDataDevolucao(emprestimoEntity.getDataDevolucao());
        historicoDTO.setObservacao(emprestimoEntity.getObservacao());

        return historicoDTO;
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
