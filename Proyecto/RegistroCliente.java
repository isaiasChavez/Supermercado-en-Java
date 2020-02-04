package Proyecto;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Scanner;



public class RegistroCliente {
	

	public void insertar( ArrayList<Cliente> listaClientes,Cliente cliente) {
		
		listaClientes.add(cliente);
		System.out.println("Se ha ingresado el cliente con id: "+ cliente.getIdCliente());
		System.out.println("----------------------------------------");
	}
	
	public Cliente buscarCliente(ArrayList<Cliente> listaClientes,int idCliente) {
		
		Cliente clienteBuscado;
		
		Iterator<Cliente> i = listaClientes.iterator();
		
		while(i.hasNext()) {
			
			clienteBuscado = i.next();
			if(clienteBuscado.idCliente == idCliente) {
				return clienteBuscado;
			}
		}
		
		return null;
		
	}
	
	public void imprimirLista(ArrayList<Cliente> listaClientes) {
		System.out.println("---------LISTA DE CLIENTES------------");
		
		Iterator<Cliente> iterador = listaClientes.iterator();
		while(iterador.hasNext()){	
			Cliente clienteLista =  iterador.next();		
			System.out.println(clienteLista);
		}
		System.out.println("---------...............------------");
		
		
	}
	public void eliminar( ArrayList<Cliente> listaClientes,Cliente cliente) {
		
		if(listaClientes.contains(cliente)) {
			listaClientes.remove(cliente);
			System.out.println("La posicion es: "+ cliente);
			
			
		}else {
			System.out.println("No se encontraron ocurrencias.");
		}
					
	}
	public void escribirArchivo(ArrayList<Cliente> lista) {
		FileWriter fichero = null;
		PrintWriter impresor = null;
		
		try {
			fichero = new FileWriter("C:\\Users\\Isaías Chávez\\Documents\\clientes.txt");
			impresor = new PrintWriter(fichero);
			
			Iterator<Cliente> i = lista.iterator();
			Cliente cliente;
			while(i.hasNext()) {
				cliente = i.next();
				impresor.println(cliente.getIdCliente()+"::"+cliente.getDireccion()+"::"+cliente.getNombre());
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(fichero !=  null) {
					fichero.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		
	}
	public void leerDeArchivo(ArrayList<Cliente> lista) {
		
		File archivo = null;
		Scanner lector = null;
		lista.clear();
		try {
			archivo = new File("C:\\Users\\Isaías Chávez\\Documents\\clientes.txt");	
			lector = new Scanner(archivo);
			
			String linea;
			do {
				linea = lector.nextLine();
				if(linea!= null) {
				System.out.println(linea);
				String[] cortarString = linea.split("::");
				Cliente clienteArchivo = new Cliente(Integer.parseInt(cortarString[0]),cortarString[2],cortarString[1]);
				lista.add(clienteArchivo);
				}
				
			} while (linea != null);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
		
		
		
		
	}
	
	
}
