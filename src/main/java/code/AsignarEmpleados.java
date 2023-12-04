package code;

import javaBeans.Departamento;
import javaBeans.Departamentos;
import javaBeans.Empleado;
import libs.Leer;

import java.util.ArrayList;
import java.util.List;

public class AsignarEmpleados {
    public static Departamentos AsignarEmpleados(ArrayList<Empleado> empleados, Departamentos deps) {
        for (Empleado e : empleados) {
            // Mostrar los departamentos disponibles por pantalla
            int i = 1;
            System.out.println("Departamentos disponibles: ");
            for (Departamento d : deps.getListaDeps()) {
                System.out.println(i + ". " +d.getNombre());
                i++;
            }

            // Pedir al usuario el departamento al que quiere agregar al empleado
            int deptElegido = Leer.pedirEntero("Introduzca el id del departamento al que perteneze " + e.getNombre() + ":");

            // Comprobar si el departamento seleccionado existe
            if (deptElegido > 0 && deptElegido <= deps.getListaDeps().size()) {
                deps.getListaDeps().get(deptElegido - 1).getEmpleados().add(e);
            } else {
                System.err.println(">>> Error: El departamento introducido no existe");
            }
        }

        // Comprobar la asignación de empleados adepartamentos
        for (Departamento d : deps.getListaDeps()) {
            System.out.println(d.getNombre());
            for (Empleado e : d.getEmpleados()) {
                System.out.println("    " + e.getNombre());
            }
        }
        return deps;
    }
}
