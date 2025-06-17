package com.senai.monitoraai;

import com.senai.monitoraai.dtos.usuario.UsuarioListaDTO;
import com.senai.monitoraai.entities.UsuarioEntity;
import com.senai.monitoraai.repositories.UsuarioRepository;
import com.senai.monitoraai.services.UsuarioService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UsuarioServiceTest {

    @Mock
    UsuarioRepository usuarioRepository;

    @InjectMocks
    UsuarioService usuarioService;

    @Test
    void when_visualizarListaUsuario_then_listAllThem() {
        List<UsuarioEntity> usuarioEntityList = new ArrayList<>();

        UsuarioEntity user01 = new UsuarioEntity();
        user01.setId(1L);
        user01.setNome("Camila");
        user01.setEmail("camila@gmail.com");
        user01.setSenha("12345");

        UsuarioEntity user02 = new UsuarioEntity();
        user02.setId(2L);
        user02.setNome("João");
        user02.setEmail("joao@gmail.com");
        user02.setSenha("12345");

        usuarioEntityList.add(user01);
        usuarioEntityList.add(user02);

        when(usuarioRepository.findAll()).thenReturn(usuarioEntityList);

        List<UsuarioListaDTO> listaUsuariosDTO = usuarioService.listarUsuarios();

        assertNotNull(listaUsuariosDTO);
        assertEquals(2, listaUsuariosDTO.size());
        assertEquals("Camila", listaUsuariosDTO.get(0).getNome());
        assertEquals("João", listaUsuariosDTO.get(1).getNome());

        verify(usuarioRepository, times(1)).findAll();
    }

}