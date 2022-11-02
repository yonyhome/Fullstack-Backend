package com.sophos.Fullstackbackend.exception;

public class AlumnoNotFoundException extends RuntimeException{
    public AlumnoNotFoundException(Long id){
        super("No se pudo encontrar un Alumno con el id: "+id);
    }
}