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
public class DevolucaoQRCodeDTO {

    private Long id;
    private String nomeColaborador;
    private String tipoEquipamento;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataEmprestimo;
    @DateTimeFormat(pattern ="dd/MM/yyyy")
    private LocalDate dataDevolucao;
    private String observacao;
    private Boolean devolvido;

    public static DevolucaoQRCodeDTO of(EmprestimoEntity emprestimoEntity) {
        DevolucaoQRCodeDTO devolucaoQRCodeDTO = new DevolucaoQRCodeDTO();
        devolucaoQRCodeDTO.setId(emprestimoEntity.getId());
        devolucaoQRCodeDTO.setNomeColaborador(emprestimoEntity.getColaborador().getNome());
        devolucaoQRCodeDTO.setTipoEquipamento(emprestimoEntity.getEquipamento().getTipo());
        devolucaoQRCodeDTO.setDataEmprestimo(emprestimoEntity.getDataEmprestimo());
        devolucaoQRCodeDTO.setDataDevolucao(emprestimoEntity.getDataDevolucao());
        devolucaoQRCodeDTO.setObservacao(emprestimoEntity.getObservacao());
        devolucaoQRCodeDTO.setDevolvido(emprestimoEntity.getDevolvido());

        return devolucaoQRCodeDTO;
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
