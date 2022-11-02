package com.sophos.Fullstackbackend.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class Profesor {
    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String titulo;
    private Integer experiencia;
    @OneToMany(targetEntity = ProfesorCurso.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "idprofesor", referencedColumnName = "id")
    private List<ProfesorCurso> cursos;

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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Integer experiencia) {
        this.experiencia = experiencia;
    }

    public List<ProfesorCurso> getCursos() {
        return cursos;
    }

    public void setCursos(List<ProfesorCurso> cursos) {
        this.cursos = cursos;
    }
}
