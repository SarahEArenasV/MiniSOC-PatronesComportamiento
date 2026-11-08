package soc.iterator;

import soc.modelo.Evento;

public interface IteradorEventos {
    boolean tieneSiguiente();
    Evento siguiente();
}
