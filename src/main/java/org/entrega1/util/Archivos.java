package org.entrega1.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Archivos {
//   Se obtienen los datos del archivo y se guardan en un arreglo de listas
    public static List<String>[] datosArchivo(String archivo) throws IOException {
        List<String> lineas = Files.readAllLines(Paths.get(archivo));
        int encabezado = 1;
        int cantidadLineas = lineas.size() - encabezado;
        List<String>[] datos = new List[cantidadLineas];
        int i = 0;
        for (String linea : lineas) {
            List<String> datosLinea = new ArrayList<>();
            if(i != 0) {
                String[] dato = linea.split(",");
                datosLinea.add(dato[0]);
                datosLinea.add(dato[1]);
                datosLinea.add(dato[2]);
                datosLinea.add(dato[3]);
                datos[i-1] = datosLinea;
            }
            i++;
        }
        return datos;
    }
//   Map con el partido como clave y los datos del partido como valor
    public static Map<String, List<String>> mapaDatos(String archivo) throws IOException {
        List<String>[] datos = datosArchivo(archivo);
        Map<String, List<String>> mapa = new LinkedHashMap<>();
        for (List<String> dato : datos) {
            String partido = String.format("%svs%s",dato.get(0),dato.get(3));
            mapa.put(partido, dato);
        }
        return mapa;
    }
}
