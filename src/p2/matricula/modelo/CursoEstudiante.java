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
public class CursoEstudiante {
    ArrayList<Estudiante> estudiantes;
    ArrayList<Curso> cursos;
    ArrayList<Double> notas;
    ArrayList<Integer> semestres;

    public CursoEstudiante() {
        estudiantes = new ArrayList();
        cursos = new ArrayList();
        notas = new ArrayList();
        semestres = new ArrayList();
    }
    
    
    
    //GETTERS Y SETTERS

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public ArrayList<Double> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Double> notas) {
        this.notas = notas;
    }

    public ArrayList<Integer> getSemestres() {
        return semestres;
    }

    public void setSemestres(ArrayList<Integer> semestres) {
        this.semestres = semestres;
    }
    
    
}
