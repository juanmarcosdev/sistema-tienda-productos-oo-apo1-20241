package ui;

import java.util.Scanner;
import model.Controladora;

public class Executable {

	// Atributos de la clase Ejecutable
	private Scanner reader;
	private Controladora cont;
	private static boolean flag;

	private Executable() {
		reader = new Scanner(System.in);
		cont = new Controladora();
	}
	
	

	public void run(boolean flag)
	{

		flag = false;

		while (!flag) {

			System.out.println("\n \n Bienvenido al menu:\n");
			System.out.println("Opciones:\n" + "1. Registrar estudiante \n" + "2. Imprimir estudiantes\n"
					+ "3. Crear semestre a estudiante \n" + "4. Mostrar semestres de un estudiante \n" + "5. Salir del programa \n");

			int option = reader.nextInt();

			reader.nextLine();

			switch (option) {
					case 1:
						registrarEstudiante();
						break;
					case 2:
						imprimirEstudiantes();
						break;
					case 3:
						crearSemestreAEstudiante();
						break;
					case 4:
						imprimirSemestresDeEstudiante();
						break;
					case 5:
						flag = true;
						System.exit(0);
						break;
					default:
						System.out.print("Por favor ingrese una opcion valida");
						continue;
			}

		}

	}

	public static void main(String[] args) {
		Executable mainApp = new Executable();
		mainApp.run(flag);
	}

	public void registrarEstudiante() {
		
		String nombreEstudiante, codigoEstudiante;
		int edadEstudiante;
		
		System.out.println("Ingrese nombre del estudiante: ");
		
		nombreEstudiante = reader.nextLine();
		
		System.out.println("Ingrese edad del estudiante: ");
		
		edadEstudiante = reader.nextInt();
		
		reader.nextLine(); // Limpiar el buffer
		
		System.out.println("Ingrese codigo del estudiante: ");
		
		codigoEstudiante = reader.nextLine();
		
		//System.out.println("Datos del estudiante: \n" + 
		//"Nombre: " + nombreEstudiante + "\n" + 
		//"Edad: " + edadEstudiante + "\n" + 
		//"Codigo: " + codigoEstudiante);
		
		
		cont.agregarEstudiante(cont.crearEstudiante(nombreEstudiante, edadEstudiante, codigoEstudiante));
	}

	public void imprimirEstudiantes() {

		int cantidadEstudiantes = cont.obtenerCantidadEstudiantes();

		for(int i = 0; i <= cantidadEstudiantes; i++) {
			String impresionEstudiante = cont.listarEstudiante(i);
			if(impresionEstudiante != "") {
				System.out.println("Estudiante " + (i+1) + ": "); 
				System.out.println(impresionEstudiante);
			} else {
				break;
			}
			
		}
		
	}

	public void crearSemestreAEstudiante() {

		String codigoEstudiante;


		System.out.println("Ingrese el codigo del estudiante al que le vamos a crear el semestre: ");

		codigoEstudiante = reader.nextLine();

		String nombrePeriodoSemestre;

		System.out.println("Ingrese el nombre del periodo del semestre: ");

		nombrePeriodoSemestre = reader.nextLine();

		cont.asociarSemestreConEstudiante(cont.buscarEstudiantePorCodigo(codigoEstudiante), cont.crearSemestre(nombrePeriodoSemestre));



	}

	public void imprimirSemestresDeEstudiante() {

		String codigoEstudiante;

		System.out.println("Ingrese el codigo del estudiante al que le vamos a averiguar el semestre: ");

		codigoEstudiante = reader.nextLine();



		for(int i = 0; i <= cont.buscarEstudiantePorCodigo(codigoEstudiante).cuantosSemestres(); i++) {
			String impresionEstudiante = cont.listarSemestre(i, cont.buscarEstudiantePorCodigo(codigoEstudiante));
			if(impresionEstudiante != "") {
				System.out.println(impresionEstudiante);
			} else {
				break;
			}
			
		}
		
	}



	

	
}