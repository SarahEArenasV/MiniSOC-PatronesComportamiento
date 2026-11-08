package soc.iterator;

import soc.modelo.Evento;

public class IteradorLogs implements IteradorEventos {
    private RegistroLogs registro;
    private int posicion = 0;

    public IteradorLogs(RegistroLogs registro) {
        this.registro = registro;
    }

    @Override
    public boolean tieneSiguiente() {
        return posicion < registro.tamanio();
    }

    @Override
    public Evento siguiente() {
        return registro.obtener(posicion++);
    }
}
