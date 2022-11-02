package com.sophos.Fullstackbackend.model;

import jdk.jfr.Name;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String requisito;

    private Integer creditos;
    private Integer cupos;

    @OneToMany(targetEntity = AlumnoCurso.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idcurso", referencedColumnName = "id")
    private List<AlumnoCurso> alumnos;

    @OneToMany(targetEntity = ProfesorCurso.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idcurso", referencedColumnName = "id")
    private List<ProfesorCurso> profesores;





    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    public List<AlumnoCurso> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<AlumnoCurso> alumnos) {
        this.alumnos = alumnos;
    }

    public List<ProfesorCurso> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<ProfesorCurso> profesores) {
        this.profesores = profesores;
    }
}
