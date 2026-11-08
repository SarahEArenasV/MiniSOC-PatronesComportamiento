package soc.strategy;

import soc.modelo.Evento;

public class AnalizadorRiesgo {
    private EstrategiaRiesgo estrategia;

    public AnalizadorRiesgo(EstrategiaRiesgo estrategia) {
        this.estrategia = estrategia;
    }

    public void setEstrategia(EstrategiaRiesgo estrategia) {
        this.estrategia = estrategia;
    }

    public int calcular(Evento evento) {
        return estrategia.calcularRiesgo(evento);
    }
}
