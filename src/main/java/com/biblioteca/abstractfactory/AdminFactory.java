package com.biblioteca.abstractfactory;

public class AdminFactory implements UIFactory {
    @Override
    public InterfazUI crearUI() {
        return new AdminUI();
    }

    @Override
    public MetodoEnvio crearEnvio() {
        return new EnvioExpress();
    }
}