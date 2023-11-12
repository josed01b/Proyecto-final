package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.EstudianteMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infraestructura.controller.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infraestructura.controller.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ActualizacionEstudianteService {

    private final EstudianteRepository estudianteRepository;
    private final EstudianteMapper estudianteMapper;

    public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {
        Optional<EstudianteEntity> estudianteEntity = estudianteRepository.findById(id);
        EstudianteEntity entity = estudianteEntity.get();
        entity.setId(estudiante.getId());
        entity.setNombre(estudiante.getNombre());
        entity.setApellido(estudiante.getApellido());
        entity.setEdad(estudiante.getEdad());
        return estudianteMapper.mapToDomain(entity);
    }
}
