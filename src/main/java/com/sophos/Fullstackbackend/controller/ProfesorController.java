package com.sophos.Fullstackbackend.controller;
import com.sophos.Fullstackbackend.exception.ProfesorNotFoundException;
import com.sophos.Fullstackbackend.model.Profesor;
import com.sophos.Fullstackbackend.repository.ProfesorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class ProfesorController {
    @Autowired
    private ProfesorRepository profesorRepository;


    @PostMapping("/profesor")
    public Profesor RegistrarProfesor(@RequestBody Profesor newProfesor){
        return  profesorRepository.save(newProfesor);
    }

    @GetMapping("/profesores")
    public List<Profesor> FindAllProfesor(){
        return profesorRepository.findAll();
    }
    @GetMapping("/profesor/{id}")
    Profesor getProfesorById(@PathVariable Long id){
        return profesorRepository.findById(id)
                .orElseThrow( ()-> new ProfesorNotFoundException(id));
    }

    @PutMapping("profesor/{id}")
    Profesor updateProfesor(@RequestBody Profesor newProfesor, @PathVariable Long id){
        return profesorRepository.findById(id)
                .map(profesor -> {
                    profesor.setNombre(newProfesor.getNombre());
                    profesor.setExperiencia(newProfesor.getExperiencia());
                    profesor.setTitulo(newProfesor.getTitulo());
                    profesor.setCursos(newProfesor.getCursos());
                    return profesorRepository.save(profesor);
                }).orElseThrow(()-> new ProfesorNotFoundException(id));
    }

    @DeleteMapping("profesor/{id}")
    String deleteProfesor(@PathVariable Long id){
        if(!profesorRepository.existsById(id)){
            throw new ProfesorNotFoundException(id);
        }
        profesorRepository.deleteById(id);
        return "Se elimino correctamente el Profesor con el id: "+id;
    }
}
