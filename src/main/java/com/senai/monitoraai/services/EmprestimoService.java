package com.senai.monitoraai.services;

import com.senai.monitoraai.dtos.emprestimo.*;
import com.senai.monitoraai.entities.ColaboradorEntity;
import com.senai.monitoraai.entities.EmprestimoEntity;
import com.senai.monitoraai.entities.EquipamentoEntity;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.repositories.ColaboradorRepository;
import com.senai.monitoraai.repositories.EmprestimoRepository;
import com.senai.monitoraai.repositories.EquipamentoRepository;
import org.apache.commons.lang3.StringUtils;
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

        validaDadosEmprestimo(emprestimoRequestDTO);

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
        emprestimoEntity.setDevolvido(false);
        repository.save(emprestimoEntity);
    }

    public void devolverEquipamento(Long id, DevolverRequestDTO devolverRequestDTO) {

        validaDuplicidadeDevolucao(id);

        Optional<EmprestimoEntity> emprestimoEntityOptional = repository.findById(id);

        if(emprestimoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Empréstimo não encontrado.");
        }

        validaDadosDevolucao(devolverRequestDTO.getObservacao());

        EmprestimoEntity emprestimoEntity = emprestimoEntityOptional.get();
        emprestimoEntity.setDataDevolucao(LocalDate.now());
        emprestimoEntity.setObservacao(devolverRequestDTO.getObservacao());
        emprestimoEntity.setDevolvido(true);


        repository.save(emprestimoEntity);
    }

    public void devolverEquipamentoPorQRCode(Long id) {

        validaDuplicidadeDevolucao(id);

        Optional<EmprestimoEntity> emprestimoEntityOptional = repository.findById(id);

        if(emprestimoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Empréstimo não encontrado.");
        }

        EmprestimoEntity emprestimoEntity = emprestimoEntityOptional.get();
        emprestimoEntity.setDataDevolucao(LocalDate.now());
        emprestimoEntity.setObservacao("Devolução via QR Code. Equipamento em condições normais.");
        emprestimoEntity.setDevolvido(true);

        repository.save(emprestimoEntity);
    }

    @Deprecated
    public EmprestimoDTO obterEmprestimoPorId(Long id) {
        Optional<EmprestimoEntity> emprestimoEntityOptional = repository.findById(id);

        if(emprestimoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Empréstimo não encontrado.");
        }

        return EmprestimoDTO.of(emprestimoEntityOptional.get());
    }

    public DevolucaoDTO obterDevolucaoPorId(Long id) {
        Optional<EmprestimoEntity> emprestimoEntityOptional = repository.findById(id);

        if(emprestimoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Empréstimo não encontrado.");
        }

        return DevolucaoDTO.of(emprestimoEntityOptional.get());
    }

    public HistoricoDTO obterHistoricoPorId(Long id) {
        Optional<EmprestimoEntity> emprestimoEntityOptional = repository.findById(id);

        if(emprestimoEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Empréstimo não encontrado.");
        }

        return HistoricoDTO.of(emprestimoEntityOptional.get());
    }

    protected void validaDadosEmprestimo(EmprestimoRequestDTO emprestimoRequestDTO){

        if(emprestimoRequestDTO.getColaboradorId() == null) {
            throw new InvalidOperationException("Informe o colaborador.");
        }

        if(emprestimoRequestDTO.getEquipamentoId() == null) {
            throw new InvalidOperationException("Informe o equipamento.");
        }
    }

    protected void validaDadosDevolucao(String observacao){

        if(StringUtils.isBlank(observacao) || observacao.trim().isEmpty()) {
            throw new InvalidOperationException("Não é permitido detalhes da devolução em branco ou vazio.");
        }

    }

    protected void validaDuplicidadeDevolucao(Long id) {
        boolean jaDevolvido = repository.existsByIdAndDevolvidoTrue(id);
        System.out.println(jaDevolvido);

        if(jaDevolvido) {
            throw new InvalidOperationException("Equipamento já devolvido.");
        }
    }

}
