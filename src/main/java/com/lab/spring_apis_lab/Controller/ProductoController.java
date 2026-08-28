
package com.lab.spring_apis_lab.Controller;

import com.lab.spring_apis_lab.Model.Producto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private List<Producto> productos = new ArrayList<>();

    public ProductoController() {

        productos.add(new Producto(
                1,
                "Laptop Lenovo",
                5500.00,
                "Tecnología"
        ));

        productos.add(new Producto(
                2,
                "Mouse Logitech",
                250.00,
                "Accesorios"
        ));

        productos.add(new Producto(
                3,
                "Teclado Mecánico",
                450.00,
                "Accesorios"
        ));

        productos.add(new Producto(
                4,
                "Monitor Samsung",
                1800.00,
                "Tecnología"
        ));

        productos.add(new Producto(
                5,
                "Audífonos Sony",
                750.00,
                "Audio"
        ));
    }

    // GET - Obtener todos los productos
    @GetMapping
    public List<Producto> obtenerProductos() {
        return productos;
    }

    // GET - Obtener producto por ID
    @GetMapping("/{id}")
    public Producto obtenerProductoPorId(@PathVariable int id) {

        for (Producto producto : productos) {
            if (producto.getId() == id) {
                return producto;
            }
        }

        return null;
    }

    // POST - Agregar un producto
    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {

        productos.add(producto);

        return producto;
    }

    // PUT - Actualizar un producto completo
    @PutMapping("/{id}")
    public Producto actualizarProducto(
            @PathVariable int id,
            @RequestBody Producto productoActualizado) {

        for (int i = 0; i < productos.size(); i++) {

            if (productos.get(i).getId() == id) {

                productoActualizado.setId(id);

                productos.set(i, productoActualizado);

                return productoActualizado;
            }
        }

        return null;
    }

    // PATCH - Actualizar parcialmente un producto
    @PatchMapping("/{id}")
    public Producto actualizarParcialmente(
            @PathVariable int id,
            @RequestBody Producto datos) {

        for (Producto producto : productos) {

            if (producto.getId() == id) {

                if (datos.getNombre() != null) {
                    producto.setNombre(datos.getNombre());
                }

                if (datos.getPrecio() != 0) {
                    producto.setPrecio(datos.getPrecio());
                }

                if (datos.getCategoria() != null) {
                    producto.setCategoria(datos.getCategoria());
                }

                return producto;
            }
        }

        return null;
    }

    // DELETE - Eliminar un producto
    @DeleteMapping("/{id}")
    public Producto eliminarProducto(@PathVariable int id) {

        for (Producto producto : productos) {

            if (producto.getId() == id) {

                productos.remove(producto);

                return producto;
            }
        }

        return null;
    }
}
