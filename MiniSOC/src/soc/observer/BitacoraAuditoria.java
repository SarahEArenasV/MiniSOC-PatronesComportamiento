package soc.observer;

import soc.modelo.Alerta;

import java.util.ArrayList;
import java.util.List;

public class BitacoraAuditoria implements Observador {
    private List<String> registros = new ArrayList<>();

    @Override
    public void actualizar(Alerta alerta) {
        registros.add("Alerta #" + alerta.getId() + " -> " + alerta.getEstado().getNombre());
    }

    public void imprimir() {
        for (String r : registros) {
            System.out.println("  " + r);
        }
    }
}
