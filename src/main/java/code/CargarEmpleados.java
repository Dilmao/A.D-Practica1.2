package code;

import com.google.gson.Gson;
import javaBeans.Departamento;
import javaBeans.Departamentos;
import javaBeans.Empleado;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.MalformedInputException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.time.Instant;
import java.util.Date;

public class CargarEmpleados {
    public static void CargarNuevosEmpleados(Departamentos deps) {
        //Archivo a leer
        Path p = Path.of("src/main/resources/nuevosEmpleados.json");
        String txtJson = readFile(p);
        Gson gson = new Gson();
        Empleado[] empsJson = gson.fromJson(txtJson, Empleado[].class);

        //Generar la antiguedad(fecha del sistema) y añadir empleados
        Date hoy = Date.from(Instant.now());
        for (Empleado e : empsJson) {
            e.setAntiguedad(hoy);
            for (Departamento d : deps.getListaDeps()) {
                d.getEmpleados().add(e);
            }
        }
    }

    private static String readFile(Path p) {
        StringBuilder texto = new StringBuilder();
        if (Files.exists(p) && !Files.isDirectory(p)) {
            try {
                for (String s : Files.readAllLines(p)) {
                    texto.append(s);
                }
            } catch (FileNotFoundException e) {
                System.err.println(">>> Error: La ruta introducida no existe");
            } catch (MalformedInputException e) {
                System.err.println(">>> Error: Comprueba que la codificacion del archivo sea UTF-8");
            } catch (NoSuchFileException e) {
                System.err.println(">>> Error: El archivo introducido no existe");
            } catch (IOException e) {
                System.err.println(">>> Error: Ha ocurrido un problema inesperado: ");
                e.printStackTrace();
            }
        }
        return texto.toString();
    }
}
