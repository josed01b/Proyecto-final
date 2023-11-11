package com.ejemplo.estudiantes.application;

import com.ejemplo.estudiantes.application.mapper.EstudianteMapper;
import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infraestructura.controller.repository.EstudianteRepository;
import com.ejemplo.estudiantes.infraestructura.controller.repository.model.EstudianteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@RequiredArgsConstructor
public class CreacionEstudianteService {

    private final EstudianteRepository estudianteRepository;
    public Estudiante crearEstudiante(Estudiante estudiante) {
        EstudianteEntity entity = EstudianteMapper.INSTANCE.mapToEntity(estudiante);

                             //----metodo dos mas largo----//
//                EstudianteEntity entity = EstudianteEntity.builder()
//                         .nombre(estudiante.getNombre())
//                         .apellido(estudiante.getApellido())
//                         .edad(estudiante.getEdad())
//                         .build();
        EstudianteEntity estudianteResultante = estudianteRepository.save(entity);

        return EstudianteMapper.INSTANCE.mapToDomain(estudianteResultante);

                         //------return mas largo ------//
//                Estudiante.builder()
//                .id(estudianteResultante.getId())
//                .nombre(estudianteResultante.getNombre())
//                .apellido(estudianteResultante.getApellido())
//                .edad(estudianteResultante.getEdad())
//                .build();
    }
}
