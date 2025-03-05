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

    public ProgramaAcademico() {
    }
    
    

    //EQUALS
    //
    public void aniadirCurso(Curso curso) {
        //Curso curso = new Curso( programa,  nombre,  requisito,  codigo,  capacidad);
        System.out.println(curso);
        cursos.add(curso);
        modeloComboCursosPrograma.addElement(curso.getCodigo() + "");
    }
    
    public void removerCurso(int codigo){
        for (int i = 0; i < cursos.size(); i++) {
            if (cursos.get(i).getCodigo() == codigo) {
                cursos.remove(i);
            }
            
        }
    }

    @Override
    public String toString() {
        return  Ortografia.quitarTildes(nombre);
    }

    
    public ArrayList<String> getCodigosCursos(){
        ArrayList<String> nombresCursos = new ArrayList<>();
        for (int i = 0; i < cursos.size(); i++) {
            nombresCursos.add(cursos.get(i).getCodigo() + "");
        }
        return nombresCursos;
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
