package soc.mediator;

import soc.modelo.Alerta;

public interface MediadorSOC {
    void notificar(ComponenteSOC emisor, String accion, Alerta alerta);
}
