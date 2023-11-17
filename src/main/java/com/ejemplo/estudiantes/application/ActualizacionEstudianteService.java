package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.EstudianteMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infraestructura.controller.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infraestructura.controller.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ActualizacionEstudianteService {

    private final EstudianteMapper estudianteMapper;
    private final VerEstudianteService verEstudianteService;
    private final EstudianteRepository estudianteRepository;

    public Estudiante actualizarEstudiante(long id, Estudiante estudiante ) {

        Estudiante estudianteAnterior = verEstudianteService.consultarEstudiante(id);
        EstudianteEntity estudianteEntity = estudianteMapper.mapToEntity(estudianteAnterior);

        estudianteEntity.setNombre(estudiante.getNombre());
        estudianteEntity.setApellido(estudiante.getApellido());
        estudianteEntity.setEdad(estudiante.getEdad());

        EstudianteEntity estudianteNuevo = estudianteRepository.save(estudianteEntity);

        return estudianteMapper.mapToDomain(estudianteNuevo);
    }
}
