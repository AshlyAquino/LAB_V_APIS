
package com.lab.spring_apis_lab.Controller;

import com.lab.spring_apis_lab.Model.Libro;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private List<Libro> libros = new ArrayList<>();

    public LibroController() {

        libros.add(new Libro(
                1,
                "Cien años de soledad",
                "Gabriel García Márquez",
                "Realismo mágico",
                150.00
        ));

        libros.add(new Libro(
                2,
                "Don Quijote de la Mancha",
                "Miguel de Cervantes",
                "Novela",
                200.00
        ));

        libros.add(new Libro(
                3,
                "El principito",
                "Antoine de Saint-Exupéry",
                "Fantasía",
                100.00
        ));

        libros.add(new Libro(
                4,
                "Harry Potter y la piedra filosofal",
                "J. K. Rowling",
                "Fantasía",
                175.00
        ));

        libros.add(new Libro(
                5,
                "Orgullo y prejuicio",
                "Jane Austen",
                "Romance",
                125.00
        ));
    }

    @GetMapping
    public List<Libro> obtenerLibros() {
        return libros;
    }

    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable int id) {

        for (Libro libro : libros) {

            if (libro.getId() == id) {
                return libro;
            }
        }

        return null;
    }

    @PostMapping
    public Libro agregarLibro(@RequestBody Libro libro) {

        libros.add(libro);

        return libro;
    }

    @PutMapping("/{id}")
    public Libro actualizarLibro(
            @PathVariable int id,
            @RequestBody Libro libroActualizado) {

        for (int i = 0; i < libros.size(); i++) {

            if (libros.get(i).getId() == id) {

                libroActualizado.setId(id);

                libros.set(i, libroActualizado);

                return libroActualizado;
            }
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Libro actualizarParcialmente(
            @PathVariable int id,
            @RequestBody Libro datos) {

        for (Libro libro : libros) {

            if (libro.getId() == id) {

                if (datos.getTitulo() != null) {
                    libro.setTitulo(datos.getTitulo());
                }

                if (datos.getAutor() != null) {
                    libro.setAutor(datos.getAutor());
                }

                if (datos.getGenero() != null) {
                    libro.setGenero(datos.getGenero());
                }

                if (datos.getPrecio() != 0) {
                    libro.setPrecio(datos.getPrecio());
                }

                return libro;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Libro eliminarLibro(@PathVariable int id) {

        for (Libro libro : libros) {

            if (libro.getId() == id) {

                libros.remove(libro);

                return libro;
            }
        }

        return null;
    }
}

