package Proyecto;

import java.util.ArrayList;
import java.util.Iterator;

public class RegistroVenta {

	public void insertarVenta(ArrayList<Venta> listaVentas,Venta venta) {
		listaVentas.add(venta);
	}
	public void imprimirLista(ArrayList<Venta> listaVentas) {
		
		
		Iterator<Venta> iterador = listaVentas.iterator();
		
		while(iterador.hasNext()){	
			Venta ventita =  iterador.next();		
			System.out.println(ventita.toString());
		}
		
	}
	public void atender(ArrayList<Venta> listaVentas) {
		
		
		
	}
	
	
}
