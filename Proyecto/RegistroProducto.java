package Proyecto;

import java.util.ArrayList;

import java.util.Iterator;

public class RegistroProducto {

	public void insertar(ArrayList<Producto> listaProductos,Producto producto) {
		listaProductos.add(producto);
	}
	
	public Producto buscarProducto(ArrayList<Producto> listaProductos,int idProducto) {
		
		if(listaProductos.get(idProducto) != null) {
			return listaProductos.get(idProducto);
			
		}else {
		return null;
		}
		
		
		
	}
	
	public void imprimirLista(ArrayList<Producto> listaProductos) {
		
		Iterator<Producto> iterador = listaProductos.iterator();
		
		while(iterador.hasNext()) {
			Producto productito = iterador.next();
			System.out.println(productito.toString());			
		}
		
		
	}
	public void eliminar(ArrayList<Producto> listaProductos,Producto producto) {
		
	}
	public void escribirArchivo(ArrayList<Producto> listaProductos) {
		
	}
	public void leerArchivo(ArrayList<Producto> listaProductos) {
		
	}
	
}
