package com.example.finalcatalog.models.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_departamento")
public class Departamento implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_DEPTO")
    private Long id;
    @Column(name = "DESCRIPCION_DEPTO")
    private String descripcion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    private static final long serialVersionUID = 1L;
}
