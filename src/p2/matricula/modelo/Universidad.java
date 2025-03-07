/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package p2.matricula.modelo;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Boris Perez
 */
public class Universidad {

    private ArrayList<ProgramaAcademico> programas;
    private ArrayList<Estudiante> estudiantes;
    private ArrayList<CursoEstudiante> cursoEstudiantes;
    //private ArrayList<Curso> cursos;

    public Universidad() {
        ProgramaAcademico p1 = new ProgramaAcademico("Ingenieria de Sistemas");
        ProgramaAcademico p2 = new ProgramaAcademico("Contaduria");
        ProgramaAcademico p3 = new ProgramaAcademico("Comunicacion Social");
        programas = new ArrayList<ProgramaAcademico>();
        programas.add(p1);
        programas.add(p2);
        programas.add(p3);
        estudiantes = new ArrayList<Estudiante>();
        cursoEstudiantes = new ArrayList<>();
    }

    public ArrayList<String> getnombreProgramas() {
        ArrayList<String> retorno = new ArrayList<>();
        for (int i = 0; i < programas.size(); i++) {
            retorno.add(programas.get(i).getNombre());
        }
        return retorno;
    }

    public ProgramaAcademico getPrograma(String programa) {
        ProgramaAcademico programaRetorno = new ProgramaAcademico();

        for (int i = 0; i < programas.size(); i++) {
            if (programas.get(i).getNombre().equals(programa)) {
                programaRetorno = programas.get(i);
            }
        }

        return programaRetorno;
    }

    public DefaultComboBoxModel<String> getCodigosCursos(String programa) {
        DefaultComboBoxModel<String> cursos = new DefaultComboBoxModel<String>();
        for (int i = 0; i < programas.size(); i++) {
            if (programas.get(i).getNombre().equals(programa)) {
                cursos = programas.get(i).getModeloComboCursosPrograma();
                break;
            }
        }
        return cursos;
    }

    public ArrayList<String> getCodigosCursosArray(String programa) {
        ArrayList<String> cursosPrograma = new ArrayList<>();
        for (int i = 0; i < programas.size(); i++) {
            if (programas.get(i).getNombre().equals(programa)) {
                //System.out.println("EL PROGRAMA ES " + programas.get(i).getNombre());
                cursosPrograma.addAll(programas.get(i).getCodigosCursos());
            }
        }
        System.out.println(cursosPrograma);
        return cursosPrograma;

    }

    public String encontrarEstudiante(int codigo) {
        String nombre = "";
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCodigo() == codigo) {
                nombre = estudiantes.get(i).getNombres();
            }
        }
        return nombre;
    }

    //*********************************************
    // IMPORTANTE: Pueden requerirse más métodos.
    //*********************************************
    /**
     * ESTE APARTADO ES PARA CURSOESTUDIANTE Metodo para agregar estudiante. Se
     * debe modificar la lista de parámetros para incluir los atributos
     * necesarios para crear el objeto Estudiante.
     */
    public void crearCursoEstudiante(Estudiante estudiante) {
        CursoEstudiante curEst = new CursoEstudiante(estudiante);
        cursoEstudiantes.add(curEst);
    }

    public int encontrarCursoEstudiante(Estudiante estudiante) {
        int indice = -1;
        for (int i = 0; i < cursoEstudiantes.size(); i++) {
            if (cursoEstudiantes.get(i).getEstudiante().getCodigo() == estudiante.getCodigo()) {
                indice = i;
            }
        }
        return indice;
    }

    public void registrarEstudiante(String nombre, String correo, int codigo, long telefono, double promedio, int semestre) {
        // Crear el objeto
        Estudiante estudiante;

        // Asignar atributos
        estudiante = new Estudiante(nombre, correo, codigo, telefono, promedio, semestre);

        // Agregar a la lista
        estudiantes.add(estudiante);

    }

    public void desactivarEstudiante(int codigo) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCodigo() == codigo) {
                estudiantes.remove(i);
                break;
            }
        }
    }

    public void asignarNotaEstudiante(String estudiante, String codigoCurso, String programaNombre, String nota) {
        int estudianteCodigo = Integer.parseInt(estudiante);
        int curso = Integer.parseInt(codigoCurso);
        double notaEstudiante = Double.parseDouble(nota);
        Estudiante estudianteObj = estudiantes.get(buscarEstudiante(estudianteCodigo));
        estudianteObj.aniadirNota(curso, notaEstudiante);
    }

    /**
     * Metodo para agregar curso. Se debe modificar la lista de parámetros para
     * incluir los atributos necesarios para crear el objeto Curso.
     */
    public void agregarCurso(String programa, String nombre, String cod, String prom, String cap) {
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
        //cursos.add(curso);
    }

    public boolean desactivarCurso(String programa, String codigo) {
        boolean sePudo = false;
        ProgramaAcademico programaAcad;
        int codigoCurso = Integer.parseInt(codigo);
        if (buscarCurso(codigoCurso, programa).estudiantes == 0) {
            programaAcad = getPrograma(programa);
            programaAcad.removerCurso(codigoCurso);
            sePudo = true;
        }
        return sePudo;
    }

    /**
     * Metodo para matricular cursos. Se debe modificar la lista de parámetros
     * para incluir los atributos necesarios para cumplir el propósito.
     */
    public void matricular(String estudianteCod, String programa, String curso) {
        // Obtener el objeto Estudiante, comparándolo con el código 
        // pasado como parámetro

        int codigoEstudiante = Integer.parseInt(estudianteCod);
        int codigoCurso = Integer.parseInt(curso);

        ProgramaAcademico programaAcademico = getPrograma(programa);
        Estudiante estudiante = estudiantes.get(buscarEstudiante(codigoEstudiante));
        buscarCurso(codigoCurso, programa).getEstudiantesNombres().add(estudianteCod);

        estudiante.aniadirCurso(buscarCurso(codigoCurso, programa));

        // Buscar el curso, usando el código, dentro de la lista de 
        // programas académicos.
        // Asociar el curso a la lista de cursos del estudiante.
    }

    public void actualizarRequisito(String requisito, String codigo, String programa) {
        double requisitoPromedio = Double.parseDouble(requisito);
        int codigoCurso = Integer.parseInt(codigo);
        buscarCurso(codigoCurso, programa).actualizarRequisitoPromedio(requisitoPromedio);
    }

    public void actualizarCapacidad(String capacidad, String codigo, String programa) {
        int nuevaCapacidad = Integer.parseInt(capacidad);
        int capacidadCurso = Integer.parseInt(capacidad);
        int codigoCurso = Integer.parseInt(codigo);
        buscarCurso(codigoCurso, programa).actualizarCapacidad(nuevaCapacidad);

    }

    /**
     * Metodo para listar cursos matriculados. Se debe modificar la lista de
     * parámetros para incluir los atributos necesarios para cumplir el
     * propósito.
     */
    public String listarCursosMatriculados(String estudiante) {
        String cursos = "";
        int estudianteCodigo = Integer.parseInt(estudiante);
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCodigo() == estudianteCodigo) {
                cursos = estudiantes.get(i).getCursosCodNom();
            }
            return cursos;
        }
        // Se busca al estudiante
        // Se obtiene la lista de cursos
        // Se recorre la lista y se arma un String 
        // con el código y el nombre
        // Se retorna la nueva lista.
        return null;
    }

    public Curso buscarCurso(int codigo, String programa) {
        int indice = -1;
        ProgramaAcademico programaAcad = new ProgramaAcademico();
        ArrayList<String> cursosDelPrograma = new ArrayList<>();
        ArrayList<String> cursos = new ArrayList<>();

        programaAcad = getPrograma(programa);

        for (int i = 0; i < programaAcad.getCursos().size(); i++) {
            if (programaAcad.getCursos().get(i).getCodigo() == codigo) {
                indice = i;
            }
        }
        return programaAcad.getCursos().get(indice);
    }

    public int buscarEstudiante(int codigo) {
        int indice = -1;
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCodigo() == codigo) {
                indice = i;
            }
        }
        System.out.println("el estudiante está en la posicion " + indice);
        return indice;
    }

    public ArrayList<ProgramaAcademico> getProgramas() {
        return programas;
    }

    public void setProgramas(ArrayList<ProgramaAcademico> programas) {
        this.programas = programas;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    // public ArrayList<Curso> getCursos() {
    //     return cursos;
    // }
    // public void setCursos(ArrayList<Curso> cursos) {
    //    this.cursos = cursos;
    //}
}
