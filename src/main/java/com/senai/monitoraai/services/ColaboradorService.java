package com.senai.monitoraai.services;

import com.senai.monitoraai.dtos.colaborador.ColaboradorDTO;
import com.senai.monitoraai.dtos.colaborador.ColaboradorListaDTO;
import com.senai.monitoraai.dtos.colaborador.ColaboradorRequestDTO;
import com.senai.monitoraai.entities.ColaboradorEntity;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.repositories.ColaboradorRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ColaboradorService {

    @Autowired
    ColaboradorRepository repository;

    public List<ColaboradorListaDTO> listarColaborador() {
        List<ColaboradorListaDTO> listaColaboradorDTO = new ArrayList<>();

        List<ColaboradorEntity> listaColaboradorEntity = repository.findAll();

        for(ColaboradorEntity colaboradorEntity : listaColaboradorEntity) {
            listaColaboradorDTO.add(ColaboradorListaDTO.of(colaboradorEntity));
        }
        return listaColaboradorDTO;
    }

    public ColaboradorDTO obterColaboradorPorID(Long id){
        Optional<ColaboradorEntity> colaboradorEntityOptional = repository.findById(id);

        if(colaboradorEntityOptional.isEmpty()){
            throw new InvalidOperationException("Colaborador não encontrado.");
        }

        return ColaboradorDTO.of(colaboradorEntityOptional.get());
    }

    public void adicionarColaborador(ColaboradorRequestDTO colaboradorRequestDTO) {
        validaDuplicidadeEmail(colaboradorRequestDTO.getEmail());

        validaDados(colaboradorRequestDTO);

        repository.save(ColaboradorEntity.from(colaboradorRequestDTO));
    }

    public void atualizarColaborador(Long id, ColaboradorRequestDTO colaboradorRequestDTO) {
        Optional<ColaboradorEntity> colaboradorEntityOptional = repository.findById(id);

        if(colaboradorEntityOptional.isEmpty()){
            throw new InvalidOperationException("Colaborador não encontrado.");
        }

        Optional<ColaboradorEntity> colaboradorEntityEmail = repository.findByEmail(colaboradorRequestDTO.getEmail());

        if(colaboradorEntityEmail.isPresent() && !colaboradorEntityOptional.get().getId().equals(id)){
            validaDuplicidadeEmail(colaboradorRequestDTO.getEmail());
        }

        validaDados(colaboradorRequestDTO);

        ColaboradorEntity colaboradorEntity = colaboradorEntityOptional.get();
        colaboradorEntity.setNome(colaboradorRequestDTO.getNome());
        colaboradorEntity.setEmail(colaboradorRequestDTO.getEmail());
        colaboradorEntity.setCargo(colaboradorRequestDTO.getCargo());
        colaboradorEntity.setDataNascimento(colaboradorRequestDTO.getDataNascimento());

        repository.save(colaboradorEntity);
    }

    public void deletarColaborador(Long id){
        Optional<ColaboradorEntity> colaboradorEntityOptional = repository.findById(id);

        if(colaboradorEntityOptional.isEmpty()){
            throw new InvalidOperationException("Colaborador não encontrado.");
        }

        repository.delete(colaboradorEntityOptional.get());
    }

    protected void validaDuplicidadeEmail(String email){
        Optional<ColaboradorEntity> colaboradorEntityOptional = repository.findByEmail(email);

        if(colaboradorEntityOptional.isPresent()){
            throw new InvalidOperationException("E-mail já cadastrado! Tente outro...");
        }
    }

    protected void validaDados(ColaboradorRequestDTO colaboradorRequestDTO){
        LocalDate hoje = LocalDate.now();
        LocalDate dataLimiteMinima = hoje.minusYears(120);

        if(colaboradorRequestDTO.getDataNascimento() == null){
            throw new InvalidOperationException("A data de nascimento não pode ser vazia.");
        }
        if(colaboradorRequestDTO.getDataNascimento().isAfter(hoje)){
            throw new InvalidOperationException("A data de nascimento não pode ser no futuro.");
        }
        if(colaboradorRequestDTO.getDataNascimento().isBefore(dataLimiteMinima)){
            throw new InvalidOperationException("A data de nascimento não pode superior a 120 anos.");
        }
        if(StringUtils.isBlank(colaboradorRequestDTO.getNome()) || colaboradorRequestDTO.getNome().trim().isEmpty()){
            throw new InvalidOperationException("O nome não pode estar em branco ou vazio.");
        }

        if(StringUtils.isBlank(colaboradorRequestDTO.getEmail()) || colaboradorRequestDTO.getEmail().trim().isEmpty()){
            throw new InvalidOperationException("O email não pode estar em branco ou vazio.");
        }

        if(StringUtils.isBlank(colaboradorRequestDTO.getCargo()) || colaboradorRequestDTO.getCargo().isEmpty()){
            throw new InvalidOperationException("O cargo não pode estar em branco ou vazio.");
        }
    }
}
