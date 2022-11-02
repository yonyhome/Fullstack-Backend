package com.sophos.Fullstackbackend.controller;
import com.sophos.Fullstackbackend.model.Alumno;
import com.sophos.Fullstackbackend.repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.sophos.Fullstackbackend.exception.AlumnoNotFoundException;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class AlumnoController {
    @Autowired
    private AlumnoRepository alumnoRepository;

    @PostMapping("/alumno")
    public Alumno newAlumno(@RequestBody Alumno newAlumno){
        return alumnoRepository.save(newAlumno);
    }

    @GetMapping("/alumnos")
    public List<Alumno> FindAllAlumno(){
        return alumnoRepository.findAll();
    }


    @GetMapping("/alumno/{id}")
    Alumno getAlumnoById(@PathVariable Long id){
        return alumnoRepository.findById(id)
                .orElseThrow( ()-> new AlumnoNotFoundException(id));
    }

    @PutMapping("alumno/{id}")
    Alumno updateAlumno(@RequestBody Alumno newAlumni, @PathVariable Long id){
        return alumnoRepository.findById(id)
                .map(alumno -> {
                    alumno.setNombre(newAlumni.getNombre());
                    alumno.setCursos(newAlumni.getCursos());
                    alumno.setFacultad(newAlumni.getFacultad());
                    alumno.setSemestre(newAlumni.getSemestre());

                    return alumnoRepository.save(alumno);
                }).orElseThrow(()-> new AlumnoNotFoundException(id));
    }

    @DeleteMapping("alumno/{id}")
    String deleteAlumno(@PathVariable Long id){
        if(!alumnoRepository.existsById(id)){
            throw new AlumnoNotFoundException(id);
        }
        alumnoRepository.deleteById(id);
        return "Se elimino correctamente el Alumno con el id: "+id;
    }
}
