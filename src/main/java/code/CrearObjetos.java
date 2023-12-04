package code;

import javaBeans.Departamento;
import javaBeans.Departamentos;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import javaBeans.Empleado;
import libs.CheckFiles;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

public class CrearObjetos {
    // Método para crear objetos Departamentos
    public static Departamentos CrearObjetos() {
        // Declaracion variables locales
        Departamentos departamentos = new Departamentos();
        Path p = Path.of("src/main/resources/departamentos.xml");
        JAXBContext contexto = null;

        // Comprobar si el fichero 'departamentos.xml' es legible
        if (CheckFiles.ficheroLegible(p)) {

            // Crear los objetos
            try {
                contexto = JAXBContext.newInstance(Departamentos.class);
                Unmarshaller jaxbUnmarshaller = contexto.createUnmarshaller();
                departamentos = (Departamentos) jaxbUnmarshaller.unmarshal(p.toFile());
            } catch (JAXBException e) {
                System.err.println(">>> Error: error inesperado");
            }

            // Inicializar el ArrayList de empleados para cada departamento
            for (Departamento d : departamentos.getListaDeps()) {
                d.setEmpleados(new ArrayList<Empleado>());

                // Mostrar información del departamento por pantalla
                System.out.println("ID: " + d.getId());
                System.out.println("Nombre: " + d.getNombre());
                System.out.println("Localidad: " + d.getLocalidad());
                System.out.println();
            }
        } else {
            System.err.println(">>> ERROR en la lectura del archivo 'departamentos.xml'");
        }
        return departamentos;
    }
}
