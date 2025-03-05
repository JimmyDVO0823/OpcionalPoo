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
    int cantidadCursos;
    int semestre;
    Estudiante estudiante;
    ArrayList<Curso> cursos;
    ArrayList<Double> notas;

    public CursoEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.semestre = semestre;
        cursos = new ArrayList(5);
        notas = new ArrayList(5);
        
    }
    
    public String getCursosCodigosNombres(){
        String cursosString = "";
        for (int i = 0; i < cursos.size(); i++) {
            cursosString += "\n" + cursos.get(i).getNombre();
        }
        return cursosString;
    }
    
    public int getIndiceCurso(int  codigo){
        int indice = -1;
        for (int i = 0; i < cursos.size(); i++) {
            if(cursos.get(i).codigo == codigo){
                indice = i;
            }
        }
        return indice;
    }
    
    public void aniadirCurso(Curso curso){
        if (cantidadCursos<LIMITE_CURSOS && curso.sePuedematricular()) {
        curso.confirmacionMatricula();
        cursos.add(curso);
        System.out.println("SE AÑADIO");
        notas.add(0.0);
        }
        cantidadCursos++;
    }
    
    public void asignarNota(int codigo, double nota){
        int indice = 0;
        indice = getIndiceCurso(codigo);
        notas.set(indice, nota);
        System.out.println("El curso es " + codigo + " y la nota es " + nota);
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