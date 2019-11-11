package Proyecto;

import java.util.ArrayList;

import java.util.Iterator;



public class RegistroCliente {
	

	public void insertar( ArrayList<Cliente> listaClientes,Cliente cliente) {
		
		listaClientes.add(cliente);
		
	}
	
	public Cliente buscarCliente(ArrayList<Cliente> listaClientes,int idCliente) {
		
		Cliente clienteBuscado;
		clienteBuscado = listaClientes.get(idCliente);
		if(clienteBuscado != null) {
			return clienteBuscado;
		}
		else {
			System.out.println("No se encontraron coincidencias.");
			return null;
		}
		
	}
	
	public void imprimirLista(ArrayList<Cliente> listaClientes) {
		
		Iterator<Cliente> iterador = listaClientes.iterator();
		
		while(iterador.hasNext()){	
			Cliente clientito =  iterador.next();		
			System.out.println(clientito.toString());
		}
		
		
	}
	public void eliminar( ArrayList<Cliente> listaClientes,Cliente cliente) {
		if(listaClientes.contains(cliente)) {
			listaClientes.remove(listaClientes.contains(cliente));
		}else {
			System.out.println("No se encontraron ocurrencias.");
		}
		
			
			
			
	}
	public void escribirArchivo(ArrayList<Cliente> lista) {
		
	}
	public void leerDeArchivo(ArrayList<Cliente> lista) {
		
	}
	
	
}
