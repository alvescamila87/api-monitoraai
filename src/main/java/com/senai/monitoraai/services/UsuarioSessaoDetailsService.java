package com.senai.monitoraai.services;

import com.senai.monitoraai.dtos.usuario.UsuarioSessaoDTO;
import com.senai.monitoraai.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioSessaoDetailsService implements UserDetailsService {

    @Autowired
    UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repository.findByEmail(email)
                .map(usuario -> new UsuarioSessaoDTO(
                        usuario.getId(),
                        usuario.getNome(),
                        usuario.getSenha()
                ))
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}
