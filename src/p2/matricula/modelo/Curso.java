/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.matricula.modelo;

import java.util.ArrayList;

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
    double promedioMenor;
    ArrayList<Double> promediosEstudiantes;
    ArrayList<String> estudiantesNombres;

    //CONSTRUCTOR
    public Curso(String nombre, int codigo, double requisitoPromedio, int capacidad) {
        this.nombre = nombre;
        this.requisitoPromedio = requisitoPromedio;
        this.codigo = codigo;
        this.capacidad = capacidad;
        estudiantesNombres = new ArrayList<>();
        promediosEstudiantes = new ArrayList<>();
    }

    //
    @Override
    public String toString() {
        return "\nNombre: " + nombre
                + "\nRequisito: " + requisitoPromedio + "\nCodigo: "
                + codigo + "\nCapacidad: " + capacidad;
    }

    public void actualizarRequisitoPromedio(double requisitoPromedio) {
        if (requisitoPromedio < getPromedioMinimo()) {
            this.requisitoPromedio = requisitoPromedio;
        }
        else System.out.println("habia un promedio menos. yuca mi rey");
    }
    
    public void actualizarCapacidad(int capacidad){
        if (capacidad > estudiantes)this.capacidad = capacidad;
        else System.out.println("Mucha gente, ya no meta mas");
    }

    public boolean sePuedematricular() {
        boolean sePuede = capacidad > estudiantes;
        return sePuede;
    }

    public void confirmacionMatricula() {
        estudiantes++;
    }

    public double getPromedioMinimo() {
        double promedio = 6;
        for (int i = 0; i < promediosEstudiantes.size(); i++) {
            if (promedio > promediosEstudiantes.get(i)) {
                promedio = promediosEstudiantes.get(i);
            }
        }
        return promedio;
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

    public ArrayList<String> getEstudiantesNombres() {
        return estudiantesNombres;
    }

    public void setEstudiantesNombres(ArrayList<String> estudiantesNombres) {
        this.estudiantesNombres = estudiantesNombres;
    }

    public double getPromedioMenor() {
        return promedioMenor;
    }

    public void setPromedioMenor(double promedioMenor) {
        this.promedioMenor = promedioMenor;
    }

    public ArrayList<Double> getPromediosEstudiantes() {
        return promediosEstudiantes;
    }

    public void setPromediosEstudiantes(ArrayList<Double> promediosEstudiantes) {
        this.promediosEstudiantes = promediosEstudiantes;
    }

}
