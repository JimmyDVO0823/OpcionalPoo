/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.matricula.controlador;

import p2.matricula.modelo.Universidad;
import p2.matricula.vista.MatriculaVista;

/**
 *
 * @author Boris Perez
 */
public class MatriculaControlador {

    private MatriculaVista frame;
    private Universidad uni;

    public MatriculaControlador(MatriculaVista frame) {
        this.frame = frame;
        uni = new Universidad();
    }

    public void registrarEstudiante() {
        String cod = frame.getTxtCodigoEstudiante().getText();
        int codigo = Integer.parseInt(cod);
        String nom = frame.getTxtNombreEstudiante().getText();
        String cor = frame.getTxtCorreoEstudiante().getText();
        String tel = frame.getTxtTelefonoEstudiante().getText();
        long telefono = Long.parseLong(tel);
        String prom = frame.getTxtPromedioEstudiante().getText();
        double promDouble = Double.parseDouble(prom);

        uni.registrarEstudiante(nom, cor, codigo, telefono, promDouble);

    }

    public void cancelarEstudiante() {
        frame.getTxtCodigoEstudiante().setText("");
        frame.getTxtCorreoEstudiante().setText("");
        frame.getTxtTelefonoEstudiante().setText("");
        frame.getTxtNombreEstudiante().setText("");
        frame.getTxtPromedioEstudiante().setText("");
    }

    public void desactivarEstudiante() {
        //no se listarán al momento de inscribir cursos
        String estudiante = frame.getCmbEstudianteDesactivar().getModel().getSelectedItem().toString();
        System.out.println(estudiante + "");

    }

    public void registrarCurso() {
        // Obtener atributos

        String programa = frame.getCmbProgramaAcad().getModel().getSelectedItem().toString();
        String codigo = frame.getTxtCodigoCurso().getText();
        String nombre = frame.getTxtNombreCurso().getText();

        // ...
    }

    //DESMATRICULAR
    public void retirarCurso() {

    }

    public void desactivarCursos() {
        //siempre que no haya estudiantes inscritos

    }

    public void actualizarRequisitoPromedio() {

    }

    public void actualizarCapacidad() {
        //no se podrá realizar cuando haya estudiantes que no cumplan estos requisitos

    }

    public void mostrarCursosMatriculados() {
        // Obtener atributos

    }

    public void matricular() {
        // Obtener atributos

    }

    public void registrarNotaEstudiante() {

    }

}
