package soc.mediator;

import java.util.HashSet;
import java.util.Set;

public class Antivirus extends ComponenteSOC {
    private Set<String> equiposAislados = new HashSet<>();

    public Antivirus(MediadorSOC mediador) {
        super(mediador, "Antivirus");
    }

    public void aislarEquipo(String ip) {
        equiposAislados.add(ip);
        System.out.println("  [Antivirus] Equipo aislado: " + ip);
    }

    public void liberarEquipo(String ip) {
        equiposAislados.remove(ip);
        System.out.println("  [Antivirus] Equipo liberado: " + ip);
    }
}
