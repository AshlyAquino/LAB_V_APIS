
package com.lab.spring_apis_lab.Controller;

import com.lab.spring_apis_lab.Model.Tarea;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/tareas")
public class TareaController {

    private List<Tarea> tareas = new ArrayList<>();

    public TareaController() {

        tareas.add(new Tarea(
                1,
                "Estudiar Java",
                "Repasar programación orientada a objetos",
                "Alta",
                false
        ));

        tareas.add(new Tarea(
                2,
                "Hacer tarea de Cálculo",
                "Resolver ejercicios de integrales",
                "Alta",
                false
        ));

        tareas.add(new Tarea(
                3,
                "Crear API",
                "Completar los endpoints del laboratorio",
                "Media",
                true
        ));

        tareas.add(new Tarea(
                4,
                "Estudiar para examen",
                "Repasar los temas vistos en clase",
                "Alta",
                false
        ));

        tareas.add(new Tarea(
                5,
                "Entregar laboratorio",
                "Subir el proyecto a GitHub",
                "Media",
                false
        ));
    }

    @GetMapping
    public List<Tarea> obtenerTareas() {
        return tareas;
    }

    @GetMapping("/{id}")
    public Tarea obtenerTareaPorId(@PathVariable int id) {

        for (Tarea tarea : tareas) {

            if (tarea.getId() == id) {
                return tarea;
            }
        }

        return null;
    }

    @PostMapping
    public Tarea agregarTarea(@RequestBody Tarea tarea) {

        tareas.add(tarea);

        return tarea;
    }

    @PutMapping("/{id}")
    public Tarea actualizarTarea(
            @PathVariable int id,
            @RequestBody Tarea tareaActualizada) {

        for (int i = 0; i < tareas.size(); i++) {

            if (tareas.get(i).getId() == id) {

                tareaActualizada.setId(id);

                tareas.set(i, tareaActualizada);

                return tareaActualizada;
            }
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Tarea actualizarParcialmente(
            @PathVariable int id,
            @RequestBody Tarea datos) {

        for (Tarea tarea : tareas) {

            if (tarea.getId() == id) {

                if (datos.getTitulo() != null) {
                    tarea.setTitulo(datos.getTitulo());
                }

                if (datos.getDescripcion() != null) {
                    tarea.setDescripcion(datos.getDescripcion());
                }

                if (datos.getPrioridad() != null) {
                    tarea.setPrioridad(datos.getPrioridad());
                }

                tarea.setCompletada(datos.isCompletada());

                return tarea;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Tarea eliminarTarea(@PathVariable int id) {

        for (Tarea tarea : tareas) {

            if (tarea.getId() == id) {

                tareas.remove(tarea);

                return tarea;
            }
        }

        return null;
    }
}