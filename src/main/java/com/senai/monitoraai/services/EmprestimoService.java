package com.senai.monitoraai.services;

import com.senai.monitoraai.dtos.emprestimo.EmprestimoListaDTO;
import com.senai.monitoraai.repositories.EmprestimoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository repository;

    public List<EmprestimoListaDTO> listaEquipamentos() {
        return null;
    }

}
