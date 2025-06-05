package com.senai.monitoraai.services;

import com.senai.monitoraai.dtos.emprestimo.EmprestimoListaDTO;
import com.senai.monitoraai.entities.EmprestimoEntity;
import com.senai.monitoraai.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository repository;

    public List<EmprestimoListaDTO> listaEquipamentos() {
        List<EmprestimoListaDTO> listaEmprestimosDTO = new ArrayList<>();

        List<EmprestimoEntity> listaEmprestimoEntity = repository.findAll();

        for(EmprestimoEntity emprestimoEntity : listaEmprestimoEntity) {
            listaEmprestimosDTO.add(EmprestimoListaDTO.of(emprestimoEntity));
        }

        return listaEmprestimosDTO;
    }

}
