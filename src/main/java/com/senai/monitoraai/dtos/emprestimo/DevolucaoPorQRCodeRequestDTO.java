package com.senai.monitoraai.dtos.emprestimo;

import com.senai.monitoraai.entities.EmprestimoEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class DevolucaoPorQRCodeRequestDTO {

    private String observacao;

    public static DevolucaoPorQRCodeRequestDTO of(EmprestimoEntity emprestimoEntity) {
        DevolucaoPorQRCodeRequestDTO devolucaoPorQRCodeRequestDTO = new DevolucaoPorQRCodeRequestDTO();
        devolucaoPorQRCodeRequestDTO.setObservacao(emprestimoEntity.getObservacao());

        return devolucaoPorQRCodeRequestDTO;
    }
}
