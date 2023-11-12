package com.ejemplo.estudiantes.application.mapper;

import com.ejemplo.estudiantes.domain.Estudiante;
import com.ejemplo.estudiantes.infraestructura.controller.repository.model.EstudianteEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EstudianteMapper {

    EstudianteEntity mapToEntity(Estudiante estudiante);

    Estudiante mapToDomain(EstudianteEntity estudianteEntity);
//    @Mapping(target = "id", ignore = true)
//    void ActualizacionEstudiante(Estudiante estudiante, @MappingTarget EstudianteEntity estudianteEntity);
}
