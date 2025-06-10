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
public class EmprestimoListaDTO {

    private Long id;
    private String nomeColaborador;
    private String tipoEquipamento;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataEmprestimo;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataDevolucao;
    private String observacao;
    private Boolean devolvido;


    public static EmprestimoListaDTO of(EmprestimoEntity emprestimoEntity) {
        EmprestimoListaDTO emprestimoListaDTO = new EmprestimoListaDTO();
        emprestimoListaDTO.setId(emprestimoEntity.getId());
        emprestimoListaDTO.setNomeColaborador(emprestimoEntity.getColaborador().getNome());
        emprestimoListaDTO.setTipoEquipamento(emprestimoEntity.getEquipamento().getTipo());
        emprestimoListaDTO.setDataEmprestimo(emprestimoEntity.getDataEmprestimo());
        emprestimoListaDTO.setDataDevolucao(emprestimoEntity.getDataDevolucao());
        emprestimoListaDTO.setDevolvido(emprestimoEntity.getDevolvido());

        return emprestimoListaDTO;
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
