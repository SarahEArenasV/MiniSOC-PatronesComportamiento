package soc.modelo;

public class Evento {
    private int id;
    private String ip;
    private int puerto;
    private String contenido;
    private int severidad;
    private String tipo;

    public Evento(int id, String ip, int puerto, String contenido, int severidad) {
        this.id = id;
        this.ip = ip;
        this.puerto = puerto;
        this.contenido = contenido;
        this.severidad = severidad;
        this.tipo = "DESCONOCIDO";
    }

    public int getId() { return id; }
    public String getIp() { return ip; }
    public int getPuerto() { return puerto; }
    public String getContenido() { return contenido; }
    public int getSeveridad() { return severidad; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    @Override
    public String toString() {
        return "Evento#" + id + " [" + ip + ":" + puerto + "] " + contenido;
    }
}
