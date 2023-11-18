package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.exception.ResourceNotFoundException;
import com.ejemplo.estudiantes.infraestructura.controller.repository.EstudianteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class VerEstudianteService {

    private final EstudianteRepository estudianteRepository;
    public List<Estudiante> obtenerEstudiantes() {
        return estudianteRepository.findAll().stream()
                .map(estudianteEntity ->
                        Estudiante.builder()
                                .id(estudianteEntity.getId())
                                .nombre(estudianteEntity.getNombre())
                                .apellido(estudianteEntity.getApellido())
                                .edad(estudianteEntity.getEdad())
                                .build())
                .collect(Collectors.toList());
    }

    public Estudiante consultarEstudiante(Long id ) {
        return (Estudiante) estudianteRepository.findById(id)
                .map(estudianteEntity -> Estudiante.builder()
                        .id(estudianteEntity.getId())
                        .nombre(estudianteEntity.getNombre())
                        .apellido(estudianteEntity.getApellido())
                        .edad(estudianteEntity.getEdad())
                        .build())
                .orElseThrow(() -> new ResourceNotFoundException(String.format("Estudiante %d no encontrado", id)));
    }
}
