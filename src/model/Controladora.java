package model;
import model.Tienda;

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

	

}