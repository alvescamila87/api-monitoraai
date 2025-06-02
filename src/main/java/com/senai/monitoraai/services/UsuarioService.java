package com.senai.monitoraai.services;

import ch.qos.logback.core.util.StringUtil;
import com.senai.monitoraai.dtos.usuario.UsuarioDTO;
import com.senai.monitoraai.dtos.usuario.UsuarioListaDTO;
import com.senai.monitoraai.dtos.usuario.UsuarioRequestDTO;
import com.senai.monitoraai.entities.UsuarioEntity;
import com.senai.monitoraai.exceptions.InvalidOperationException;
import com.senai.monitoraai.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
            UsuarioListaDTO usuarioListaDTO = new UsuarioListaDTO();
            usuarioListaDTO.setId(usuarioEntity.getId());
            usuarioListaDTO.setNome(usuarioEntity.getNome());
            usuarioListaDTO.setEmail(usuarioEntity.getEmail());

            listaDeUsuariosDTO.add(usuarioListaDTO);
        }

        return listaDeUsuariosDTO;
    }

    public UsuarioDTO obterUsuarioPorId(Long id) {
        UsuarioDTO usuarioDTO = new UsuarioDTO();

        Optional<UsuarioEntity> usuarioEntityOptional = repository.findById(id);

        if(usuarioEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Usuário não encontrado!");
        }

        return UsuarioDTO.of(usuarioEntityOptional.get());
    }

    public void adicionarUsuario(UsuarioRequestDTO usuarioRequestDTO) {

        UsuarioEntity usuarioEntity = new UsuarioEntity();

        validaDuplicidadeEmail(usuarioRequestDTO.getEmail());

        validarDados(usuarioRequestDTO);

        usuarioEntity.setNome(usuarioRequestDTO.getNome());
        usuarioEntity.setEmail(usuarioRequestDTO.getEmail());
        usuarioEntity.setSenha(usuarioRequestDTO.getSenha());

        repository.save(usuarioEntity);
    }

    public void atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO) {
        Optional<UsuarioEntity> usuarioEntityOptional = repository.findById(id);

        if(usuarioEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Usuário não encontrado!");
        }

        validaDuplicidadeEmail(usuarioRequestDTO.getEmail());

        if(!usuarioRequestDTO.getNome().isEmpty() || !usuarioRequestDTO.getSenha().isEmpty() || !usuarioRequestDTO.getEmail().isEmpty()) {
            validarDados(usuarioRequestDTO);
        }

        UsuarioEntity usuarioEntity = usuarioEntityOptional.get();
        usuarioEntity.setNome(usuarioRequestDTO.getNome());
        usuarioEntity.setEmail(usuarioRequestDTO.getEmail());
        usuarioEntity.setSenha(usuarioRequestDTO.getSenha());
        repository.save(usuarioEntity);
    }

    public boolean deletar(Long id) {
        Optional<UsuarioEntity> usuarioEntityOptional = repository.findById(id);

        if(usuarioEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Usuário não encontrado");
        }

        repository.delete(usuarioEntityOptional.get());
        return true;
    }

    protected boolean validaDuplicidadeEmail(String email) {
        Optional<UsuarioEntity> usuarioEntity = repository.findByEmail(email);

        if(usuarioEntity.isPresent()) {
            throw new InvalidOperationException("E-mail já cadastrado! Tente outro...");
        };

        return false;
    }

    protected boolean validarDados(UsuarioRequestDTO usuarioRequestDTO) {

        if(StringUtil.isNullOrEmpty(usuarioRequestDTO.getNome()) || usuarioRequestDTO.getNome().trim().isEmpty()) {
            throw new InvalidOperationException("Não é permitido nome em branco ou vazio.");
        }

        if(StringUtil.isNullOrEmpty(usuarioRequestDTO.getEmail()) || usuarioRequestDTO.getEmail().trim().isEmpty()) {
                throw new InvalidOperationException("Não é permitido e-mail em branco ou vazio.");
        }

        if(StringUtil.isNullOrEmpty(usuarioRequestDTO.getSenha()) || usuarioRequestDTO.getSenha().trim().isEmpty()) {
            throw new InvalidOperationException("Não é permitido senha em branco ou vazio.");
        }

        if(usuarioRequestDTO.getSenha().length() < 5) {
            throw new InvalidOperationException("A senha deve possuir pelo menos 5 caracteres.");
        }

        return false;
    }
}
