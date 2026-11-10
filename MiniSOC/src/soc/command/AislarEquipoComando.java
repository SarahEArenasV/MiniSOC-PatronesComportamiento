package soc.command;

import soc.mediator.Antivirus;

public class AislarEquipoComando implements Comando {
    private Antivirus antivirus;
    private String ip;

    public AislarEquipoComando(Antivirus antivirus, String ip) {
        this.antivirus = antivirus;
        this.ip = ip;
    }

    @Override
    public void ejecutar() {
        antivirus.aislarEquipo(ip);
    }

    @Override
    public void deshacer() {
        antivirus.liberarEquipo(ip);
    }
}
