package com.biblioteca.singleton;

import java.util.ArrayList;
import java.util.List;

// Clase que almacena libros
public enum DatabaseEnum {
    INSTANCE; // ÚNICA instancia garantizada por la clase ENUM

    private final List<String> libros = new ArrayList<>(); // Guardo la lista de libros

    // Métodos públicos
    public void agregarLibro(String titulo) {
        libros.add(titulo);
    }

    public List<String> listarLibros() {
        // Copia inmutable = no podés agregar, borrar ni modificar elementos en esa lista
        return List.copyOf(libros); // Me evita por ejemplo borrar toda la BD
    }
}