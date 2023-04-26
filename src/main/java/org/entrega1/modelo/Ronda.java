package org.entrega1.modelo;


public class Ronda extends Partido {
    private String nro;
    private Partido[] partidos = new Partido[2];

    public Ronda() {
        super();
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
    public int puntos(){
        int puntos = 0;
        return puntos + partidos.length;
    }
}