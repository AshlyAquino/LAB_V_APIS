
package com.lab.spring_apis_lab.Controller;

import com.lab.spring_apis_lab.Model.Pedido;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidoController {

    private List<Pedido> pedidos = new ArrayList<>();

    public PedidoController() {

        pedidos.add(new Pedido(
                1,
                "Ashly Aquino",
                "Laptop Lenovo",
                1,
                5500.00,
                "PENDIENTE"
        ));

        pedidos.add(new Pedido(
                2,
                "Carlos López",
                "Mouse Logitech",
                2,
                500.00,
                "ENVIADO"
        ));

        pedidos.add(new Pedido(
                3,
                "María Gómez",
                "Teclado Mecánico",
                1,
                450.00,
                "ENTREGADO"
        ));

        pedidos.add(new Pedido(
                4,
                "José Ramírez",
                "Monitor Samsung",
                2,
                3600.00,
                "PENDIENTE"
        ));

        pedidos.add(new Pedido(
                5,
                "Andrea Pérez",
                "Audífonos Sony",
                3,
                2250.00,
                "ENVIADO"
        ));
    }

    @GetMapping
    public List<Pedido> obtenerPedidos() {
        return pedidos;
    }

    @GetMapping("/{id}")
    public Pedido obtenerPedidoPorId(@PathVariable int id) {

        for (Pedido pedido : pedidos) {

            if (pedido.getId() == id) {
                return pedido;
            }
        }

        return null;
    }

    @PostMapping
    public Pedido agregarPedido(@RequestBody Pedido pedido) {

        pedidos.add(pedido);

        return pedido;
    }

    @PutMapping("/{id}")
    public Pedido actualizarPedido(
            @PathVariable int id,
            @RequestBody Pedido pedidoActualizado) {

        for (int i = 0; i < pedidos.size(); i++) {

            if (pedidos.get(i).getId() == id) {

                pedidoActualizado.setId(id);

                pedidos.set(i, pedidoActualizado);

                return pedidoActualizado;
            }
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Pedido actualizarParcialmente(
            @PathVariable int id,
            @RequestBody Pedido datos) {

        for (Pedido pedido : pedidos) {

            if (pedido.getId() == id) {

                if (datos.getCliente() != null) {
                    pedido.setCliente(datos.getCliente());
                }

                if (datos.getProducto() != null) {
                    pedido.setProducto(datos.getProducto());
                }

                if (datos.getCantidad() != 0) {
                    pedido.setCantidad(datos.getCantidad());
                }

                if (datos.getTotal() != 0) {
                    pedido.setTotal(datos.getTotal());
                }

                if (datos.getEstado() != null) {
                    pedido.setEstado(datos.getEstado());
                }

                return pedido;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Pedido eliminarPedido(@PathVariable int id) {

        for (Pedido pedido : pedidos) {

            if (pedido.getId() == id) {

                pedidos.remove(pedido);

                return pedido;
            }
        }

        return null;
    }
}

