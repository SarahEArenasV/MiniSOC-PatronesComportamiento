package soc.memento;

import java.util.ArrayList;
import java.util.List;

public class HistorialConfiguracion {
    private List<ConfiguracionFirewall> respaldos = new ArrayList<>();

    public void guardar(ConfiguracionFirewall config) {
        respaldos.add(config);
    }

    public ConfiguracionFirewall obtener(int indice) {
        return respaldos.get(indice);
    }

    public ConfiguracionFirewall ultimo() {
        return respaldos.get(respaldos.size() - 1);
    }
}
