package javaBeans;

import jakarta.xml.bind.annotation.*;

import java.util.ArrayList;

@XmlRootElement(name = "departamento")
@XmlType(propOrder = {"id", "nombre", "localidad"})

public class Departamento {
    private int id;
    private String nombre;
    private String localidad;
    private ArrayList<Empleado> empleados;

    public Departamento(int id, String nombre, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.localidad = localidad;
    }

    public Departamento() {
    }

    @Override
    public String toString() {
        return "Departamento [id=" + id + ", nombre=" + nombre + ", localidad=" + localidad + "]";
    }

    @XmlAttribute(name = "id")
    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    @XmlElement(name = "nombre")
    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    @XmlElement(name = "localidad")
    public String getLocalidad() {return localidad;}
    public void setLocalidad(String localidad) {this.localidad = localidad;}

    @XmlTransient
    public ArrayList<Empleado> getEmpleados() {return empleados;}
    public void setEmpleados(ArrayList<Empleado> empleados) {this.empleados = empleados;}
}

