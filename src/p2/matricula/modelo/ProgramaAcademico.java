/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.matricula.modelo;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import utilities.Ortografia;

/**
 *
 * @author Boris Perez
 */
public class ProgramaAcademico {

    // TODO: Agregar atributos
    private String nombre;
    private ArrayList<Curso> cursos = new ArrayList<>();
    private DefaultComboBoxModel<String> modeloComboCursosPrograma;

    //CONSTRUCTOR
    public ProgramaAcademico(String nombre) {
        this.nombre = nombre;
        modeloComboCursosPrograma = new DefaultComboBoxModel<>();
    }

    //EQUALS
    //
    public void aniadirCurso(Curso curso) {
        //Curso curso = new Curso( programa,  nombre,  requisito,  codigo,  capacidad);
        System.out.println(curso);
        cursos.add(curso);
        modeloComboCursosPrograma.addElement(curso.getNombre());
    }

    // TODO: Agregar getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(ArrayList<Curso> cursos) {
        this.cursos = cursos;
    }

    public DefaultComboBoxModel<String> getModeloComboCursosPrograma() {
        return modeloComboCursosPrograma;
    }

    public void setModeloComboCursosPrograma(DefaultComboBoxModel<String> modeloComboCursosPrograma) {
        this.modeloComboCursosPrograma = modeloComboCursosPrograma;
    }

}
