package com.biblioteca.prototype;

import lombok.AllArgsConstructor; // Importa la anotación de Lombok que genera un constructor con todos los atributos
import lombok.Data; // Importa la anotación de Lombok que genera automáticamente getters, setters, toString, equals y hashCode
import java.time.LocalDate; // Importa la clase de Java para manejar fechas (sin horas)

@Data // Genera lo de: lombok.Data
@AllArgsConstructor // Me ahorra escribir todos los constructores

public class Prestamo {
    private String libro;
    private String usuario;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @Override
    public Prestamo clone() {
        // Shallow clone: copia referencias tal cual
        // Está bien porque String y LocalDate son inmutables
        return new Prestamo(libro, usuario, fechaInicio, fechaFin);
    }
}