/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.matricula.modelo;

import java.util.ArrayList;

/**
 *
 * @author Boris Perez
 */
public class Universidad {

    private ArrayList<ProgramaAcademico> programas;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<Curso> cursos;

    public Universidad() {
        programas = new ArrayList<ProgramaAcademico>();
        estudiantes = new ArrayList<Estudiante>();
    }

    //*********************************************
    // IMPORTANTE: Pueden requerirse más métodos.
    //*********************************************
    /**
     * Metodo para agregar estudiante. Se debe modificar la lista de parámetros
     * para incluir los atributos necesarios para crear el objeto Estudiante.
     */
    public void registrarEstudiante(String nombre, String correo, int codigo, long telefono, double promedio) {
        // Crear el objeto
        Estudiante estudiante;

        // Asignar atributos
        estudiante = new Estudiante(nombre, correo, codigo, telefono, promedio);

        // Agregar a la lista
        estudiantes.add(estudiante);
    }
    
    public void desactivarEstudiante(){
        
    }

    /**
     * Metodo para agregar curso. Se debe modificar la lista de parámetros para
     * incluir los atributos necesarios para crear el objeto Curso.
     */
    public void agregarCurso(String programa,String nombre,String cod,String prom,String cap) {
        ProgramaAcademico programaAcademico = null;
        Curso curso;
        
        int codigo = Integer.parseInt(cod);
        double RequisitoPrommedio = Double.parseDouble(prom);
        int capacidad = Integer.parseInt(cap);
        
        // Revisar la lista de programas académicos
        for (int i = 0; i < programas.size(); i++) {
            if (programas.get(i).getNombre().equals(programa)) {
                programaAcademico = programas.get(i);
            }
        }

        // Cuando encuentre el programa:
        //  a) Retornar la lista de cursos
        //  b) Crear el objeto Curso y asignarle los atributos
        curso = new Curso(nombre, codigo, RequisitoPrommedio, capacidad);
        //  c) Agregar el objeto a la lista
        programaAcademico.aniadirCurso(curso);
        cursos.add(curso);
    }

    /**
     * Metodo para matricular cursos. Se debe modificar la lista de parámetros
     * para incluir los atributos necesarios para cumplir el propósito.
     */
    public void matricular() {
        // Obtener el objeto Estudiante, comparándolo con el código 
        // pasado como parámetro

        // Buscar el curso, usando el código, dentro de la lista de 
        // programas académicos.
        // Asociar el curso a la lista de cursos del estudiante.
    }

    /**
     * Metodo para listar cursos matriculados. Se debe modificar la lista de
     * parámetros para incluir los atributos necesarios para cumplir el
     * propósito.
     */
    public ArrayList<String> listarCursosMatriculados() {

        // Se busca al estudiante
        // Se obtiene la lista de cursos
        // Se recorre la lista y se arma un String 
        // con el código y el nombre
        // Se retorna la nueva lista.
        return null;
    }

}
