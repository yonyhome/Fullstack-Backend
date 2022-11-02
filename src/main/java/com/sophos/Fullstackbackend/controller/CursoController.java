package com.sophos.Fullstackbackend.controller;

import com.sophos.Fullstackbackend.exception.CursoNotFoundException;
import com.sophos.Fullstackbackend.exception.ProfesorNotFoundException;
import com.sophos.Fullstackbackend.model.Curso;
import com.sophos.Fullstackbackend.model.ProfesorCurso;
import com.sophos.Fullstackbackend.repository.AlumnoCursoRepository;

import com.sophos.Fullstackbackend.repository.ProfesorCursoRepository;
import com.sophos.Fullstackbackend.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class CursoController {
    @Autowired
    private CursoRepository cursoRepository;
    @Autowired
    private AlumnoCursoRepository alumnoCursoRepository;
    @Autowired
    private ProfesorCursoRepository profesorCursoRepository;


    @PostMapping("/curso")
    Curso newCurso(@RequestBody Curso newCurso){
        return cursoRepository.save(newCurso);
    }

    @GetMapping("/cursos")
    List<Curso> getAllCursos(){
        return cursoRepository.findAll();
    }

    @GetMapping("/curso/{id}")
    Curso getCursoById(@PathVariable Long id){
        return cursoRepository.findById(id)
                .orElseThrow( ()-> new CursoNotFoundException(id));
    }


    @GetMapping("/profesorcurso/{id}")
    ProfesorCurso getAlumnosCursoById(@PathVariable Long id){
             return profesorCursoRepository.findById(id)
                     .orElseThrow(() -> new ProfesorNotFoundException(id));
    }



    @PutMapping("curso/{id}")
    Curso updateCurso(@RequestBody Curso newCurso, @PathVariable Long id){
        return cursoRepository.findById(id)
                .map(curso -> {
                    curso.setNombre(newCurso.getNombre());
                    curso.setRequisito(newCurso.getRequisito());
                    curso.setCreditos(newCurso.getCreditos());
                    curso.setCupos(newCurso.getCupos());
                    return cursoRepository.save(curso);
                }).orElseThrow(()-> new CursoNotFoundException(id));
    }

    @DeleteMapping("curso/{id}")
    String deleteCurso(@PathVariable Long id){
        if(!cursoRepository.existsById(id)){
            throw new CursoNotFoundException(id);
        }
        cursoRepository.deleteById(id);
        return "Se elimino correctamente el usuario con el id: "+id;
    }

}
