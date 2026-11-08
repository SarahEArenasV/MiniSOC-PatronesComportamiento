package soc.strategy;

import soc.modelo.Evento;

public interface EstrategiaRiesgo {
    int calcularRiesgo(Evento evento);
}
