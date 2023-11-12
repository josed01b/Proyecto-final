package com.ejemplo.estudiantes.infraestructura.controller;

import com.ejemplo.estudiantes.application.ActualizacionEstudianteService;
import com.ejemplo.estudiantes.domain.Estudiante;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RequestMapping("estudiantes")
@RestController
@RequiredArgsConstructor
@Slf4j
public class ActualizacionEstudianteController {

    private final ActualizacionEstudianteService actualizacionEstudianteService;

    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudiante) {
        log.info("Se esta actualizando un estudiante");
        return actualizacionEstudianteService.actualizarEstudiante(id, estudiante);
    }

}
