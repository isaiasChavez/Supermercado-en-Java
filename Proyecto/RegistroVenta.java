package Proyecto;

import java.util.ArrayList;
import java.util.Iterator;

public class RegistroVenta {

	public void insertarVenta(ArrayList<Venta> listaVentas,Venta venta) {
		listaVentas.add(venta);
	}
	public void imprimirLista(ArrayList<Venta> listaVentas) {
		
		
		Iterator<Venta> iterador = listaVentas.iterator();
		
		if(!iterador.hasNext()) {
			System.out.println("La cola está vacia.");
		}
		while(iterador.hasNext()){	
			Venta ventita =  iterador.next();		
			System.out.println("Nombre del cliente: "+ ventita.getCliente().nombre + " Venta total: " + ventita.getTotalVenta());
			System.out.println("Productos del cliente: ");
			ventita.imprimirCarrito();	
			
		}
		
	}
	public void atender(ArrayList<Venta> listaVentas) {
		
		
	}
	
	
}
