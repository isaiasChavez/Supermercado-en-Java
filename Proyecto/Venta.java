package Proyecto;

import java.sql.Date;
import java.util.ArrayList;

public class Venta {

	int idVenta;
	Cliente cliente;
	ArrayList<Producto> carritoProducto;
	float totalVenta;
	Date fecha;
	
	public Venta(Cliente cliente, ArrayList<Producto> carritoProducto, float totalVenta, Date fecha) {
		super();
		this.cliente = cliente;
		this.carritoProducto = carritoProducto;
		this.totalVenta = totalVenta;
		this.fecha = fecha;
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
		this.carritoProducto = carritoProducto;
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
