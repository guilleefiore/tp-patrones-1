package com.biblioteca.factory;

public class LibroFisico implements Libro {
    @Override
    public String descripcion() {
        return "Libro Fisico";
    }
}