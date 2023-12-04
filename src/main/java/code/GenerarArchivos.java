package code;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import javaBeans.Departamento;
import javaBeans.Departamentos;
import javaBeans.Empleado;
import libs.CheckFiles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class GenerarArchivos {
    public static void GenerarArchivoXML(Departamentos deps) {
        try {
            //Declaracion de variables
            Path p = Path.of("empresa.xml");
            JAXBContext contexto = JAXBContext.newInstance(Departamentos.class, Departamento.class, Empleado.class);
            Marshaller marshaller = contexto.createMarshaller();

            //Se da formato a la salida y se crea el objeto
            marshaller.setProperty(marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(deps, System.out);

            //Se escribe en el fichero seleccionado
            if (CheckFiles.ficheroEscribible(p)) {
                marshaller.marshal(deps, p.toFile());
            }
        } catch (JAXBException e) {
            System.err.println(">>> Error: La clase seleccionada no permite usar JAXB" + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void GenerarArchivoJSON(Departamentos deps) {
        //Declaracion de variables
        Path p = Path.of("empresa.json");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String jsonListaDeps = gson.toJson(deps);

        //Se escribe el JSON
        try {
            Files.writeString(p, jsonListaDeps);
        } catch (SecurityException e) {
            System.err.println(">>> Error: Violacion de seguridad");
        } catch (UnsupportedOperationException e) {
            System.err.println(">>> Error: Peticion no soportada");
        } catch (IOException e) {
            System.err.println(">>> Error: Ha ocurrido un error inesperado");
        }
    }
}
