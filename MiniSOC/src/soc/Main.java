package soc;

import soc.chainofresponsibility.FiltroFirma;
import soc.chainofresponsibility.FiltroHeuristico;
import soc.chainofresponsibility.FiltroListaBlanca;
import soc.chainofresponsibility.FiltroTrafico;
import soc.iterator.IteradorEventos;
import soc.iterator.RegistroLogs;
import soc.mediator.Analista;
import soc.mediator.Antivirus;
import soc.mediator.CentroSOC;
import soc.mediator.Firewall;
import soc.mediator.IDS;
import soc.modelo.Alerta;
import soc.modelo.Evento;
import soc.observer.BitacoraAuditoria;
import soc.observer.NotificadorCorreo;
import soc.observer.PanelMonitoreo;
import soc.strategy.AnalizadorRiesgo;
import soc.strategy.RiesgoPorFrecuencia;
import soc.strategy.RiesgoPorSeveridad;

public class Main {

    public static void main(String[] args) {
        CentroSOC centro = new CentroSOC();

        AnalizadorRiesgo analizador = new AnalizadorRiesgo(new RiesgoPorSeveridad());
        FiltroTrafico cadena = new FiltroListaBlanca();
        cadena.enlazar(new FiltroFirma()).enlazar(new FiltroHeuristico(analizador, 70));

        Firewall firewall = new Firewall(centro);
        Antivirus antivirus = new Antivirus(centro);
        Analista analista = new Analista(centro, "Analista SOC");
        IDS ids = new IDS(centro, cadena, analizador);
        centro.registrar(firewall, antivirus, analista);

        BitacoraAuditoria bitacora = new BitacoraAuditoria();
        centro.agregarObservador(new PanelMonitoreo());
        centro.agregarObservador(new NotificadorCorreo("soc@empresa.com"));
        centro.agregarObservador(bitacora);

        RegistroLogs logs = new RegistroLogs();
        logs.agregar(new Evento(1, "192.168.1.10", 443, "GET /index.html", 1));
        logs.agregar(new Evento(2, "45.33.10.8", 80, "id=1; DROP TABLE usuarios", 6));
        logs.agregar(new Evento(3, "10.0.0.25", 445, "descarga trojan.exe", 9));
        logs.agregar(new Evento(4, "88.21.4.7", 3389, "intento de login", 6));
        logs.agregar(new Evento(5, "172.16.0.4", 8080, "GET /api/productos", 2));

        System.out.println("===== FASE 1: estrategia por severidad =====");
        IteradorEventos it = logs.crearIterador();
        while (it.tieneSiguiente()) {
            ids.analizar(it.siguiente());
        }

        System.out.println("\n===== FASE 2: estrategia por frecuencia =====");
        ids.cambiarEstrategia(new RiesgoPorFrecuencia());
        RegistroLogs escaneo = new RegistroLogs();
        for (int i = 6; i <= 8; i++) {
            escaneo.agregar(new Evento(i, "200.5.5.5", 20 + i, "escaneo de puertos", 3));
        }
        IteradorEventos it2 = escaneo.crearIterador();
        while (it2.tieneSiguiente()) {
            ids.analizar(it2.siguiente());
        }

        System.out.println("\n===== FASE 3: falso positivo =====");
        Alerta ultima = centro.getAlertas().get(centro.getAlertas().size() - 1);
        analista.reportarFalsoPositivo(ultima);

        System.out.println("\n===== FASE 4: cierre de alertas =====");
        centro.cerrarAlertasContenidas();
        System.out.println("  IPs bloqueadas: " + firewall.getIpsBloqueadas());

        System.out.println("\n===== FASE 5: restaurar configuracion del firewall =====");
        centro.restaurarConfiguracionInicial();

        System.out.println("\n===== BITACORA DE AUDITORIA =====");
        bitacora.imprimir();
    }
}
