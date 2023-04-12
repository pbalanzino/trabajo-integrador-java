package org.entrega1.modelo;

public class Ronda extends Partido {
    private String nro;
    private Partido[] partidos;

    public Ronda() {
        super();
    }

    public Ronda(String nro, Partido[] partidos) {
        this.nro = nro;
        this.partidos = new Partido[Integer.parseInt(nro)];
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }
//public int puntos() {
//
//}
}