
package com.lab.spring_apis_lab.Controller;

import com.lab.spring_apis_lab.Model.Empleado;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {

    private List<Empleado> empleados = new ArrayList<>();

    public EmpleadoController() {

        empleados.add(new Empleado(
                1,
                "Carlos López",
                "Programador",
                6500.00,
                "Tecnología"
        ));

        empleados.add(new Empleado(
                2,
                "María Gómez",
                "Analista",
                6000.00,
                "Tecnología"
        ));

        empleados.add(new Empleado(
                3,
                "José Ramírez",
                "Gerente",
                9000.00,
                "Administración"
        ));

        empleados.add(new Empleado(
                4,
                "Andrea Pérez",
                "Contadora",
                7000.00,
                "Finanzas"
        ));

        empleados.add(new Empleado(
                5,
                "Luis Martínez",
                "Recursos Humanos",
                5500.00,
                "Recursos Humanos"
        ));
    }

    @GetMapping
    public List<Empleado> obtenerEmpleados() {
        return empleados;
    }

    @GetMapping("/{id}")
    public Empleado obtenerEmpleadoPorId(@PathVariable int id) {

        for (Empleado empleado : empleados) {

            if (empleado.getId() == id) {
                return empleado;
            }
        }

        return null;
    }

    @PostMapping
    public Empleado agregarEmpleado(@RequestBody Empleado empleado) {

        empleados.add(empleado);

        return empleado;
    }

    @PutMapping("/{id}")
    public Empleado actualizarEmpleado(
            @PathVariable int id,
            @RequestBody Empleado empleadoActualizado) {

        for (int i = 0; i < empleados.size(); i++) {

            if (empleados.get(i).getId() == id) {

                empleadoActualizado.setId(id);

                empleados.set(i, empleadoActualizado);

                return empleadoActualizado;
            }
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Empleado actualizarParcialmente(
            @PathVariable int id,
            @RequestBody Empleado datos) {

        for (Empleado empleado : empleados) {

            if (empleado.getId() == id) {

                if (datos.getNombre() != null) {
                    empleado.setNombre(datos.getNombre());
                }

                if (datos.getPuesto() != null) {
                    empleado.setPuesto(datos.getPuesto());
                }

                if (datos.getSalario() != 0) {
                    empleado.setSalario(datos.getSalario());
                }

                if (datos.getDepartamento() != null) {
                    empleado.setDepartamento(datos.getDepartamento());
                }

                return empleado;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Empleado eliminarEmpleado(@PathVariable int id) {

        for (Empleado empleado : empleados) {

            if (empleado.getId() == id) {

                empleados.remove(empleado);

                return empleado;
            }
        }

        return null;
    }
}

