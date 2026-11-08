package soc.mediator;

import soc.command.AislarEquipoComando;
import soc.command.BloquearIPComando;
import soc.command.Comando;
import soc.command.ConsolaRespuesta;
import soc.memento.HistorialConfiguracion;
import soc.modelo.Alerta;
import soc.observer.Observador;

import java.util.ArrayList;
import java.util.List;

public class CentroSOC implements MediadorSOC {
    private Firewall firewall;
    private Antivirus antivirus;
    private Analista analista;
    private ConsolaRespuesta consola = new ConsolaRespuesta();
    private HistorialConfiguracion historial = new HistorialConfiguracion();
    private List<Observador> observadores = new ArrayList<>();
    private List<Alerta> alertas = new ArrayList<>();

    public void registrar(Firewall firewall, Antivirus antivirus, Analista analista) {
        this.firewall = firewall;
        this.antivirus = antivirus;
        this.analista = analista;
        historial.guardar(firewall.guardar());
    }

    public void agregarObservador(Observador o) {
        observadores.add(o);
    }

    @Override
    public void notificar(ComponenteSOC emisor, String accion, Alerta alerta) {
        switch (accion) {
            case "AMENAZA_DETECTADA":
                for (Observador o : observadores) {
                    alerta.suscribir(o);
                }
                alertas.add(alerta);
                alerta.notificar();
                analista.revisar(alerta);
                break;
            case "CONTENER":
                historial.guardar(firewall.guardar());
                consola.ejecutar(crearComando(alerta));
                alerta.siguienteEstado();
                break;
            case "FALSO_POSITIVO":
                consola.deshacer();
                alerta.siguienteEstado();
                break;
        }
    }

    private Comando crearComando(Alerta alerta) {
        String ip = alerta.getEvento().getIp();
        if (alerta.getEvento().getTipo().equals("MALWARE")) {
            return new AislarEquipoComando(antivirus, ip);
        }
        return new BloquearIPComando(firewall, ip);
    }

    public void cerrarAlertasContenidas() {
        for (Alerta a : alertas) {
            if (a.getEstado().getNombre().equals("CONTENIDA")) {
                analista.cerrar(a);
            }
        }
    }

    public void restaurarConfiguracionInicial() {
        firewall.restaurar(historial.obtener(0));
    }

    public List<Alerta> getAlertas() { return alertas; }
}
