package model;
import model.Producto;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Tienda { // Atributos de la clase
    private String nombreTienda;
    private String direccion;
	private String codigoPostal;
	private Producto[] productos;

    public Tienda(String nombreTienda, String direccion, String codigoPostal) { // Constructor
		this.nombreTienda = nombreTienda;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.productos = new Producto[5]; // Instanciación de arreglo de productos, esto permite que luego más tarde podamos agregar productos, inicialmente habrán 5 espacios en nulo que permite objetos de tipo Producto
    }
	
	// Getters y Setters
	
	public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }
	
	public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
	
	public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
	
	public Producto[] getProductos() {
        return productos;
    }

    public void setProductos(Producto[] productos) {
        this.productos = productos;
    }
	
	// Métodos útiles
	
	// Método que crea un Producto a partir de sus datos base
	
	// Método empaquetador 
	
	public Producto crearProducto(String nombreProducto, 
					double precioProducto, 
					Calendar fechaCaducidad, 
					String referencia, 
					int cantidad) {
		// Instanciación de un nuevo Producto
		Producto producto = new Producto(nombreProducto, 
					precioProducto, 
					fechaCaducidad, 
					referencia, 
					cantidad);
    	return producto;
    }
	
	
	
	public void agregarProducto(Producto producto) {
        for (int i = 0; i < productos.length; i++) {
            if (productos[i] == null) {
                productos[i] = producto;
                break;
            }
        }
    }

    public int obtenerCantidadProductos() {
		int contadorDeProductosVerdaderos = 0;
		for (int i = 0; i < productos.length; i++) {
            if (productos[i] != null) {
                contadorDeProductosVerdaderos++;
            }
        }
		return contadorDeProductosVerdaderos;
	}

	public String listarProducto(int indice) {

		DateFormat formateador = new SimpleDateFormat("dd/M/yy");

        if (indice >= 0 && indice < productos.length && productos[indice] != null) {
            Producto producto = productos[indice];
            return "Nombre del Producto: " + producto.getNombreProducto() + "\n" +
            		"Fecha de caducidad" + formateador.format(producto.getFechaCaducidad().getTime()) + "\n";
        } else {
            return "";
        }
    }
	
	


}