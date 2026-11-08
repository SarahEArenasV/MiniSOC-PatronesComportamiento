package soc.mediator;

public abstract class ComponenteSOC {
    protected MediadorSOC mediador;
    protected String nombre;

    public ComponenteSOC(MediadorSOC mediador, String nombre) {
        this.mediador = mediador;
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
}
