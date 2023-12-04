package code;

import javaBeans.Empleado;
import libs.CheckFiles;
import libs.Leer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;

public class IntroducirDatosEmpleado {

    // Método para introducir datos de empleado en un ArrayList y guardarlos en un archivo CSV
    public static ArrayList<Empleado> IntroducirDatos(ArrayList<Empleado> empleados) {
        // Declaracion de variables locales
        String nombre;
        double sueldo;
        int annoNacimiento;
        Date antiguedad;

        // Se solicita el nombre del empleado para empezar a introducir datos
        nombre = Leer.pedirCadena("Introduce el nombe del empleado('salir' para dejar de introducir empleados)");
        while (!nombre.equalsIgnoreCase("salir")) {

            // Se solicitan y almacenan los datos del empleado
            sueldo = libs.Leer.pedirDouble("Introduce el sueldo del empleado");
            annoNacimiento = libs.Leer.pedirEntero("Introduce el año de nacimiento del empleado");
            antiguedad = libs.Leer.pedirDate("Introduce la fecha en la que el empleado empezo a trabajar (yyyy-MM-dd)");
            Empleado empleadoAux = new Empleado(nombre, sueldo, annoNacimiento, antiguedad);

            // Se introduce al empleado a la lista y se solicita el nombre del siguiente empleado
            empleados.add(empleadoAux);
            nombre = Leer.pedirCadena("Introduce el nombe del empleado('salir' para dejar de introducir empleados)");
        }

        // Se crea el archivo CSV con los datos de los empleados y se devuelve la lista actualizada
        crearCSV(empleados);
        return empleados;
    }

    // Método para crear un archivo CSV a partir de la lista de empleados
    private static void crearCSV(ArrayList<Empleado> empleados) {
        // Declaracion de variables locales
        String linea;
        StringBuilder textoCSV = new StringBuilder();

        // Se recorren los empleados y se formatean los datos en lineas CSV
        for (Empleado e : empleados) {
            linea = e.getNombre() + "," +
                    e.getSueldo() + "," +
                    e.getAnnoNacimiento() +"," +
                    e.getAntiguedad().toString();
            textoCSV.append(linea).append("\n");
        }

        // Se escribe el contenido en el archivo 'empleados.csv'
        Path p = Path.of("empleados.csv");
        if  (CheckFiles.ficheroLegible(p)) {
            try {
                Files.writeString(p, textoCSV);
            } catch (IOException e) {
                System.err.println(">>> Error durante la escritura del archivo 'empleados.csv'");
            }
        } else {
            System.err.println(">>> Error: el fichero 'empleados.csv' no es escribible");
        }
    }
}
