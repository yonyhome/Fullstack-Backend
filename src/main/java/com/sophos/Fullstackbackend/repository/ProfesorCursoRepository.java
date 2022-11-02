package com.sophos.Fullstackbackend.repository;

import com.sophos.Fullstackbackend.model.Profesor;
import com.sophos.Fullstackbackend.model.ProfesorCurso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfesorCursoRepository extends JpaRepository<ProfesorCurso, Long> {
    List<ProfesorCurso> findByIdcurso(Long idcurso);
}
