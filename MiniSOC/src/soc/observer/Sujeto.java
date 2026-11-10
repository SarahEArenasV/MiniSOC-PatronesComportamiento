package soc.observer;

public interface Sujeto {
    void suscribir(Observador o);
    void desuscribir(Observador o);
    void notificar();
}
