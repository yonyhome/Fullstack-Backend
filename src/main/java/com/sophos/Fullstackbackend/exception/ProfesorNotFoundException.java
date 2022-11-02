package com.sophos.Fullstackbackend.exception;

public class ProfesorNotFoundException extends RuntimeException{
    public ProfesorNotFoundException(Long id){
        super("No se pudo encontrar un profesor con el id: "+id);
    }
}
