package com.biblioteca.abstractfactory;

public class EnvioNormal implements MetodoEnvio {
    @Override
    public String enviar() {
        return "Envío Normal";
    }
}