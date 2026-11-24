package domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestorValoraciones {

    // Guarda el título de la película y su lista de notas (de 1 a 5 estrellas)
    private Map<String, List<Integer>> notasPorPelicula;

    public GestorValoraciones() {
        this.notasPorPelicula = new HashMap<>();
    }

    public boolean agregarValoracion(String tituloPelicula, int puntuacion) {
        if (puntuacion < 1 || puntuacion > 5 || tituloPelicula == null) {
            return false;
        }

        notasPorPelicula.putIfAbsent(tituloPelicula, new ArrayList<>());
        notasPorPelicula.get(tituloPelicula).add(puntuacion);
        return true;
    }

    public double obtenerPuntuacionMedia(String tituloPelicula) {
        List<Integer> notas = notasPorPelicula.get(tituloPelicula);
        if (notas == null || notas.isEmpty()) {
            return 0.0;
        }

        double suma = 0.0;
        for (int nota : notas) {
            suma += nota;
        }
        return suma / notas.size();
    }

    public int obtenerTotalVotos(String tituloPelicula) {
        List<Integer> notas = notasPorPelicula.get(tituloPelicula);
        return (notas != null) ? notas.size() : 0;
    }
}