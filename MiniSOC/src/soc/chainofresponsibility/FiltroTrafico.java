package soc.chainofresponsibility;

import soc.modelo.Evento;

public abstract class FiltroTrafico {
    protected FiltroTrafico siguiente;

    public FiltroTrafico enlazar(FiltroTrafico siguiente) {
        this.siguiente = siguiente;
        return siguiente;
    }

    public abstract boolean manejar(Evento evento);

    protected boolean pasarAlSiguiente(Evento evento) {
        if (siguiente == null) {
            return false;
        }
        return siguiente.manejar(evento);
    }
}
