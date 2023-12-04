import javaBeans.Departamentos;
import javaBeans.Empleado;

import java.util.ArrayList;

public class Menu {
    public static void main(String[] args) {
        boolean salir = false;
        String opcion;

        // Lista para almacenar empleados desde un archivo CSV
        ArrayList<Empleado> empleadosCSV = new ArrayList<>();

        // Variable para almacenar los departamentos creados
        Departamentos deps = null;

        while (!salir) {
            // Mostrar el menú al usuario
            System.out.println("""
                ******************************************************
                0. Salir
                1. Introducir datos de empleado
                2. Crear objetos de departamentos.xml
                3. Asignar empleados a un departamento
                4. Cargar nuevos empleados
                5. Generar archivos xml y json
                ******************************************************""");
            opcion = libs.Leer.pedirCadena("Introduce una opción");

            switch (opcion) {
                case "0" -> salir = true;
                case "1" -> code.IntroducirDatosEmpleado.IntroducirDatos(empleadosCSV);
                case "2" -> {
                    // Crear objetos de departamentos.xml y mostrar la lista de departamentos
                    deps = code.CrearObjetos.CrearObjetos();
                    System.out.println(deps.getListaDeps());
                }
                case "3" -> code.AsignarEmpleados.AsignarEmpleados(empleadosCSV, deps);
                case "4" -> code.CargarEmpleados.CargarNuevosEmpleados(deps);
                case "5" -> {
                    // Generar arhcivos XML y JSON basados en los departamentos
                    code.GenerarArchivos.GenerarArchivoXML(deps);
                    code.GenerarArchivos.GenerarArchivoJSON(deps);
                }
                default -> System.out.println("Opción incorrecta");
            }
        }
    }
}
