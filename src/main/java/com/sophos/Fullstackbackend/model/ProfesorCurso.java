package com.sophos.Fullstackbackend.model;
import jdk.jfr.Name;

import javax.persistence.*;

@Entity
public class ProfesorCurso {
    @Id
    @GeneratedValue
    private Long id;
    private Long idcurso;

    @Column
    @Name("idprofesor")
    private Long idprofesor;




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

    public Long getIdprofesor() {
        return idprofesor;
    }

    public void setIdprofesor(Long idprofesor) {
        this.idprofesor = idprofesor;
    }
}




