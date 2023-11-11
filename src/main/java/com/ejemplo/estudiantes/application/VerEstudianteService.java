package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infraestructura.controller.repository.VerEstudianteRepository;
import com.ejemplo.estudiantes.infraestructura.controller.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class VerEstudianteService {
    private final VerEstudianteRepository verEstudianteRepository;
    public List<Estudiante> obtenerEstudiantes() {
        return verEstudianteRepository.findAll().stream()
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
        Optional<EstudianteEntity> estudiante = verEstudianteRepository.findById(id);
        Estudiante esttudiante = new Estudiante(estudiante.get().getId(),estudiante.get().getNombre(),estudiante.get().getApellido(),estudiante.get().getEdad());
        return esttudiante;
    }
}
