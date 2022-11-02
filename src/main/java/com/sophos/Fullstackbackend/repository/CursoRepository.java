package com.sophos.Fullstackbackend.repository;

import com.sophos.Fullstackbackend.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoRepository extends JpaRepository <Curso, Long> {

}
