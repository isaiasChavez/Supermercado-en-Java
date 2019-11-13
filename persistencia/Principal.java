package persistencia;

import java.util.ArrayList;
import java.util.Scanner;

import Proyecto.Ganancia;
import Proyecto.Producto;
import Proyecto.RegistroGanancia;
import Proyecto.RegistroProducto;

public class Principal {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		RegistroGanancia registroDeGanancias = new RegistroGanancia();
		ArrayList<Ganancia> listaPrincipalDeGanancias = new ArrayList<Ganancia>();
		registroDeGanancias.leerArchivo(listaPrincipalDeGanancias);
		
		
		RegistroProducto registroDeProductos = new RegistroProducto();
		ArrayList<Producto> listaPrincipalDeProductos = new ArrayList<Producto>();
		registroDeProductos.leerArchivo(listaPrincipalDeProductos);
		
		
		
		
		String respuesta="";
		Principal p = new Principal();
		
		
		
		while(respuesta!=  "0" ) {
			
			
		p.imprimirMenu();
		respuesta = sc.nextLine();
		switch (respuesta) {
		case "1"://AGREGAR PRODUCTO
			Producto productoTemporal = new Producto();
			System.out.println("Ingrese los datos del producto");
	
			System.out.println("Ingrese un nombre para el producto");
			productoTemporal.setNombre(sc.nextLine());
			System.out.println("Ingrese un id para el producto");
			productoTemporal.setIdProducto(sc.nextInt());
			System.out.println("Ingrese una cantidad para el producto");
			productoTemporal.setCantidad(sc.nextInt());
			System.out.println("Ingrese un precio de compra para el producto");
			productoTemporal.setPrecioDeCompra(sc.nextFloat());
			System.out.println("Ingrese un precio de venta");
			productoTemporal.setPrecioDeVenta(sc.nextFloat());
			
			registroDeProductos.insertar(listaPrincipalDeProductos,productoTemporal);
			break;
		case "2": //BAJA
			System.out.println("Respuesta 2");
			break;
		case "3": //MODIFICAR
			System.out.println("Respuesta 3");
			break;
		case "4"://IMPRIMIR
			System.out.println("Respuesta 4");
			registroDeProductos.imprimirLista(listaPrincipalDeProductos);
			break;
		case "5": //SALVAR DATOS
			registroDeProductos.escribirArchivo(listaPrincipalDeProductos);
			System.out.println("Salvados");
			break;
		case"20":
			System.out.println("Salvando los datos");
			
			registroDeProductos.escribirArchivo(listaPrincipalDeProductos);
			registroDeGanancias.escribirArchivo(listaPrincipalDeGanancias);
			
		case"0":
			System.out.println("Salida");
		default:
			System.out.println("Respuesta inválida");
			break;
		}
	
		
		}
		
		
		
		
		
	}
	
	
	
	public void imprimirMenu() {
		System.out.println("|1| Dar de alta un producto.");
		System.out.println("|2| Dar de baja un producto.");
		System.out.println("|3| Modificar un producto.");
		System.out.println("|4| Imprimir los productos.");
		System.out.println("|5| Salvar los datos de productos.");
		
		System.out.println("GESTIÓN DE GANANCIA");
		System.out.println("Listar ganancias");
		System.out.println("Consultar ganancias por id");
		
		
		
		
		
		System.out.println("|20| Salvar todos los datos.");
		
		
		
		
		System.out.println("|0| Salir");
	}
}
