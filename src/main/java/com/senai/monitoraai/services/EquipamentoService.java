package com.senai.monitoraai.services;

import com.senai.monitoraai.dtos.equipamento.EquipamentoDTO;
import com.senai.monitoraai.dtos.equipamento.EquipamentoListaDTO;
import com.senai.monitoraai.dtos.equipamento.EquipamentoRequestDTO;
import com.senai.monitoraai.entities.EquipamentoEntity;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.repositories.EquipamentoRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EquipamentoService {

    @Autowired
    EquipamentoRepository repository;

    public List<EquipamentoListaDTO> listarEquipamentos() {

        List<EquipamentoListaDTO> listaEquipamentosDTO = new ArrayList<>();

        List<EquipamentoEntity> listaEquipamentosEntity = repository.findAll();

        for(EquipamentoEntity equipamentoEntity : listaEquipamentosEntity) {
            EquipamentoListaDTO equipamentoListaDTO = new EquipamentoListaDTO();
            equipamentoListaDTO.setId(equipamentoEntity.getId());
            equipamentoListaDTO.setDescricao(equipamentoEntity.getDescricao());
            equipamentoListaDTO.setTipo(equipamentoEntity.getTipo());

            listaEquipamentosDTO.add(equipamentoListaDTO);
        }

        return listaEquipamentosDTO;
    }

    public void adicionarEquipamento(EquipamentoRequestDTO equipamentoRequestDTO) {
        EquipamentoEntity equipamentoEntity = new EquipamentoEntity();

        validaDados(equipamentoRequestDTO);

        equipamentoEntity.setTipo(equipamentoRequestDTO.getTipo());
        equipamentoEntity.setDescricao(equipamentoRequestDTO.getDescricao());

        repository.save(equipamentoEntity);
    }

    public void atualizarEquipamento(Long id, EquipamentoRequestDTO equipamentoRequestDTO) {
        Optional<EquipamentoEntity> equipamentoEntityOptional = repository.findById(id);

        if(equipamentoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Equipamento não encontrado.");
        }

        validaDados(equipamentoRequestDTO);

        EquipamentoEntity equipamentoEntity = equipamentoEntityOptional.get();
        equipamentoEntity.setTipo(equipamentoRequestDTO.getTipo());
        equipamentoEntity.setDescricao(equipamentoRequestDTO.getDescricao());

        repository.save(equipamentoEntity);
    }

    public boolean deletarEquipamento(Long id) {
        Optional<EquipamentoEntity> equipamentoEntityOptional = repository.findById(id);

        if(equipamentoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Equipamento não encontrado.");
        }

        repository.delete(equipamentoEntityOptional.get());
        return true;
    }

    public EquipamentoDTO obterEquipamentoPorId(Long id) {
        Optional<EquipamentoEntity> equipamentoEntityOptional = repository.findById(id);

        if(equipamentoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Equipamento não encontrado.");
        }

        return EquipamentoDTO.of(equipamentoEntityOptional.get());
    }

    protected void validaDados(EquipamentoRequestDTO equipamentoRequestDTO) {
        if(StringUtils.isBlank(equipamentoRequestDTO.getTipo()) || equipamentoRequestDTO.getTipo().trim().isEmpty()) {
            throw new InvalidOperationException("Não é permitido tipo em branco ou vazio.");
        }

        if(StringUtils.isBlank(equipamentoRequestDTO.getDescricao()) || equipamentoRequestDTO.getDescricao().trim().isEmpty()) {
            throw new InvalidOperationException("Não é permitido descrição em branco ou vazio.");
        }
    }
}
