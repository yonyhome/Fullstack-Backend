package com.sophos.Fullstackbackend.exception;

public class CursoNotFoundException extends RuntimeException {
    public CursoNotFoundException(Long id){
        super("No se pudo encontrar un curso con el id: "+id);
    }
}
