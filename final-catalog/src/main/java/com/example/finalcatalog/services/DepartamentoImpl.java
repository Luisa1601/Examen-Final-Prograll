package com.example.finalcatalog.services;

import com.example.finalcatalog.models.entities.Departamento;
import com.example.finalcatalog.models.repositories.IDepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoImpl implements IDepartamentoService{

    final IDepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoImpl(IDepartamentoRepository departamentoRepository){
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public List<Departamento> listar() {
        return (List<Departamento>) departamentoRepository.findAll();
    }

    @Override
    public void guardar(Departamento departamento) {
        departamentoRepository.save(departamento);
    }

    @Override
    public Departamento buscarPorId(Long id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        departamentoRepository.deleteById(id);
    }
}
