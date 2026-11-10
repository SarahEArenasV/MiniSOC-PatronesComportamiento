package soc.observer;

import soc.modelo.Alerta;

public class PanelMonitoreo implements Observador {

    @Override
    public void actualizar(Alerta alerta) {
        System.out.println("  [Panel] Alerta #" + alerta.getId() + " | " + alerta.getEvento().getTipo()
                + " | " + alerta.getEvento().getIp() + " | " + alerta.getEstado().getNombre());
    }
}
