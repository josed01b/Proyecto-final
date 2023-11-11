package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infraestructura.controller.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EliminacionEstudianteService {

    private final EstudianteRepository estudianteRepository;

    public  void eliminarEstudiante(Long estudianteId) {
        estudianteRepository.deleteById(estudianteId);
    }
}
