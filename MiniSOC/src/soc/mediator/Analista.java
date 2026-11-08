package soc.mediator;

import soc.modelo.Alerta;

public class Analista extends ComponenteSOC {

    public Analista(MediadorSOC mediador, String nombre) {
        super(mediador, nombre);
    }

    public void revisar(Alerta alerta) {
        alerta.siguienteEstado();
        mediador.notificar(this, "CONTENER", alerta);
    }

    public void reportarFalsoPositivo(Alerta alerta) {
        mediador.notificar(this, "FALSO_POSITIVO", alerta);
    }

    public void cerrar(Alerta alerta) {
        alerta.siguienteEstado();
    }
}
