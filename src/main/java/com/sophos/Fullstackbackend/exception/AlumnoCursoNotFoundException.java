package com.sophos.Fullstackbackend.exception;

public class AlumnoCursoNotFoundException extends RuntimeException{
    public AlumnoCursoNotFoundException(Long id){
        super("No se pudo encontrar un Alumno con el id: "+id);
    }
}

