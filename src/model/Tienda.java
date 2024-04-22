package model;

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
	
	// Métodos útiles


}