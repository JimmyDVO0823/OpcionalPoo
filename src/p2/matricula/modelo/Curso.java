/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.matricula.modelo;

/**
 *
 * @author LENOVO LOQ
 */
public class Curso {

    String nombre;
    double requisitoPromedio;
    int codigo;
    int capacidad;
    int estudiantes;

    //CONSTRUCTOR
    public Curso(String nombre,  int codigo, double requisitoPromedio, int capacidad) {
        this.nombre = nombre;
        this.requisitoPromedio = requisitoPromedio;
        this.codigo = codigo;
        this.capacidad = capacidad;
    }

    //
    @Override
    public String toString() {
        return "\nNombre: " + nombre
                + "\nRequisito: " + requisitoPromedio + "\nCodigo: "
                + codigo + "\nCapacidad: " + capacidad;
    }

    public boolean sePuedematricular(){
        boolean sePuede = capacidad > estudiantes;
        return sePuede;
    }
    
    public void confirmacionMatricula(){
        estudiantes++;
    }
    
    //GETTERS SETTERS
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getRequisitoPromedio() {
        return requisitoPromedio;
    }

    public void setRequisitoPromedio(double requisitoPromedio) {
        this.requisitoPromedio = requisitoPromedio;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(int estudiantes) {
        this.estudiantes = estudiantes;
    }

}
