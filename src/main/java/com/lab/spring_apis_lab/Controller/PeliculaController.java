
package com.lab.spring_apis_lab.Controller;

import com.lab.spring_apis_lab.Model.Pelicula;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private List<Pelicula> peliculas = new ArrayList<>();

    public PeliculaController() {

        peliculas.add(new Pelicula(
                1,
                "Titanic",
                "James Cameron",
                "Romance",
                1997
        ));

        peliculas.add(new Pelicula(
                2,
                "Avatar",
                "James Cameron",
                "Ciencia ficción",
                2009
        ));

        peliculas.add(new Pelicula(
                3,
                "El Rey León",
                "Rob Minkoff",
                "Animación",
                1994
        ));

        peliculas.add(new Pelicula(
                4,
                "Jurassic Park",
                "Steven Spielberg",
                "Ciencia ficción",
                1993
        ));

        peliculas.add(new Pelicula(
                5,
                "Harry Potter y la piedra filosofal",
                "Chris Columbus",
                "Fantasía",
                2001
        ));
    }

    @GetMapping
    public List<Pelicula> obtenerPeliculas() {
        return peliculas;
    }

    @GetMapping("/{id}")
    public Pelicula obtenerPeliculaPorId(@PathVariable int id) {

        for (Pelicula pelicula : peliculas) {

            if (pelicula.getId() == id) {
                return pelicula;
            }
        }

        return null;
    }

    @PostMapping
    public Pelicula agregarPelicula(@RequestBody Pelicula pelicula) {

        peliculas.add(pelicula);

        return pelicula;
    }

    @PutMapping("/{id}")
    public Pelicula actualizarPelicula(
            @PathVariable int id,
            @RequestBody Pelicula peliculaActualizada) {

        for (int i = 0; i < peliculas.size(); i++) {

            if (peliculas.get(i).getId() == id) {

                peliculaActualizada.setId(id);

                peliculas.set(i, peliculaActualizada);

                return peliculaActualizada;
            }
        }

        return null;
    }

    @PatchMapping("/{id}")
    public Pelicula actualizarParcialmente(
            @PathVariable int id,
            @RequestBody Pelicula datos) {

        for (Pelicula pelicula : peliculas) {

            if (pelicula.getId() == id) {

                if (datos.getTitulo() != null) {
                    pelicula.setTitulo(datos.getTitulo());
                }

                if (datos.getDirector() != null) {
                    pelicula.setDirector(datos.getDirector());
                }

                if (datos.getGenero() != null) {
                    pelicula.setGenero(datos.getGenero());
                }

                if (datos.getAnio() != 0) {
                    pelicula.setAnio(datos.getAnio());
                }

                return pelicula;
            }
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Pelicula eliminarPelicula(@PathVariable int id) {

        for (Pelicula pelicula : peliculas) {

            if (pelicula.getId() == id) {

                peliculas.remove(pelicula);

                return pelicula;
            }
        }

        return null;
    }
}

