package com.biblioteca.factory;

public class LogisticaLibro {
    public Libro crearLibro(String tipo) { // Factory Method
        return switch (tipo.toLowerCase()) {
            // Encapsulo la creación de objetos en el método
            case "físico" -> new LibroFisico();
            case "digital" -> new LibroDigital();
            default -> throw new IllegalArgumentException("Tipo de libro no soportado" + tipo);
        }; // Termina con ; porque es una expresión
    }
}