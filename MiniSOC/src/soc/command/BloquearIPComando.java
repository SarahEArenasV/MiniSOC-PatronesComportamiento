package soc.command;

import soc.mediator.Firewall;

public class BloquearIPComando implements Comando {
    private Firewall firewall;
    private String ip;

    public BloquearIPComando(Firewall firewall, String ip) {
        this.firewall = firewall;
        this.ip = ip;
    }

    @Override
    public void ejecutar() {
        firewall.bloquearIP(ip);
    }

    @Override
    public void deshacer() {
        firewall.desbloquearIP(ip);
    }
}
