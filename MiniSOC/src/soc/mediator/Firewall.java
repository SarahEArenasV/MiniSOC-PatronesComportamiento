package soc.mediator;

import soc.memento.ConfiguracionFirewall;

import java.util.HashSet;
import java.util.Set;

public class Firewall extends ComponenteSOC {
    private Set<String> ipsBloqueadas = new HashSet<>();

    public Firewall(MediadorSOC mediador) {
        super(mediador, "Firewall");
    }

    public void bloquearIP(String ip) {
        ipsBloqueadas.add(ip);
        System.out.println("  [Firewall] IP bloqueada: " + ip);
    }

    public void desbloquearIP(String ip) {
        ipsBloqueadas.remove(ip);
        System.out.println("  [Firewall] IP desbloqueada: " + ip);
    }

    public ConfiguracionFirewall guardar() {
        return new ConfiguracionFirewall(new HashSet<>(ipsBloqueadas));
    }

    public void restaurar(ConfiguracionFirewall config) {
        ipsBloqueadas = new HashSet<>(config.getIpsBloqueadas());
        System.out.println("  [Firewall] Configuracion restaurada: " + ipsBloqueadas);
    }

    public Set<String> getIpsBloqueadas() { return ipsBloqueadas; }
}
