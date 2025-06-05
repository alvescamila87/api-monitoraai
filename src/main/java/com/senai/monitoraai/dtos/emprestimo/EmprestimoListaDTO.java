package com.senai.monitoraai.dtos.emprestimo;

import com.senai.monitoraai.entities.EmprestimoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
public class EmprestimoListaDTO {

    private Long id;
    private String nomeColaborador;
    private String tipoEquipamento;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;
    private String observacao;

    public static EmprestimoListaDTO of(EmprestimoEntity emprestimoEntity) {
        EmprestimoListaDTO emprestimoListaDTO = new EmprestimoListaDTO();
        emprestimoListaDTO.setId(emprestimoEntity.getId());
        emprestimoListaDTO.setNomeColaborador(emprestimoEntity.getColaborador().getNome());
        emprestimoListaDTO.setTipoEquipamento(emprestimoEntity.getEquipamento().getTipo());
        emprestimoListaDTO.setDataEmprestimo(emprestimoEntity.getDataEmprestimo());
        emprestimoListaDTO.setDataDevolucao(emprestimoEntity.getDataDevolucao());
        //emprestimoListaDTO.setObservacao(emprestimoEntity.getObservacao());

        return emprestimoListaDTO;
    }
}
