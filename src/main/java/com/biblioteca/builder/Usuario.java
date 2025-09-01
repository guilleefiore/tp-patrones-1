package com.biblioteca.builder;

import lombok.Builder;
import lombok.Value;
import lombok.With;

@Value // Clase inmutable: solo getters, sin setters
@Builder(toBuilder = true) // Gnera Usuario.builder() y toBuilder() para clonar/modificar

public class Usuario {
    String nombre;
    String email;
    Integer edad;
    String direccion;
    @With String rol;    // Opcional; @With genera un "copiar-con-rol"

    // Validación de negocio dentro del builder
    public static class UsuarioBuilder {
        public Usuario build() {
            if (nombre == null || nombre.isBlank()) {
                throw new IllegalStateException("El nombre es obligatorio");
            }
            if (edad != null && (edad < 0 || edad > 120)) {
                throw new IllegalStateException("Edad fuera de rango (0–120)");
            }
            return new Usuario(nombre, email, edad, direccion, rol);
        }
    }
}