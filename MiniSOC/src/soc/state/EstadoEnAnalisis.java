package soc.state;

import soc.modelo.Alerta;

public class EstadoEnAnalisis implements EstadoAlerta {

    @Override
    public void siguiente(Alerta alerta) {
        alerta.setEstado(new EstadoContenida());
    }

    @Override
    public String getNombre() {
        return "EN ANALISIS";
    }
}
