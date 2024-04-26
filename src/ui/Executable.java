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
					+ "3. Eliminar tienda \n" + "4. Crear producto en tienda \n" + "5. Listar productos de Tienda \n" + "6. Crear objetos de prueba \n" + "7. Salir del programa \n");

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
						eliminarTienda();
						break;
					case 4:
						crearProductoEnTienda();
						break;
					case 5:
						listarProductosTienda();
						break;
					case 6:
						crearObjetosPrueba();
						break;
					case 7:
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

	public void eliminarTienda() {

		String nombreTienda;
		
		System.out.println("Ingrese nombre de la tienda a eliminar: ");

		nombreTienda = reader.nextLine();

		cont.eliminarTienda(nombreTienda);

		
		
	}

	public void crearProductoEnTienda() {

		String nombreTienda;
		
		System.out.println("Ingrese nombre de Tienda donde se creará el producto: ");

		nombreTienda = reader.nextLine();
		
		/*
		
		while(cont.busquedaNombreDeTienda(nombreTienda) == null) {
			System.out.println("Ingrese otro nombre de la tienda (no existe la tienda ingresada): ");
			
			nombreTienda = reader.nextLine();
		}
		*/

		String nombreProducto, strFechaCaducidad, referencia; 
		double precioProducto;
		int cantidad;

		System.out.println("Ingrese nombre del producto: ");

		nombreProducto = reader.nextLine();

		System.out.println("Ingrese fecha de caducidad del producto en formato dd-MM-yyyy: "); // Especificar formato de fecha SIEMPRE que sea posible

		strFechaCaducidad = reader.nextLine();

		System.out.println("Ingrese referencia del producto: ");

		referencia = reader.nextLine();

		System.out.println("Ingrese precio del producto: ");

		precioProducto = reader.nextDouble();

		System.out.println("Ingrese cantidad del producto: ");

		cantidad = reader.nextInt();

		cont.agregarYCrearProductoATienda(cont.busquedaNombreDeTienda(nombreTienda), nombreProducto, precioProducto, strFechaCaducidad, referencia, cantidad);

	}

	public void listarProductosTienda() {

		String nombreTienda;
		
		System.out.println("Ingrese nombre de Tienda a listar productos: ");

		nombreTienda = reader.nextLine();

		// Dado el nombre de la tienda que ingresó el usuario
		// En esa tienda, consulto la cantidad de productos que hay
		int cantidadProductos = cont.obtenerCantidadProductosDeTienda(cont.busquedaNombreDeTienda(nombreTienda));

		for(int i = 0; i <= cantidadProductos; i++) {
			String impresionProducto = cont.listarProductoDeTienda(cont.busquedaNombreDeTienda(nombreTienda), i);
			if(impresionProducto != "") {
				System.out.println("Producto " + (i+1) + ": "); 
				System.out.println(impresionProducto);
			} else {
				break;
			}
			
		}

	}
	
	public void crearObjetosPrueba() {
		// Ahora si debo referenciar a la controladora
		cont.crearObjetosDePrueba();
		System.out.println("Objetos creados");
	}


	
	



	

	
}