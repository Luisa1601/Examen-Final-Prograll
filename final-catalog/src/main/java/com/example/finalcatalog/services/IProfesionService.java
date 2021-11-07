package com.example.finalcatalog.services;

import com.example.finalcatalog.models.entities.Profesion;

import java.util.List;

public interface IProfesionService {
    List<Profesion> listar();
    void guardar(Profesion profesion);
    Profesion buscarPorId(Long id);
    void eliminar(Long id);
}
