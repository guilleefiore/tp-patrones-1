package com.biblioteca.app;

import com.biblioteca.builder.Usuario;
import com.biblioteca.prototype.Prestamo;
import com.biblioteca.singleton.DatabaseEnum;
import com.biblioteca.factory.*;
import com.biblioteca.abstractfactory.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("******* PRUEBA PATRÓN SINGLETON *******\n");

        // db1 y db2 apuntan al mismo objeto en memoria
        DatabaseEnum db1 = DatabaseEnum.INSTANCE;
        DatabaseEnum db2 = DatabaseEnum.INSTANCE;

        // Agrego libros
        db1.agregarLibro("Clean Code");
        db2.agregarLibro("El Principito");

        System.out.println("¿Es la misma instancia? " + (db1 == db2)); // True
        System.out.println("Libros: " + db1.listarLibros());
        System.out.println("Libros: " + db2.listarLibros());

        System.out.println("\n******* PRUEBA PATRÓN FACTORY METHOD *******\n");

        LogisticaLibro logisticaLibro = new LogisticaLibro();

        Libro libro1 = logisticaLibro.crearLibro("físico");
        Libro libro2 = logisticaLibro.crearLibro("digital");

        System.out.println("Libro 1: " + libro1.descripcion());
        System.out.println("Libro 2: " + libro2.descripcion());

        System.out.println("\n******* PRUEBA PATRÓN ABSTRACT FACTORY *******\n");

        // Elegir fábrica según el tipo de usuario
        UIFactory adminFactory = new AdminFactory();
        UIFactory userFactory = new UsuarioFactory();

        // Administrador
        System.out.println(adminFactory.crearUI().render());
        System.out.println(adminFactory.crearEnvio().enviar());

        // Usuario normal
        System.out.println(userFactory.crearUI().render());
        System.out.println(userFactory.crearEnvio().enviar());

        System.out.println("\n******* PRUEBA PATRÓN BUILDER *******\n");

        // Usuario con campos mínimos (nombre requerido)
        Usuario u1 = Usuario.builder()
                .nombre("Guillermina")
                .email("guille@ejemplo.com")
                .edad(22)
                .build();

        // Usuario con campos opcionales diferentes
        Usuario u2 = Usuario.builder()
                .nombre("Franco")
                .direccion("Av. Siempre Viva 123")
                .rol("LECTOR")
                .build();

        // Clonar/modificar con toBuilder()
        Usuario u3 = u1.toBuilder()
                .rol("ADMIN")
                .build();

        // Copiar con cambio puntual usando @With
        Usuario u4 = u3.withRol("SUPERVISOR");

        System.out.println(u1);
        System.out.println(u2);
        System.out.println(u3);
        System.out.println(u4);

        System.out.println("\n******* PRUEBA PATRÓN PROTOTYPE *******\n");

        Prestamo base = new Prestamo("El Principito", "Guillermina", LocalDate.now(), LocalDate.now().plusDays(7));

        // Clono el préstamo y cambio algunos datos
        Prestamo copia1 = base.clone();
        copia1.setUsuario("Francisco");

        Prestamo copia2 = base.clone();
        copia2.setUsuario("Elena");
        copia2.setFechaFin(LocalDate.now().plusDays(14)); // .plusDays(): devuelve nueva fecha sumandole 14 días

        System.out.println("Original: " + base);
        System.out.println("Copia1: " + copia1);
        System.out.println("Copia2: " + copia2);
    }
}