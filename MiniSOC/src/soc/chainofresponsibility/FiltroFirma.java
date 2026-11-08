package soc.chainofresponsibility;

import soc.modelo.Evento;

public class FiltroFirma extends FiltroTrafico {

    @Override
    public boolean manejar(Evento evento) {
        String c = evento.getContenido().toLowerCase();
        if (c.contains("trojan") || c.contains("ransom")) {
            evento.setTipo("MALWARE");
            System.out.println("  [Firma] Firma de malware encontrada");
            return true;
        }
        if (c.contains("drop table") || c.contains("<script>")) {
            evento.setTipo("INTRUSION");
            System.out.println("  [Firma] Firma de intrusion encontrada");
            return true;
        }
        return pasarAlSiguiente(evento);
    }
}
