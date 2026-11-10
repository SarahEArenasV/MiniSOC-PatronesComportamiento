package soc.observer;

import soc.modelo.Alerta;

public class NotificadorCorreo implements Observador {
    private String correo;

    public NotificadorCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public void actualizar(Alerta alerta) {
        if (alerta.getEstado().getNombre().equals("NUEVA")) {
            System.out.println("  [Correo] Enviado a " + correo + ": nueva amenaza " + alerta.getEvento().getTipo());
        }
    }
}
