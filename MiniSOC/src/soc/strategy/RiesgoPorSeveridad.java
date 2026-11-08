package soc.strategy;

import soc.modelo.Evento;

public class RiesgoPorSeveridad implements EstrategiaRiesgo {

    @Override
    public int calcularRiesgo(Evento evento) {
        int riesgo = evento.getSeveridad() * 10;
        if (evento.getPuerto() == 22 || evento.getPuerto() == 3389) {
            riesgo += 20;
        }
        return riesgo;
    }
}
