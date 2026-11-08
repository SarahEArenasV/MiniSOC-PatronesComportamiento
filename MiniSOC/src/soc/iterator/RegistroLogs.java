package soc.iterator;

import soc.modelo.Evento;

import java.util.ArrayList;
import java.util.List;

public class RegistroLogs implements ColeccionEventos {
    private List<Evento> eventos = new ArrayList<>();

    public void agregar(Evento e) { eventos.add(e); }
    public int tamanio() { return eventos.size(); }
    public Evento obtener(int i) { return eventos.get(i); }

    @Override
    public IteradorEventos crearIterador() {
        return new IteradorLogs(this);
    }
}
