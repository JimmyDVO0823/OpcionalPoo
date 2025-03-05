/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.matricula.controlador;

import java.util.Collection;
import javax.swing.DefaultComboBoxModel;
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
        String[] programas;
        this.frame.getListModelProgramas().addAll(uni.getnombreProgramas());
    }

    public void registrarEstudiante() {
        String sem = frame.getTxtSemestreEstudiante().getText();
        int semestre = Integer.parseInt(sem);
        String cod = frame.getTxtCodigoEstudiante().getText();
        int codigo = Integer.parseInt(cod);
        String nom = frame.getTxtNombreEstudiante().getText();
        String cor = frame.getTxtCorreoEstudiante().getText();
        String tel = frame.getTxtTelefonoEstudiante().getText();
        long telefono = Long.parseLong(tel);
        String prom = frame.getTxtPromedioEstudiante().getText();
        double promDouble = Double.parseDouble(prom);

        if (!contieneElemento(frame.getListModelEstudiantes(), cod)) {
            uni.registrarEstudiante(nom, cor, codigo, telefono, promDouble, semestre);
            frame.getListModelEstudiantes().addElement(cod);
        }

    }

    public void registrarCurso() {
        // Obtener atributos
        String programa = frame.getCmbProgramaAcad().getModel().getSelectedItem().toString();
        String codigo = frame.getTxtCodigoCurso().getText();
        System.out.println(programa);
        String nombre = frame.getTxtNombreCurso().getText();
        String promedio = frame.getTxtRequisitoPromedioRegCurso().getText();
        String capacidad = frame.getTxtCapacidadRegCurso().getText();

        System.out.println("el programa elegido es" + programa);
        if (!contieneElemento(frame.getListModelCursosMatriculados(),codigo)) {
            uni.agregarCurso(programa, nombre, codigo, promedio, codigo);
            frame.getListModelCursosMatriculados().addElement(codigo);
        }
        // ...
    }

    public void cancelarEstudiante() {
        int codigo = Integer.parseInt(frame.getTxtCodigoEstudiante().getText());

        frame.getListModelEstudiantes().removeElement(codigo + "");

    }

    public void desactivarEstudiante() {
        //no se listarán al momento de inscribir cursos
        String estudiante = frame.getTxtCodigoEstudiante().getText();
        frame.getListModelEstudiantes().removeElement(estudiante);

    }

    
    //DESMATRICULAR
    
    public void programaSeleccionado(){
        String programa = frame.getCmbProgramaMatricula().getModel().getSelectedItem().toString();
        //System.out.println("programa seleccionado es:>>>>>" + programa);
        frame.getListModelCursosMatriculados().removeAllElements();
        frame.getListModelCursosMatriculados().addAll(uni.getCodigosCursosArray(programa));
    }
    
    public void retirarCurso() {
        String curso = frame.getTxtCodigoCursoRegCurso().getText();
        frame.getListModelCursosMatriculados().removeElement(curso);
    }

    public void desactivarCurso() {
        //siempre que no haya estudiantes inscritos
        String programa = frame.getCmbProgramaAcad().getModel().getSelectedItem().toString();
        String codigo = frame.getTxtCodigoCurso().getText();
        
        boolean desactivar = uni.desactivarCurso(programa,codigo);
        if(desactivar)frame.getListModelCursosMatriculados().removeElement(codigo);

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
        String codEst = frame.getCmbCodigoEstudianteMatricula().getModel().getSelectedItem().toString();
        //System.out.println("EL CODIGO ES " + codEst);
        String programa = frame.getCmbProgramaMatricula().getModel().getSelectedItem().toString();
        //System.out.println("El programa es " + programa);
        String codCurso = frame.getCmbCodigoCursoMatricula().getModel().getSelectedItem().toString();
        //System.out.println("El codigo del curso es " + codCurso);
        
        uni.matricular(codEst, programa, codCurso);
        frame.getTxtLista().setText("Cursos Relacionados");
        frame.getTxtCursos().setModel(frame.getListModelCursosMatriculados());
        
    }

    public void registrarNotaEstudiante() {

    }
    
    public void verProgramas(){
        frame.getTxtCursos().setModel(frame.getListModelProgramas());
        frame.getTxtLista().setText("Programas Académicos");
    }

    public boolean contieneElemento(DefaultComboBoxModel<String> modelo, String elemento) {
        for (int i = 0; i < modelo.getSize(); i++) {
            String elementoActual = modelo.getElementAt(i);
            if (elementoActual != null && elementoActual.equals(elemento)) {
                return true; // Elemento encontrado
            }
        }
        return false; // Elemento no existe en el modelo
    }
    
    public void actualizar(){
        
    }

}

/*
        frame.getTxtCodigoEstudiante().setText("");
        frame.getTxtCorreoEstudiante().setText("");
        frame.getTxtTelefonoEstudiante().setText("");
        frame.getTxtNombreEstudiante().setText("");
        frame.getTxtPromedioEstudiante().setText("");
 */
