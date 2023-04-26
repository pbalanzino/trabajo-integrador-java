package org.entrega1.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Archivos2 {
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

}
