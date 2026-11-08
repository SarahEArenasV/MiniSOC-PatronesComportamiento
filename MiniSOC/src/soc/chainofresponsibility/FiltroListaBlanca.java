package soc.chainofresponsibility;

import soc.modelo.Evento;

import java.util.Arrays;
import java.util.List;

public class FiltroListaBlanca extends FiltroTrafico {
    private List<String> ipsConfiables = Arrays.asList("192.168.1.1", "192.168.1.10");

    @Override
    public boolean manejar(Evento evento) {
        if (ipsConfiables.contains(evento.getIp())) {
            System.out.println("  [Lista Blanca] " + evento.getIp() + " es confiable");
            return false;
        }
        return pasarAlSiguiente(evento);
    }
}
