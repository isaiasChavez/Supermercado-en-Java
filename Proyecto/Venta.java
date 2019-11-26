package Proyecto;

import java.sql.Date;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.Iterator;

public class Venta {

	int idVenta;
	Cliente cliente;
	ArrayList<Producto> carritoProducto;
	float totalVenta;
	Date fecha;
	
	public Venta( int idVenta,Cliente cliente, ArrayList<Producto> carritoProducto, float totalVenta, Date fecha) {
		super();
		this.idVenta = idVenta;
		this.cliente = cliente;
		this.carritoProducto = carritoProducto;
		this.totalVenta = totalVenta;
		this.fecha = fecha;
	}
	public Venta() {
		
	}
	
	
	

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public ArrayList<Producto> getCarritoProducto() {
		return carritoProducto;
	}

	public void setCarritoProducto(ArrayList<Producto> carritoProducto) {
		
		java.util.Iterator<Producto> i = carritoProducto.iterator();
		
	
		
		while(i.hasNext()) {
			Producto j = i.next();
			this.totalVenta += j.precioDeVenta;
		}
		
		this.carritoProducto = carritoProducto;
	}
	
	public void imprimirCarrito() {
		java.util.Iterator<Producto> i = carritoProducto.iterator();
		
		while(i.hasNext()) {
			Producto j = i.next();
			System.out.println("Nombre: " + j.nombre + " Cantidad: " +j.cantidad );
		}
		
		
	}
	

	public float getTotalVenta() {
		return totalVenta;
	}

	public void setTotalVenta(float totalVenta) {
		this.totalVenta = totalVenta;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	


	
	
}
