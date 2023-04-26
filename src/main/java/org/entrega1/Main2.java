package org.entrega1;

import org.entrega1.modelo.Equipo;
import org.entrega1.modelo.Partido;
import org.entrega1.modelo.Pronostico;
import org.entrega1.modelo.Ronda;
import org.entrega1.util.Archivos2;
import org.entrega1.modelo.ResultadoEnum;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.lang.Integer.parseInt;

public class Main2 {
    public final static String ARCHIVO_RESULTADOS = "./src/main/java/org/entrega1/data/partidos.csv";
    public final static String ARCHIVO_PRONOSTICO = "./src/main/java/org/entrega1/data/resultados.csv";
    public static void main(String[] args) throws IOException {
//        System.out.println(Arrays.toString(Archivos2.datosArchivo(ARCHIVO_RESULTADOS)));
//        System.out.println(Arrays.toString(Archivos2.datosArchivo(ARCHIVO_PRONOSTICO)));
        List<String>[] datos = Archivos2.datosArchivo(ARCHIVO_RESULTADOS);
        Equipo argentina = new Equipo(datos[0].get(0), "Argentina");
        Equipo arabiaSaudita = new Equipo(datos[0].get(3), "Arabia Saudita");
        Equipo mexico = new Equipo(datos[1].get(0), "Mexico");
        Equipo polonia = new Equipo(datos[1].get(3), "Polonia");
        Partido argentinaArabia = new Partido(argentina, arabiaSaudita, parseInt(datos[0].get(1)),
                parseInt(datos[0].get(2)));
        Partido mexicoPolonia = new Partido(mexico, polonia, parseInt(datos[1].get(1)),
                parseInt(datos[1].get(2)));
        Ronda faseDeGrupos = new Ronda();
        faseDeGrupos.setNro("2");
        faseDeGrupos.setPartidos(new Partido[]{argentinaArabia, mexicoPolonia});
        Pronostico pronostico1 = new Pronostico(argentinaArabia, argentina, ResultadoEnum.ganador);
        Pronostico pronostico2 = new Pronostico(mexicoPolonia, mexico, ResultadoEnum.empate);
        System.out.println("Puntos: " + (pronostico1.puntos() + pronostico2.puntos()));
    }
}
