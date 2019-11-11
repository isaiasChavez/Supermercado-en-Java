package Proyecto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class RegistroGanancia {

	public void insertarGanancia(ArrayList<Ganancia> listaGanancias,Ganancia ganancia) {
		
		listaGanancias.add(ganancia);
		
		
	}
	public void imprimirLista(ArrayList<Ganancia> listaGanancias) {
		
		Iterator<Ganancia> i = listaGanancias.iterator();
		
		while(i.hasNext()) {
			Ganancia gananciaAImprimir = i.next();
			System.out.println(i.toString());
		}
		
		
	}
	public void consultar(ArrayList<Ganancia> listaGanancias,Date fecha) {
		
	}
	public void escribirArchivo(ArrayList<Ganancia> listaGanancias) {
		
	}
	public void leerArchivo(ArrayList<Ganancia> listaGanancias) {
		
	}
}
