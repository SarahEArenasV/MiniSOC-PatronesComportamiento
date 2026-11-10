package soc.state;

import soc.modelo.Alerta;

public class EstadoCerrada implements EstadoAlerta {

    @Override
    public void siguiente(Alerta alerta) {
        System.out.println("  La alerta #" + alerta.getId() + " ya esta cerrada");
    }

    @Override
    public String getNombre() {
        return "CERRADA";
    }
}
