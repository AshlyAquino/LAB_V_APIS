
package com.lab.spring_apis_lab.Controller;

import com.lab.spring_apis_lab.Model.Vehiculo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/vehiculos")
public class VehiculoController {

    private List<Vehiculo> vehiculos = new ArrayList<>();

    public VehiculoController() {

        vehiculos.add(new Vehiculo(
                1,
                "Toyota",
                "Corolla",
                2022,
                145000.00
        ));

        vehiculos.add(new Vehiculo(
                2,
                "Honda",
                "Civic",
                2023,
                165000.00
        ));

        vehiculos.add(new Vehiculo(
                3,
                "Mazda",
                "CX-5",
                2021,
                185000.00
        ));

        vehiculos.add(new Vehiculo(
                4,
                "Hyundai",
                "Tucson",
                2024,
                210000.00
        ));

        vehiculos.add(new Vehiculo(
                5,
                "Ford",
                "Ranger",
                2023,
                250000.00
        ));
    }

    @GetMapping
    public List<Vehiculo> obtenerVehiculos() {
        return vehiculos;
    }

    @GetMapping("/{id}")
    public Vehiculo obtenerVehiculoPorId(@PathVariable int id) {

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getId() == id) {
                return vehiculo;
            }
        }

        return null;
    }

    @PostMapping
    public Vehiculo agregarVehiculo(@RequestBody Vehiculo vehiculo) {

        vehiculos.add(vehiculo);

        return vehiculo;
    }

    @PutMapping("/{id}")
    public Vehiculo actualizarVehiculo(
            @PathVariable int id,
            @RequestBody Vehiculo vehiculoActualizado) {

        for (int i = 0; i < vehiculos.size(); i++) {

            if (vehiculos.get(i).getId() == id) {

                vehiculoActualizado.setId(id);

                vehiculos.set(i, vehiculoActualizado);

                return vehiculoActualizado;
            }
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Vehiculo actualizarParcialmente(
            @PathVariable int id,
            @RequestBody Vehiculo datos) {

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getId() == id) {

                if (datos.getMarca() != null) {
                    vehiculo.setMarca(datos.getMarca());
                }

                if (datos.getModelo() != null) {
                    vehiculo.setModelo(datos.getModelo());
                }

                if (datos.getAnio() != 0) {
                    vehiculo.setAnio(datos.getAnio());
                }

                if (datos.getPrecio() != 0) {
                    vehiculo.setPrecio(datos.getPrecio());
                }

                return vehiculo;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Vehiculo eliminarVehiculo(@PathVariable int id) {

        for (Vehiculo vehiculo : vehiculos) {

            if (vehiculo.getId() == id) {

                vehiculos.remove(vehiculo);

                return vehiculo;
            }
        }

        return null;
    }
}
