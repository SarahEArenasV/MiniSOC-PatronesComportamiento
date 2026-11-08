package soc.strategy;

import soc.modelo.Evento;

import java.util.HashMap;
import java.util.Map;

public class RiesgoPorFrecuencia implements EstrategiaRiesgo {
    private Map<String, Integer> intentos = new HashMap<>();

    @Override
    public int calcularRiesgo(Evento evento) {
        int veces = intentos.getOrDefault(evento.getIp(), 0) + 1;
        intentos.put(evento.getIp(), veces);
        return veces * 25;
    }
}
