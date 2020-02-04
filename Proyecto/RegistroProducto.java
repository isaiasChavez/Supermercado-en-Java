package Proyecto;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Scanner;

public class RegistroProducto {

	private static int idProductos = 0;
	
	
	
	public int getIdProductos() {
		return idProductos;
	}

	public void insertar(ArrayList<Producto> listaProductos,Producto producto) {
		

		listaProductos.add(producto);
		idProductos++;
		System.out.println("Producto Ingresado correctamente"+"Id Actual " + idProductos);
	}
	

	public Producto buscarProducto(ArrayList<Producto> listaProductos,int idProducto) {
		
		Iterator<Producto> i = listaProductos.iterator();
		
		while(i.hasNext())
		{
			Producto e = i.next();
			
			if(e.getIdProducto() == idProducto) {
				return e;
			}		
		}
		return null;		
		
	}
	public boolean existe(ArrayList<Producto> listaProductos,int idProducto) {
		
		Iterator<Producto> i = listaProductos.iterator();
		
	
		while(i.hasNext()) {
			Producto  p = i.next();
			if(p.idProducto == idProducto)
			return true;

		}
		return false;
		
	}
	
	
	
	//

	public void imprimirLista(ArrayList<Producto> listaProductos) {
		
		
		Iterator<Producto> iterador = listaProductos.iterator();
		
		System.out.println("-----------------LISTA DE PRODUCTOS:-----------------------");
		while(iterador.hasNext()) {
			Producto productoDeLaLista = iterador.next();
			System.out.println(productoDeLaLista);
		}	
		
		System.out.println("-----------------.................-----------------------");
	}
	
	public void eliminar(ArrayList<Producto> listaProductos,Producto producto) {
		//EN OBRAS
	}
	
	
	public void escribirArchivo(ArrayList<Producto> listaProductos) {
		FileWriter fichero = null;
		PrintWriter impresor = null;
		
		try {
			fichero = new FileWriter("C:\\Users\\Isaías Chávez\\Documents\\productos.txt");
			impresor = new PrintWriter(fichero);
			
			Iterator<Producto> i = listaProductos.iterator();
			Producto producto;
			while(i.hasNext()) {
				producto = i.next();
				impresor.println(producto.getIdProducto()+"::"+producto.getNombre()+"::"+producto.getCantidad()+"::"+producto.getPrecioDeCompra()+"::" +producto.getPrecioDeVenta());
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
	public void leerArchivo(ArrayList<Producto> listaProductos) {
		File archivo = null;
		Scanner lector = null;
		listaProductos.clear();
		try {
			archivo = new File("C:\\Users\\Isaías Chávez\\Documents\\productos.txt");	
			lector = new Scanner(archivo);
			String linea;
			do {
				linea = lector.nextLine();
				if(linea!= null) {

				String[] cortarString = linea.split("::");
				Producto productoArchivo = new Producto(Integer.parseInt(cortarString[0]),cortarString[1],Integer.parseInt(cortarString[2]),Float.parseFloat(cortarString[3]),Float.parseFloat(cortarString[4]));
				listaProductos.add(productoArchivo);
				}
				
			} while (linea != null);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
	
}
