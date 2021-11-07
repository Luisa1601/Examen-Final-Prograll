package com.example.finalcatalog.services;

import com.example.finalcatalog.models.entities.Departamento;
import com.example.finalcatalog.models.entities.Profesion;

import java.util.List;

public interface IDepartamentoService {
    List<Departamento> listar();
    void guardar(Departamento departamento);
    Departamento buscarPorId(Long id);
    void eliminar(Long id);
}
