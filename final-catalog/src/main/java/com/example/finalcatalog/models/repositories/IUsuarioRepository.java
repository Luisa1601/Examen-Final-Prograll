package com.example.finalcatalog.models.repositories;

import com.example.finalcatalog.models.entities.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends CrudRepository<Usuario, Long> {

}
