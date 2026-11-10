package soc.state;

import soc.modelo.Alerta;

public class EstadoNueva implements EstadoAlerta {

    @Override
    public void siguiente(Alerta alerta) {
        alerta.setEstado(new EstadoEnAnalisis());
    }

    @Override
    public String getNombre() {
        return "NUEVA";
    }
}
