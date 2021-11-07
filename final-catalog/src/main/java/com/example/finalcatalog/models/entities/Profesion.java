package com.example.finalcatalog.models.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_profesion")
public class Profesion implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID_PROFESION")
    private Long id;
    @Column(name = "DESCRIPCION_PROFESION")
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
        return "Profesion{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    private static final long serialVersionUID = 1L;
}
