package model;
import model.Tienda;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Controladora {
    private Tienda[] tiendas;

    public Controladora() {
        this.tiendas = new Tienda[2];
    }
	
	// Controladora: encargada de gestión de entidades del modelo
	// QUE se comunican con ella. Gestión: crear, modificar, eliminar.
	
	// Método que crea una Tienda a partir de sus datos base
	
	// Método empaquetador 
	
	public Tienda crearTienda(String nombreTienda, String direccion, String codigoPostal) {
		// Instanciación de una nueva Tienda
		Tienda tienda = new Tienda(nombreTienda, direccion, codigoPostal);
    	return tienda;
    }
	
	// Método agregarTienda deberia trabajar en conjunto con el anterior
	// para GUARDAR o AGRUPAR tiendas CREADAS en el arreglo interno
	// de Tiendas de la Controladora.
	
	public void agregarTienda(Tienda tienda) {
        for (int i = 0; i < tiendas.length; i++) {
            if (tiendas[i] == null) {
                tiendas[i] = tienda;
                break;
            }
        }
    }
	
	// Método que recorre el arreglo de Tiendas
	// revisando si cada espacio que puede ser ocupado por una Tienda
	// está verdaderamente ocupado 
	// en otras palabras, nos devuelve la verdadera cantidad de tiendas actualmente.
	
	public int obtenerCantidadTiendas() {
		int contadorDeTiendasVerdaderas = 0;
		for (int i = 0; i < tiendas.length; i++) {
            if (tiendas[i] != null) {
                contadorDeTiendasVerdaderas++;
            }
        }
		return contadorDeTiendasVerdaderas;
	}
	
	// Dado el indice de una tienda, nos devuelve un String con su información básica
	
	public String listarTienda(int indice) {
        if (indice >= 0 && indice < tiendas.length && tiendas[indice] != null) {
            Tienda tienda = tiendas[indice];
            return "Nombre de la Tienda: " + tienda.getNombreTienda() + "\n" +
                   "Direccion: " + tienda.getDireccion() + "\n" +
                   "Código Postal: " + tienda.getCodigoPostal();
        } else {
            return "";
        }
    }
	
	// Método que recorra todas las Tiendas revisando
	// si existe una Tienda con un nombre dado
	// retorna true si existe una Tienda con ese nombre
	// false si no existe Tienda con el nombre dado
	
	public boolean chequeoNombreDeTienda(String nombrePosible) {
		boolean existe = false;
		for (int i = 0; i < tiendas.length; i++) {
            if (tiendas[i] != null) {
				existe = tiendas[i].getNombreTienda().equalsIgnoreCase(nombrePosible);
            }
        }
		return existe;
	}

	public void eliminarTienda(String nombreTiendaAEliminar) {
		for (int i = 0; i < tiendas.length; i++) {
            if (tiendas[i] != null) {
				if(tiendas[i].getNombreTienda().equalsIgnoreCase(nombreTiendaAEliminar)) {
					tiendas[i] = null;
				}
            }
        }
	}
	
	// A partir de un nombre de una tienda (debe de existir), me retorna con la Tienda

	public Tienda busquedaNombreDeTienda(String nombrePosible) {
		Tienda tiendaARetornar = null;
		for (int i = 0; i < tiendas.length; i++) {
            if (tiendas[i] != null && tiendas[i].getNombreTienda().equalsIgnoreCase(nombrePosible)) {
				tiendaARetornar = tiendas[i];
            }
        }
		return tiendaARetornar;
	}

	// Este metodo recibe como entrada una Tienda, que será la tienda que identificaremos con su nombre
	// y esta Tienda sera quien reciba el producto a crear.
	// Lo demás que recibe son los datos necesarios para crear un objeto de tipo Producto.
	public void agregarYCrearProductoATienda(Tienda tienda, String nombreProducto, double precioProducto, String strFechaCaducidad, String referencia, int cantidad) {

		// Declaramos una variable que será de tipo DateFormat (debe estar importado)
		// DateFormat es util para establecer un formato de fecha específico.
		DateFormat formateador = new SimpleDateFormat("dd-MM-yyyy");
		// Crear un objeto de tipo Calendar. Este tendrá el calendario Gregoriano.
		Calendar calendario = new GregorianCalendar();
		// Lo que haremos con este objeto de tipo Calendario
		// será asociarlo a la fecha ingresada por el usuario.

		// Try-Catch es una instrucción que sirve para manejar errores.
		try {

			// Creamos una variable de tipo Date que estará asociada al String de la fecha caducidad
			// que ingresó el usuario.
			Date fecha = formateador.parse(strFechaCaducidad);

			// Asociar mi variable de tipo Calendar con la Fecha (Date) del usuario.
			calendario.setTime(fecha);

        } catch (ParseException error) {
            error.printStackTrace(); // Impresión de error manual
        }


		tienda.agregarProducto(tienda.crearProducto(nombreProducto, precioProducto, calendario, referencia, cantidad));

	}
	
	// 

	public int obtenerCantidadProductosDeTienda(Tienda tienda) {
		return tienda.obtenerCantidadProductos();
	}

	public String listarProductoDeTienda(Tienda tienda, int indice) {
		return tienda.listarProducto(indice);
	}
	
	public void crearObjetosDePrueba() {
		// Voy a crear una Tienda por defecto, como Tienda comunica con la Controladora
		// Me apoyo en los mismos métodos que ya tengo para realizarlo
		// Al llamar métodos de la controladora dentro de la misma controladora, no debo especificar 
		// "cont" o una variable donde esté controladora, pues ya me encuentro en la controladora.
		agregarTienda(crearTienda("JPGR", "Cra 100 # 16-321", "760039"));
		agregarTienda(crearTienda("D1", "Cra 125 #18-100", "760017"));
		// Vamos a buscar una tienda en especifico (JPGR), y con ella crearemos productos
		Tienda tiendaALaQueLeAgregareProductos = busquedaNombreDeTienda("D1");
		/*
		agregarYCrearProductoATienda(tiendaALaQueLeAgregareProductos, "Yogurt Griego Uchuva", 3400.0, "04-11-2024", "AX8973", 5);
		agregarYCrearProductoATienda(tiendaALaQueLeAgregareProductos, "Yogurt Griego Frutos Rojos", 3600.0, "27-10-2024", "AX4873", 3);
		*/
		String nombreProducto = "Producto "
		double precioProducto = 2000.0;
		String referenciaBase = "AX8973";
		for(int i = 0; i < 3; i++) {
			nombreProducto += (i+1);
			agregarYCrearProductoATienda(tiendaALaQueLeAgregareProductos, nombreProducto, precioProducto, "04-11-2024", referenciaBase, i+1);
			precioProducto += 500.0;
			referenciaBase = referenciaBase + (i+1);
		}
	}

	

}