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
public class Estudiante {

    // TODO: Agregar atributos
    private int codigo;
    private int semestre;
    private long telefono;
    private int limite;
    private String nombres;
    private String correo;
    private double promedioAcumulado;
    private CursoEstudiante cursosEstudiantes;

    //Comportamientos
    public Estudiante(String nombres, String correo, int codigo, long telefono, double promedioAcumulado, int semestre) {
        limite = 5;
        this.codigo = codigo;
        this.telefono = telefono;
        this.nombres = nombres;
        this.correo = correo;
        this.promedioAcumulado = promedioAcumulado;
        this.semestre = semestre;
        cursosEstudiantes = new CursoEstudiante(this);
        System.out.println("Se pudo");
    }

    public void aniadirNota(int curso, double nota){
        cursosEstudiantes.asignarNota(curso, nota);
    }
    
    public String getCursosCodNom() {
        String cursos = "";
        cursos = cursosEstudiantes.getCursosCodigosNombres();

        return cursos;
    }
    
    public void aniadirCurso(Curso curso){
        if (promedioAcumulado >= curso.getRequisitoPromedio()) {
        cursosEstudiantes.aniadirCurso(curso);
        curso.getPromediosEstudiantes().add(promedioAcumulado);
        }
        else System.out.println("No se pudo por promedio");
    }

    @Override
    public String toString() {
        return codigo + "";
    }

    // TODO: Agregar getters y setters
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public double getPromedioAcumulado() {
        return promedioAcumulado;
    }

    public void setPromedioAcumulado(double promedioAcumulado) {
        this.promedioAcumulado = promedioAcumulado;
    }

}
