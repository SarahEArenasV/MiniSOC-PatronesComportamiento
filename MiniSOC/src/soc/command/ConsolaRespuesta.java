package soc.command;

import java.util.Stack;

public class ConsolaRespuesta {
    private Stack<Comando> historial = new Stack<>();

    public void ejecutar(Comando comando) {
        comando.ejecutar();
        historial.push(comando);
    }

    public void deshacer() {
        if (!historial.isEmpty()) {
            historial.pop().deshacer();
        }
    }
}
