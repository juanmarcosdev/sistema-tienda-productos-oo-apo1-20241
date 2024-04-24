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
			System.out.println("Opciones:\n" + "1. Crear tienda \n" + "2. Mostrar tiendas \n"
					+ "3. \n" + "4.  \n" + "5. Salir del programa \n");

			int option = reader.nextInt();

			reader.nextLine();

			switch (option) {
					case 1:
						crearTienda();
						break;
					case 2:
						imprimirTiendas();
						break;
					case 3:
						//crearSemestreAEstudiante();
						break;
					case 4:
						//imprimirSemestresDeEstudiante();
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
	
	public void crearTienda() {
		
		// Siendo consistente con los datos base que necesita Tienda
		String nombreTienda, direccion, codigoPostal;
		
		System.out.println("Ingrese nombre de la tienda: ");
		
		nombreTienda = reader.nextLine();
		
		while(cont.chequeoNombreDeTienda(nombreTienda)) {
			System.out.println("Ingrese otro nombre de la tienda (el anterior ya tomado): ");
			
			nombreTienda = reader.nextLine();
		}
		
		// reader.nextLine(); // Limpiar el buffer
		
		System.out.println("Ingrese direccion de la tienda: ");
		
		direccion = reader.nextLine();
		
		System.out.println("Ingrese codigo postal de la tienda: ");
		
		codigoPostal = reader.nextLine();
		
		// Nos comunicamos con la controladora para crear tienda
		
		cont.agregarTienda(cont.crearTienda(nombreTienda, direccion, codigoPostal));
	
	}
	
	public void imprimirTiendas() {

		int cantidadTiendas = cont.obtenerCantidadTiendas();

		for(int i = 0; i <= cantidadTiendas; i++) {
			String impresionTienda = cont.listarTienda(i);
			if(impresionTienda != "") {
				System.out.println("Tienda " + (i+1) + ": "); 
				System.out.println(impresionTienda);
			} else {
				break;
			}
			
		}
		
	}


	
	



	

	
}