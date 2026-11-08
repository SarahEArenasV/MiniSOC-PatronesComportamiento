package soc.chainofresponsibility;

import soc.modelo.Evento;
import soc.strategy.AnalizadorRiesgo;

public class FiltroHeuristico extends FiltroTrafico {
    private AnalizadorRiesgo analizador;
    private int umbral;

    public FiltroHeuristico(AnalizadorRiesgo analizador, int umbral) {
        this.analizador = analizador;
        this.umbral = umbral;
    }

    @Override
    public boolean manejar(Evento evento) {
        int riesgo = analizador.calcular(evento);
        System.out.println("  [Heuristico] Riesgo calculado: " + riesgo);
        if (riesgo >= umbral) {
            evento.setTipo("ANOMALIA");
            return true;
        }
        return pasarAlSiguiente(evento);
    }
}
