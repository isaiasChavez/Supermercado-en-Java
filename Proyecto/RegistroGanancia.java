package Proyecto;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class RegistroGanancia {

	public void insertarGanancia(ArrayList<Ganancia> listaGanancias,Ganancia ganancia) {
		
		listaGanancias.add(ganancia);
		
		
	}
	public void imprimirLista(ArrayList<Ganancia> listaGanancias) {
		
		Iterator<Ganancia> i = listaGanancias.iterator();
		
		if(!i.hasNext()) {
			System.out.println("La lista de ganancias está vacia.");
		}
		
		while(i.hasNext()) {
			Ganancia gananciaAImprimir = i.next();
			
			System.out.println(gananciaAImprimir);
			
		}
		
		
	}
	public void consultar(ArrayList<Ganancia> listaGanancias,Date fecha) {
		Iterator<Ganancia> i = listaGanancias.iterator();
		
		while(i.hasNext()) {
			Ganancia gananciaTemporal = i.next();
			if(gananciaTemporal.fecha.equals(fecha)) {
				System.out.println("La ganancia temporal encontrada fue la de " + gananciaTemporal.getFecha().getDate());}
				
			}
		}
		
	

	public void escribirArchivo(ArrayList<Ganancia> listaGanancias) {
		FileWriter fichero = null;
		PrintWriter impresor = null;
		
		try {
			fichero = new FileWriter("C:\\Users\\Isaías Chávez\\Documents\\ganancias.txt");
			impresor = new PrintWriter(fichero);
			
			Iterator<Ganancia> i = listaGanancias.iterator();
			Ganancia ganancia;
			
			while(i.hasNext()) {
				ganancia = i.next();
				impresor.println(ganancia.getIdGanancia()+"::"+ganancia.getVentaId()+"::"+ganancia.getFecha()+"::"+ganancia.getGanancia());
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
	public void leerArchivo(ArrayList<Ganancia> listaGanancias) {
		File archivo = null;
		Scanner lector = null;
		listaGanancias.clear();
		try {
			archivo = new File("C:\\Users\\Isaías Chávez\\Documents\\ganancias.txt");	
			lector = new Scanner(archivo);
			
			String linea;
			do {
				linea = lector.nextLine();
				if(linea!= null) {
				System.out.println(linea);
				String[] cortarString = linea.split("::");
				
				String[] fechaString = cortarString[2].split("-");
				
				Date i = new Date(Integer.parseInt(fechaString[0]),Integer.parseInt(fechaString[1]),Integer.parseInt(fechaString[2]));
				
				
				
				Ganancia gananciaArchivo = new Ganancia(Integer.parseInt(cortarString[0]),Integer.parseInt(cortarString[0]),i,Float.parseFloat(cortarString[1]));
				listaGanancias.add(gananciaArchivo);
				}
				
			} while (linea != null);
			
			
		} catch (Exception e) {
			// TODO: handle exception
			
		}
		
	}
}
