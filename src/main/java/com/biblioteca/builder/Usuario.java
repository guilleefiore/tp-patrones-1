package com.biblioteca.builder;

import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

@Value // Clase inmutable: solo getters, sin setters
@Builder(toBuilder = true) // Gnera Usuario.builder() y toBuilder() para clonar/modificar

public class Usuario {
    @NonNull
    String nombre;
    @NonNull
    String email;

    Integer edad;
    String direccion;
    String rol;
}