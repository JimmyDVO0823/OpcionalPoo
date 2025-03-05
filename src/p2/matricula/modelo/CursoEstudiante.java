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
    final int LIMITE_CURSOS = 5;
    int semestre;
    Estudiante estudiante;
    ArrayList<Curso> cursos;
    ArrayList<Double> notas;

    public CursoEstudiante(Estudiante estudiante,int semestre) {
        this.estudiante = estudiante;
        this.semestre = semestre;
        cursos = new ArrayList(5);
        notas = new ArrayList(5);
    }
    
    
    
    
    //GETTERS Y SETTERS

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
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

    
}