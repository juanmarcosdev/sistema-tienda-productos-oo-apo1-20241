package model;
import model.*;

public class Controladora {
    private Estudiante[] estudiantes;

    public Controladora() {
        this.estudiantes = new Estudiante[29];
    }

    public Profesor crearProfesor(String nombre, int edad, String cedula) {
    	Profesor profesor = new Profesor(nombre, edad, cedula);
    	return profesor;
    }

    public Curso crearCurso(String nombreCurso, int notaObtenida, int creditos, String facultad) {
    	Curso curso = new Curso(nombreCurso, notaObtenida, creditos, facultad);
    	return curso;
    }

    public Semestre crearSemestre(String nombrePeriodo) {
    	Semestre semestre = new Semestre(nombrePeriodo);
    	return semestre;
    }

    public void asociarCursoConSemestre(Curso curso, Semestre semestre) {
    	semestre.agregarCurso(curso);
    }

    public Estudiante crearEstudiante(String nombre, int edad, String codigoEstudiante) {
    	Estudiante estudiante = new Estudiante(nombre, edad, codigoEstudiante);
    	return estudiante;
    }

    public void agregarEstudiante(Estudiante estudiante) {
        for (int i = 0; i < estudiantes.length; i++) {
            if (estudiantes[i] == null) {
                estudiantes[i] = estudiante;
                break;
            }
        }
    }

    public void asociarSemestreConEstudiante(Estudiante estudiante, Semestre semestre) {
    	estudiante.agregarSemestre(semestre);
    }

    public void asociarCursoConProfesor(Curso curso, Profesor profesor) {
        curso.setProfesor(profesor);
    }

    public String listarEstudiante(int indice) {
        if (indice >= 0 && indice < estudiantes.length && estudiantes[indice] != null) {
            Estudiante estudiante = estudiantes[indice];
            return "Nombre: " + estudiante.getNombre() + "\n" +
                   "Edad: " + estudiante.getEdad() + "\n" +
                   "Código de Estudiante: " + estudiante.getCodigoEstudiante();
        } else {
            return "";
        }
    }

    public int obtenerCantidadEstudiantes() {
        return estudiantes.length;
    }

    public Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante estudiante : estudiantes) { // Recorrido de objetos, "objeto por objeto"
            if (estudiante != null && estudiante.getCodigoEstudiante().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }

    public String listarSemestre(int indice, Estudiante estudiante) {
        Semestre[] semestresEstudiante = estudiante.getSemestres();
        if (indice >= 0 && indice < estudiante.getSemestres().length && semestresEstudiante[indice] != null) {
            Semestre semestre = semestresEstudiante[indice];
            return "Nombre del periodo: " + semestre.getNombrePeriodo();
        } else {
            return "";
        }
    }
	

}