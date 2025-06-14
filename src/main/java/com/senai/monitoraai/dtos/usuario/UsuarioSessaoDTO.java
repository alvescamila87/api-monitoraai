package com.senai.monitoraai.dtos.usuario;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
@Setter
@AllArgsConstructor
public class UsuarioSessaoDTO implements UserDetails {

    private Long id;
    private String nome;
    private String senha;

    public UsuarioSessaoDTO() {
        this.id = 0L;
        this.nome = "";
        this.senha = "";
    }

    @Override
    public String getUsername() {
        return nome;
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList();
    }

    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }
}
