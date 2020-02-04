package Proyecto;

public class Producto {

	int idProducto;
	String nombre;
	int cantidad;
	float precioDeCompra;
	float precioDeVenta;
	
	public Producto() {
		
	}
	public Producto(int id,String nombre, int cantidad, float precioDeCompra, float precioDeVenta) {
		super();
		this.idProducto= id;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precioDeCompra = precioDeCompra;
		this.precioDeVenta = precioDeVenta;
	}
	

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}
	public int getIdProducto() {
		return idProducto;
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
	
		
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "ID: " + this.idProducto + "Nombre: " + this.nombre +" Cantidad: "+ this.cantidad + "Precio de venta: "+this.precioDeVenta; 
	}
	
}
