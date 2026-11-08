package soc.modelo;

import soc.observer.Observador;
import soc.observer.Sujeto;
import soc.state.EstadoAlerta;
import soc.state.EstadoNueva;

import java.util.ArrayList;
import java.util.List;

public class Alerta implements Sujeto {
    private static int contador = 1;
    private int id;
    private Evento evento;
    private EstadoAlerta estado;
    private List<Observador> observadores = new ArrayList<>();

    public Alerta(Evento evento) {
        this.id = contador++;
        this.evento = evento;
        this.estado = new EstadoNueva();
    }

    public void siguienteEstado() {
        estado.siguiente(this);
    }

    public void setEstado(EstadoAlerta estado) {
        this.estado = estado;
        notificar();
    }

    public EstadoAlerta getEstado() { return estado; }
    public Evento getEvento() { return evento; }
    public int getId() { return id; }

    @Override
    public void suscribir(Observador o) { observadores.add(o); }

    @Override
    public void desuscribir(Observador o) { observadores.remove(o); }

    @Override
    public void notificar() {
        for (Observador o : observadores) {
            o.actualizar(this);
        }
    }
}
