package com.senai.monitoraai.services;

import com.senai.monitoraai.dtos.usuario.*;
import com.senai.monitoraai.entities.UsuarioEntity;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository repository;

    public List<UsuarioListaDTO> listarUsuarios() {

        List<UsuarioListaDTO> listaDeUsuariosDTO = new ArrayList<>();

        List<UsuarioEntity> listaDeUsuariosEntity = repository.findAll();

        for(UsuarioEntity usuarioEntity: listaDeUsuariosEntity) {
            listaDeUsuariosDTO.add(UsuarioListaDTO.of(usuarioEntity));
        }

        return listaDeUsuariosDTO;
    }

    public UsuarioDTO obterUsuarioPorId(Long id) {
        Optional<UsuarioEntity> usuarioEntityOptional = repository.findById(id);

        if(usuarioEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Usuário não encontrado.");
        }

        return UsuarioDTO.of(usuarioEntityOptional.get());
    }

    public void adicionarUsuario(UsuarioRequestDTO usuarioRequestDTO) {
        validaDuplicidadeEmail(usuarioRequestDTO.getEmail());

        validarDados(usuarioRequestDTO);

        repository.save(UsuarioEntity.from(usuarioRequestDTO));
    }

    public void atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Optional<UsuarioEntity> usuarioEntityOptional = repository.findById(id);

        if(usuarioEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Usuário não encontrado.");
        }

        Optional<UsuarioEntity> usuarioEntityEmail = repository.findByEmail(usuarioRequestDTO.getEmail());

        if(usuarioEntityEmail.isPresent() && !usuarioEntityOptional.get().getId().equals(id)){
            validaDuplicidadeEmail(usuarioRequestDTO.getEmail());
        }

        if(!usuarioRequestDTO.getNome().isEmpty() || !usuarioRequestDTO.getSenha().isEmpty() || !usuarioRequestDTO.getEmail().isEmpty()) {
            validarDados(usuarioRequestDTO);
        }

        UsuarioEntity usuarioEntity = usuarioEntityOptional.get();
        usuarioEntity.setNome(usuarioRequestDTO.getNome());
        usuarioEntity.setEmail(usuarioRequestDTO.getEmail());
        usuarioEntity.setSenha(usuarioRequestDTO.getSenha());
        repository.save(usuarioEntity);
    }

    public void deletarUsuario(Long id) {
        Optional<UsuarioEntity> usuarioEntityOptional = repository.findById(id);

        if(usuarioEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Usuário não encontrado.");
        }

        repository.delete(usuarioEntityOptional.get());
    }

    public UsuarioSessaoDTO autenticarUsuario(UsuarioAuthDTO usuarioAuthDTO){
        UsuarioSessaoDTO usuarioSessaoDTO = new UsuarioSessaoDTO();
        Optional<UsuarioEntity> usuarioEntityOptional = repository.findByEmail(usuarioAuthDTO.getEmail());

        if(usuarioEntityOptional.isPresent() && usuarioEntityOptional.get().getSenha().equals(usuarioAuthDTO.getSenha())){
            usuarioSessaoDTO.setId(usuarioEntityOptional.get().getId());
            usuarioSessaoDTO.setNome(usuarioEntityOptional.get().getNome());
        }

        return usuarioSessaoDTO;
    }

    protected void validaDuplicidadeEmail(String email) {
        Optional<UsuarioEntity> usuarioEntity = repository.findByEmail(email);

        if(usuarioEntity.isPresent()) {
            throw new InvalidOperationException("E-mail já cadastrado! Tente outro...");
        }

    }

    protected void validarDados(UsuarioRequestDTO usuarioRequestDTO) {

        if(StringUtils.isBlank(usuarioRequestDTO.getNome()) || usuarioRequestDTO.getNome().trim().isEmpty()) {
            throw new InvalidOperationException("Não é permitido nome em branco ou vazio.");
        }

        if(StringUtils.isBlank(usuarioRequestDTO.getEmail()) || usuarioRequestDTO.getEmail().trim().isEmpty()) {
                throw new InvalidOperationException("Não é permitido e-mail em branco ou vazio.");
        }

        if(StringUtils.isBlank(usuarioRequestDTO.getSenha()) || usuarioRequestDTO.getSenha().trim().isEmpty()) {
            throw new InvalidOperationException("Não é permitido senha em branco ou vazio.");
        }

        if(usuarioRequestDTO.getSenha().length() < 5) {
            throw new InvalidOperationException("A senha deve possuir pelo menos 5 caracteres.");
        }

    }
}
