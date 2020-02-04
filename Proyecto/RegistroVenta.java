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
	public void atender(ArrayList<Venta> listaVentas , ArrayList<Ganancia> listaGanancias) {
		
		Iterator<Venta> i = listaVentas.iterator();
		
		Venta venta;
		
		Ganancia ganancias = new Ganancia();
		
		
		
		while(i.hasNext()) {
			System.out.println("----------------------------------------");
			venta = i.next();
			System.out.println("-----------------Datos de la venta:------------- ");
			
			System.out.println("Cliente:--------------- "+ venta.getCliente().getNombre());
			System.out.println("Cliente ID:--------------- "+venta.getCliente().getIdCliente());
			System.out.println("Productos: ");
			venta.imprimirCarrito();
			System.out.println("-----------------------------------------------");
			System.out.println("Venta total:--------------- "+ venta.getTotalVenta());
			
			ganancias.setFecha(venta.getFecha());// Aquí puede suceder un error
			ganancias.setVentaId(venta.getIdVenta());
			ganancias.setGanancia(venta.getTotalVenta() - venta.getTotalGanancias());
			ganancias.setIdGanancia(venta.idVenta);
			listaGanancias.add(ganancias);
			
			System.out.println("----------------------------------------");
			
			
		}
		
		listaVentas.clear();
		
		
		
	}
	
	
}
