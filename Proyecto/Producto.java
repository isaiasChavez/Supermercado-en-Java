package Proyecto;

public class Producto {

	int idProducto;
	String nombre;
	int cantidad;
	float precioDeCompra;
	float precioDeVenta;
	
	
	public Producto(String nombre, int cantidad, float precioDeCompra, float precioDeVenta) {
		super();
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioDeCompra = precioDeCompra;
		this.precioDeVenta = precioDeVenta;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public int getCantidad() {
		return cantidad;
	}


	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}


	public float getPrecioDeCompra() {
		return precioDeCompra;
	}


	public void setPrecioDeCompra(float precioDeCompra) {
		this.precioDeCompra = precioDeCompra;
	}


	public float getPrecioDeVenta() {
		return precioDeVenta;
	}


	public void setPrecioDeVenta(float precioDeVenta) {
		this.precioDeVenta = precioDeVenta;
	}
	
		
	
}
