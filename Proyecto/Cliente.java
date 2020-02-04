package Proyecto;

public class Cliente {

	int idCliente;
	String nombre;
	String direccion;
	
	public Cliente(int idCliente, String nombre, String direccion) {
		super();
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.direccion = direccion;
	}
	public Cliente() {
		
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente =  idCliente;
	}

	public int getIdCliente() {
		return idCliente;
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	@Override
	public String toString() {
		return "ID:"+ this.getIdCliente() + "Nombre: "+this.getNombre()+"Dirección: "+this.getDireccion();
	}
	
}

