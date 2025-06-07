package com.senai.monitoraai.services;

import com.senai.monitoraai.dtos.emprestimo.DevolverRequestDTO;
import com.senai.monitoraai.dtos.emprestimo.EmprestimoDTO;
import com.senai.monitoraai.dtos.emprestimo.EmprestimoListaDTO;
import com.senai.monitoraai.dtos.emprestimo.EmprestimoRequestDTO;
import com.senai.monitoraai.entities.ColaboradorEntity;
import com.senai.monitoraai.entities.EmprestimoEntity;
import com.senai.monitoraai.entities.EquipamentoEntity;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.repositories.ColaboradorRepository;
import com.senai.monitoraai.repositories.EmprestimoRepository;
import com.senai.monitoraai.repositories.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository repository;

    @Autowired
    ColaboradorRepository colaboradorRepository;

    @Autowired
    EquipamentoRepository equipamentoRepository;

    public List<EmprestimoListaDTO> listaEmprestimo() {
        List<EmprestimoListaDTO> listaEmprestimosDTO = new ArrayList<>();

        List<EmprestimoEntity> listaEmprestimoEntity = repository.findAll();

        for(EmprestimoEntity emprestimoEntity : listaEmprestimoEntity) {

            listaEmprestimosDTO.add(EmprestimoListaDTO.of(emprestimoEntity));
        }

        return listaEmprestimosDTO;
    }

    public void emprestarEquipamento(EmprestimoRequestDTO emprestimoRequestDTO) {
        validaDados(emprestimoRequestDTO);

        Optional<ColaboradorEntity> colaboradorEntityOptional = colaboradorRepository.findById(emprestimoRequestDTO.getColaboradorId());

        if(colaboradorEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Colaborador não encontrado.");
        }

        Optional<EquipamentoEntity> equipamentoEntityOptional = equipamentoRepository.findById(emprestimoRequestDTO.getEquipamentoId());

        if(equipamentoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Equipamento não encontrado.");
        }

        EmprestimoEntity emprestimoEntity = new EmprestimoEntity();
        emprestimoEntity.setColaborador(colaboradorEntityOptional.get());
        emprestimoEntity.setEquipamento(equipamentoEntityOptional.get());
        emprestimoEntity.setDataEmprestimo(LocalDate.now());
        repository.save(emprestimoEntity);
    }

    public void devolverEquipamento(Long id, DevolverRequestDTO devolverRequestDTO) {

        Optional<EmprestimoEntity> emprestimoEntityOptional = repository.findById(id);

        if(emprestimoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Empréstimo não encontrado.");
        }

        EmprestimoEntity emprestimoEntity = new EmprestimoEntity();
        emprestimoEntity.setDataDevolucao(LocalDate.now());
        emprestimoEntity.setObservacao(devolverRequestDTO.getObservacao());

        repository.save(emprestimoEntity);
    }

    public EmprestimoDTO obterEmprestimoPorId(Long id) {
        Optional<EmprestimoEntity> emprestimoEntityOptional = repository.findById(id);

        if(emprestimoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Empréstimo não encontrado.");
        }

        return EmprestimoDTO.of(emprestimoEntityOptional.get());
    }

    protected void validaDados(EmprestimoRequestDTO emprestimoRequestDTO){

        if(emprestimoRequestDTO.getColaboradorId() == null) {
            throw new InvalidOperationException("Informe o colaborador.");
        }

        if(emprestimoRequestDTO.getEquipamentoId() == null) {
            throw new InvalidOperationException("Informe o equipamento.");
        }
    }

}
