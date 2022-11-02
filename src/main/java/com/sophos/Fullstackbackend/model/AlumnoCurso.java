package com.sophos.Fullstackbackend.model;

import jdk.jfr.Name;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AlumnoCurso {
    @Id
    @GeneratedValue
    private Long id;
    private Long idcurso;

    @Column
    @Name("idalumno")
    private Long idalumno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdcurso() {
        return idcurso;
    }

    public void setIdcurso(Long idcurso) {
        this.idcurso = idcurso;
    }

    public Long getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(Long idalumno) {
        this.idalumno = idalumno;
    }
}
