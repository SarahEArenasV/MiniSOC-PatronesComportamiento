package soc.state;

import soc.modelo.Alerta;

public class EstadoContenida implements EstadoAlerta {

    @Override
    public void siguiente(Alerta alerta) {
        alerta.setEstado(new EstadoCerrada());
    }

    @Override
    public String getNombre() {
        return "CONTENIDA";
    }
}
