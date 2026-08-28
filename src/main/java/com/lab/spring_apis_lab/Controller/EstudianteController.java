package com.lab.spring_apis_lab.Controller;

import com.lab.spring_apis_lab.Model.Estudiante;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/estudiantes")
public class EstudianteController {

    private List<Estudiante> estudiantes = new ArrayList<>();

    public EstudianteController() {

        estudiantes.add(new Estudiante(
                1,
                "Ashly",
                "Aquino",
                "Ingeniería en Sistemas",
                20
        ));

        estudiantes.add(new Estudiante(
                2,
                "Carlos",
                "López",
                "Ingeniería en Sistemas",
                21
        ));

        estudiantes.add(new Estudiante(
                3,
                "María",
                "Gómez",
                "Administración de Empresas",
                22
        ));

        estudiantes.add(new Estudiante(
                4,
                "José",
                "Ramírez",
                "Ingeniería Industrial",
                20
        ));

        estudiantes.add(new Estudiante(
                5,
                "Andrea",
                "Pérez",
                "Ingeniería en Sistemas",
                23
        ));
    }

    // GET - Obtener todos los estudiantes
    @GetMapping
    public List<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }

    // GET - Obtener estudiante por ID
    @GetMapping("/{id}")
    public Estudiante obtenerEstudiantePorId(@PathVariable int id) {

        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getId() == id) {
                return estudiante;
            }
        }

        return null;
    }

    // POST - Agregar un estudiante
    @PostMapping
    public Estudiante agregarEstudiante(@RequestBody Estudiante estudiante) {

        estudiantes.add(estudiante);

        return estudiante;
    }

    // PUT - Actualizar un estudiante completo
    @PutMapping("/{id}")
    public Estudiante actualizarEstudiante(
            @PathVariable int id,
            @RequestBody Estudiante estudianteActualizado) {

        for (int i = 0; i < estudiantes.size(); i++) {

            if (estudiantes.get(i).getId() == id) {

                estudianteActualizado.setId(id);

                estudiantes.set(i, estudianteActualizado);

                return estudianteActualizado;
            }
        }

        return null;
    }

    // PATCH - Actualizar parcialmente un estudiante
    @PatchMapping("/{id}")
    public Estudiante actualizarParcialmente(
            @PathVariable int id,
            @RequestBody Estudiante datos) {

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getId() == id) {

                if (datos.getNombre() != null) {
                    estudiante.setNombre(datos.getNombre());
                }

                if (datos.getApellido() != null) {
                    estudiante.setApellido(datos.getApellido());
                }

                if (datos.getCarrera() != null) {
                    estudiante.setCarrera(datos.getCarrera());
                }

                if (datos.getEdad() != 0) {
                    estudiante.setEdad(datos.getEdad());
                }

                return estudiante;
            }
        }

        return null;
    }

    // DELETE - Eliminar un estudiante
    @DeleteMapping("/{id}")
    public Estudiante eliminarEstudiante(@PathVariable int id) {

        for (Estudiante estudiante : estudiantes) {

            if (estudiante.getId() == id) {

                estudiantes.remove(estudiante);

                return estudiante;
            }
        }

        return null;
    }
}