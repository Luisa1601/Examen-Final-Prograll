package com.example.finalcatalog.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "tb_usuarios")
public class Usuario implements Serializable {

    @Id //Clave principal
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Autoincrementable
    @Column(name = "ID_USUARIO")
    private Long id;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "APELLIDO")
    private String apellido;
    @Column(name = "CORREO_ELECTRONICO")
    private String correo;
    @Column(name = "TELEFONO")
    private String telefono;
    @Column(name = "FECHA_NACIMIENTO")
    private Date nacimiento;
    @Column(name = "LATITUD")
    private double latitud;
    @Column(name = "LONGITUD")
    private double longitud;
    @Column(name = "FECHA_REGISTRO")
    private java.util.Date registro;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_PROFESION")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @NonNull
    private Profesion profesion;
    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "ID_DEPTO")
    @JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
    @NonNull
    private Departamento departamento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombe) {
        this.nombre = nombe;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }

    public java.util.Date getRegistro() {
        return registro;
    }

    public void setRegistro(java.util.Date registro) {
        this.registro = registro;
    }

    @NonNull
    public Profesion getProfesion() {
        return profesion;
    }

    public void setProfesion(@NonNull Profesion profesion) {
        this.profesion = profesion;
    }

    @NonNull
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(@NonNull Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nombe='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", nacimiento=" + nacimiento +
                ", latitud=" + latitud +
                ", longitud=" + longitud +
                ", registro=" + registro +
                ", profesion=" + profesion +
                ", departamento=" + departamento +
                '}';
    }

    private static final long serialVersionUID = 1L;
}
