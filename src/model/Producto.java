package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import model.Categoria;

public class Producto { // Atributos de la clase
    private String nombreProducto;
    private double precioProducto;
	private Calendar fechaCaducidad;
	private String referencia;
	private int cantidad;
	private Categoria catProducto;

	// Metodo Constructor
    public Producto(String nombreProducto, 
					double precioProducto, 
					Calendar fechaCaducidad, 
					String referencia, 
					int cantidad, 
					Categoria catProducto) 
	{
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
		this.fechaCaducidad = fechaCaducidad;
		this.referencia = referencia;
		this.cantidad = cantidad;
		this.catProducto = catProducto;
    }
	
	// Setters y Getters
	
	public void setCategoria(Categoria categoria) {
		catProducto = categoria;
	}

	public Categoria getCategoria() {
		return catProducto;
	}
	
	public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
	
	public double getPrecio() {
        return precioProducto;
    }

    public void setPrecioProducto(double precioProducto) {
        this.precioProducto = precioProducto;
    }
	
	public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
	
	public Calendar getFechaCaducidad() {
		return fechaCaducidad;
	}
	
	public void setFechaCaducidad(Calendar fechaCaducidad) {
		this.fechaCaducidad = fechaCaducidad;
	}
	
	// Métodos útiles


}