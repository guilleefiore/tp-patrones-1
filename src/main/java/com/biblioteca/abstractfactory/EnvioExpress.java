package com.biblioteca.abstractfactory;

public class EnvioExpress implements MetodoEnvio {
    @Override
    public String enviar() {
        return "Envio Express";
    }
}