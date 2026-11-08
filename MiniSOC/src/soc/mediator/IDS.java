package soc.mediator;

import soc.chainofresponsibility.FiltroTrafico;
import soc.modelo.Alerta;
import soc.modelo.Evento;
import soc.strategy.AnalizadorRiesgo;
import soc.strategy.EstrategiaRiesgo;

public class IDS extends ComponenteSOC {
    private FiltroTrafico cadena;
    private AnalizadorRiesgo analizador;

    public IDS(MediadorSOC mediador, FiltroTrafico cadena, AnalizadorRiesgo analizador) {
        super(mediador, "IDS");
        this.cadena = cadena;
        this.analizador = analizador;
    }

    public void cambiarEstrategia(EstrategiaRiesgo estrategia) {
        analizador.setEstrategia(estrategia);
    }

    public void analizar(Evento evento) {
        System.out.println("\n[IDS] Analizando " + evento);
        if (cadena.manejar(evento)) {
            mediador.notificar(this, "AMENAZA_DETECTADA", new Alerta(evento));
        } else {
            System.out.println("  [IDS] Trafico permitido");
        }
    }
}
