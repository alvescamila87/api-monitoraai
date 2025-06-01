package com.senai.monitoraai.services;

import com.senai.monitoraai.dtos.UsuarioDTO;
import com.senai.monitoraai.dtos.UsuarioListaDTO;
import com.senai.monitoraai.dtos.UsuarioRequestDTO;
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

        boolean resultado = validaDuplicidadeEmail(usuarioRequestDTO.getEmail());

        if(resultado) {
            throw new InvalidOperationException("E-mail já cadastrado. Tente outro...");
        }

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

        UsuarioEntity usuarioEntity = usuarioEntityOptional.get();
        repository.save(usuarioEntity);

    }

    public void deletar(Long id) {
        Optional<UsuarioEntity> usuarioEntityOptional = repository.findById(id);

        if(usuarioEntityOptional.isEmpty()) {
            throw new InvalidOperationException("Usuário não encontrado");
        }

        repository.delete(usuarioEntityOptional.get());
    }

    protected boolean validaDuplicidadeEmail(String email) {
        Optional<UsuarioEntity> usuarioEntity = repository.findByEmail(email);

        if(usuarioEntity.isPresent()) {
            throw new InvalidOperationException("E-mail já cadastrado! Tente outro...");
        };

        return false;
    }
}
