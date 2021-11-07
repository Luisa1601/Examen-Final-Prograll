package com.example.finalcatalog.services;

import com.example.finalcatalog.models.entities.Profesion;
import com.example.finalcatalog.models.entities.Usuario;
import com.example.finalcatalog.models.repositories.IProfesionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesionImpl implements IProfesionService{

    final IProfesionRepository profesionRepository;

    @Autowired
    public ProfesionImpl(IProfesionRepository profesionRepository){
        this.profesionRepository = profesionRepository;
    }

    @Override
    public List<Profesion> listar() {
        return (List<Profesion>) profesionRepository.findAll();
    }

    @Override
    public void guardar(Profesion profesion) {
        profesionRepository.save(profesion);
    }

    @Override
    public Profesion buscarPorId(Long id) {
        return profesionRepository.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        profesionRepository.deleteById(id);
    }
}
