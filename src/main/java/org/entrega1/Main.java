package org.entrega1;

import org.entrega1.modelo.*;
import org.entrega1.util.Archivos;

import java.io.IOException;
import java.util.*;

//import static sun.nio.ch.DatagramChannelImpl.AbstractSelectableChannels.forEach;

public class Main {
    public final static String ARCHIVO_RESULTADOS = "./src/main/java/org/entrega1/data/partidos.csv";
    public final static String ARCHIVO_PRONOSTICO = "./src/main/java/org/entrega1/data/resultados.csv";

    public final static Map<String, List<String>> MAPA_RESULTADOS;

    static {
        try {
            MAPA_RESULTADOS = Archivos.mapaDatos(ARCHIVO_RESULTADOS);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
        Set<String> nombreEquipo = new HashSet<>();
        List<Equipo> equipos = new ArrayList<>();
        List<Partido> partidos = new ArrayList<>();
        List<Ronda> rondas = new ArrayList<>();
        List<Pronostico> pronosticos = new ArrayList<>();
//      Se imprime el mapa de datos
/*        for(Map.Entry<String, List<String>> index : MAPA_RESULTADOS.entrySet()) {
            System.out.println(index.getKey());
            System.out.println(index.getValue().get(0));
        }*/
//      Se obtienen los nombres de los equipos y se guardan en un set
        for(Map.Entry<String, List<String>> index : MAPA_RESULTADOS.entrySet()){
            nombreEquipo.add(String.valueOf(index.getValue().get(0)));
        }
//      Se crea una instancia equipo por cada equipo
        for(String equipo : nombreEquipo){
            String descripcion = String.format("Descripcion %s", equipo);
            equipos.add(new Equipo(equipo, descripcion));
        }
//      Instancias de partido
        MAPA_RESULTADOS.entrySet().forEach(index -> {
            String nombreEquipo1 = index.getValue().get(0);
            String nombreEquipo2 = index.getValue().get(3);
            int cantGoles1 = Integer.parseInt(index.getValue().get(1));
            int cantGoles2 = Integer.parseInt(index.getValue().get(2));
            equipos.forEach(equipo -> {
                if(equipo.getNombre().equals(nombreEquipo1)){
                    equipos.forEach(equipo2 -> {
                        if(equipo2.getNombre().equals(nombreEquipo2)){
                            partidos.add(new Partido(equipo, equipo2, cantGoles1, cantGoles2));
                        }
                    });
                }
            });
        });
        System.out.println(partidos.get(0));
//      Instancias de ronda
//        rondas.add(new Ronda());
//        rondas.get(0).setNro("2");
//        rondas.get(0).setPartidos(partidos.toArray(new Partido[0]));
//        System.out.println(rondas.get(0).getPartidos()[0].getEquipo1().getNombre());
//      Instancias de pronostico
//        List<String>[] datosPronostico = Archivos.datosArchivo(ARCHIVO_PRONOSTICO);

    }
}
