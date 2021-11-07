package com.example.finalcatalog.services;

import com.example.finalcatalog.models.entities.Usuario;
import com.example.finalcatalog.models.entities.UsuarioDto;
import com.example.finalcatalog.models.repositories.IUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsuarioImpl implements IUsuarioService {

    final IUsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioImpl(IUsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return (List<Usuario>) usuarioRepository.findAll();
    }

    @Override
    public void guardar(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    @Override
    public Usuario buscarPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<UsuarioDto> obtenerUsuariosDto() {
        List<UsuarioDto> usuariosDto = new ArrayList<>();
        List<Usuario> usuarios = (List<Usuario>) usuarioRepository.findAll();

        if (usuarios.size() > 0) {
            for (Usuario usuario : usuarios) {
                UsuarioDto usuarioDto = new UsuarioDto();
                usuarioDto.setId(usuario.getId());
                usuarioDto.setNombreCompleto(usuario.getNombre() + " " + usuario.getApellido());
                usuarioDto.setTelefono(usuario.getTelefono());
                usuarioDto.setProfesion(usuario.getProfesion().getDescripcion());
                usuarioDto.setDireccion(usuario.getDepartamento().getDescripcion());

                usuariosDto.add(usuarioDto);
            }
        }

        return usuariosDto;
    }


}
