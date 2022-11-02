package com.sophos.Fullstackbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Alumno {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String facultad;
    private Integer semestre;
    @OneToMany(targetEntity = AlumnoCurso.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idalumno", referencedColumnName = "id")
    private List<AlumnoCurso> cursos;


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

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public List<AlumnoCurso> getCursos() {
        return cursos;
    }

    public void setCursos(List<AlumnoCurso> cursos) {
        this.cursos = cursos;
    }
}
