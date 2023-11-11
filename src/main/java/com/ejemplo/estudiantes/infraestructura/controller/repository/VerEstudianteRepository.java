package com.ejemplo.estudiantes.infraestructura.controller.repository;


import com.ejemplo.estudiantes.infraestructura.controller.repository.model.EstudianteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VerEstudianteRepository extends JpaRepository<EstudianteEntity, Long> {
}
