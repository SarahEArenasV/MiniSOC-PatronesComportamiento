package soc.state;

import soc.modelo.Alerta;

public interface EstadoAlerta {
    void siguiente(Alerta alerta);
    String getNombre();
}
