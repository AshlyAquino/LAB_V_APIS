
package com.lab.spring_apis_lab.Controller;

import com.lab.spring_apis_lab.Model.Cliente;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private List<Cliente> clientes = new ArrayList<>();

    public ClienteController() {

        clientes.add(new Cliente(
                1,
                "Ashly",
                "Aquino",
                "ashly@gmail.com",
                "55555555"
        ));

        clientes.add(new Cliente(
                2,
                "Carlos",
                "López",
                "carlos@gmail.com",
                "55555556"
        ));

        clientes.add(new Cliente(
                3,
                "María",
                "Gómez",
                "maria@gmail.com",
                "55555557"
        ));

        clientes.add(new Cliente(
                4,
                "José",
                "Ramírez",
                "jose@gmail.com",
                "55555558"
        ));

        clientes.add(new Cliente(
                5,
                "Andrea",
                "Pérez",
                "andrea@gmail.com",
                "55555559"
        ));
    }

    @GetMapping
    public List<Cliente> obtenerClientes() {
        return clientes;
    }

    @GetMapping("/{id}")
    public Cliente obtenerClientePorId(@PathVariable int id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {
                return cliente;
            }
        }

        return null;
    }

    @PostMapping
    public Cliente agregarCliente(@RequestBody Cliente cliente) {

        clientes.add(cliente);

        return cliente;
    }

    @PutMapping("/{id}")
    public Cliente actualizarCliente(
            @PathVariable int id,
            @RequestBody Cliente clienteActualizado) {

        for (int i = 0; i < clientes.size(); i++) {

            if (clientes.get(i).getId() == id) {

                clienteActualizado.setId(id);

                clientes.set(i, clienteActualizado);

                return clienteActualizado;
            }
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Cliente actualizarParcialmente(
            @PathVariable int id,
            @RequestBody Cliente datos) {

        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {

                if (datos.getNombre() != null) {
                    cliente.setNombre(datos.getNombre());
                }

                if (datos.getApellido() != null) {
                    cliente.setApellido(datos.getApellido());
                }

                if (datos.getCorreo() != null) {
                    cliente.setCorreo(datos.getCorreo());
                }

                if (datos.getTelefono() != null) {
                    cliente.setTelefono(datos.getTelefono());
                }

                return cliente;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Cliente eliminarCliente(@PathVariable int id) {

        for (Cliente cliente : clientes) {

            if (cliente.getId() == id) {

                clientes.remove(cliente);

                return cliente;
            }
        }

        return null;
    }
}

