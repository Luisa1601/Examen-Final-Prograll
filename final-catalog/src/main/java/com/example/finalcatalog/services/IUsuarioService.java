package com.example.finalcatalog.services;

import com.example.finalcatalog.models.entities.Usuario;
import com.example.finalcatalog.models.entities.UsuarioDto;

import java.util.List;

public interface IUsuarioService {
    List<Usuario> listarUsuarios();
    void guardar(Usuario usuario);
    Usuario buscarPorId(Long id);
    void eliminar(Long id);
    List<UsuarioDto> obtenerUsuariosDto();
}
