package javaBeans;

import java.util.Date;

public class Empleado {
    private String nombre;
    private double sueldo;
    private Integer annoNacimiento;
    private Date antiguedad;
    private Integer idDep;

    public Empleado() {
    }

    public Empleado(String nombre, double sueldo, Integer annoNacimiento, Date antiguedad) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.annoNacimiento = annoNacimiento;
        this.antiguedad = antiguedad;
    }


    public String getNombre() {return nombre;}
    public void setNombre(String nombre) {this.nombre = nombre;}

    public double getSueldo() {return sueldo;}
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;}

    public int getAnnoNacimiento() {return annoNacimiento;}
    public void setAnnoNacimiento(int annoNacimiento) {this.annoNacimiento = annoNacimiento;}

    public Date getAntiguedad() {return antiguedad;}
    public void setAntiguedad(Date antiguedad) {this.antiguedad = antiguedad;}

    public void setAnnoNacimiento(Integer annoNacimiento) {this.annoNacimiento = annoNacimiento;}
    public Integer getIdDep() {return idDep;}

    public void setIdDep(Integer idDep) {
        this.idDep = idDep;
    }
}
