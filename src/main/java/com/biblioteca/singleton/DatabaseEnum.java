package com.biblioteca.singleton;

import java.util.ArrayList;
import java.util.List;

public enum DatabaseEnum {
    INSTANCE; // ÚNICA instancia garantizada por Java

    private final List<String> libros = new ArrayList<>();

    // API mínima
    public void agregarLibro(String titulo) {
        libros.add(titulo);
    }

    public List<String> listarLibros() {
        // Copia inmutable = no podés agregar, borrar ni modificar elementos en esa lista
        return List.copyOf(libros); // Me evita por ejemplo borrar toda la BD
    }
}