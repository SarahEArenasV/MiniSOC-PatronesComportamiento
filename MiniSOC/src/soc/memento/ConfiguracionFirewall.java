package soc.memento;

import java.util.Set;

public class ConfiguracionFirewall {
    private final Set<String> ipsBloqueadas;

    public ConfiguracionFirewall(Set<String> ipsBloqueadas) {
        this.ipsBloqueadas = ipsBloqueadas;
    }

    public Set<String> getIpsBloqueadas() {
        return ipsBloqueadas;
    }
}
