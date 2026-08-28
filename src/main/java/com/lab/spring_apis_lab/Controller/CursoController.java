
package com.lab.spring_apis_lab.Controller;

import com.lab.spring_apis_lab.Model.Curso;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    private List<Curso> cursos = new ArrayList<>();

    public CursoController() {

        cursos.add(new Curso(
                1,
                "Programación",
                "Introducción a la programación y desarrollo de algoritmos",
                4,
                "Presencial"
        ));

        cursos.add(new Curso(
                2,
                "Bases de Datos",
                "Fundamentos de bases de datos y lenguaje SQL",
                4,
                "Virtual"
        ));

        cursos.add(new Curso(
                3,
                "Cálculo II",
                "Estudio de integrales y técnicas de integración",
                5,
                "Presencial"
        ));

        cursos.add(new Curso(
                4,
                "Redes de Computadoras",
                "Fundamentos de redes, protocolos y configuraciones IP",
                3,
                "Híbrida"
        ));

        cursos.add(new Curso(
                5,
                "Ingeniería de Software",
                "Principios y metodologías para el desarrollo de software",
                4,
                "Virtual"
        ));
    }

    @GetMapping
    public List<Curso> obtenerCursos() {
        return cursos;
    }

    @GetMapping("/{id}")
    public Curso obtenerCursoPorId(@PathVariable int id) {

        for (Curso curso : cursos) {

            if (curso.getId() == id) {
                return curso;
            }
        }

        return null;
    }

    @PostMapping
    public Curso agregarCurso(@RequestBody Curso curso) {

        cursos.add(curso);

        return curso;
    }

    @PutMapping("/{id}")
    public Curso actualizarCurso(
            @PathVariable int id,
            @RequestBody Curso cursoActualizado) {

        for (int i = 0; i < cursos.size(); i++) {

            if (cursos.get(i).getId() == id) {

                cursoActualizado.setId(id);

                cursos.set(i, cursoActualizado);

                return cursoActualizado;
            }
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Curso actualizarParcialmente(
            @PathVariable int id,
            @RequestBody Curso datos) {

        for (Curso curso : cursos) {

            if (curso.getId() == id) {

                if (datos.getNombre() != null) {
                    curso.setNombre(datos.getNombre());
                }

                if (datos.getDescripcion() != null) {
                    curso.setDescripcion(datos.getDescripcion());
                }

                if (datos.getCreditos() != 0) {
                    curso.setCreditos(datos.getCreditos());
                }

                if (datos.getModalidad() != null) {
                    curso.setModalidad(datos.getModalidad());
                }

                return curso;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Curso eliminarCurso(@PathVariable int id) {

        for (Curso curso : cursos) {

            if (curso.getId() == id) {

                cursos.remove(curso);

                return curso;
            }
        }

        return null;
    }
}
