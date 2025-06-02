package com.senai.monitoraai.services;

import com.senai.monitoraai.dtos.equipamento.EquipamentoListaDTO;
import com.senai.monitoraai.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EquipamentoService {

    @Autowired
    EquipamentoRepository repository;

    public List<EquipamentoListaDTO> listarEquipamentos() {

        return null;
    }
}
