package persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import Proyecto.Cliente;
import Proyecto.Ganancia;
import Proyecto.Producto;
import Proyecto.RegistroCliente;
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
		
		RegistroCliente registroDeClientes = new RegistroCliente();
		ArrayList<Cliente> listaPrincipalDeClientes = new ArrayList<Cliente>();
		registroDeClientes.leerDeArchivo(listaPrincipalDeClientes);

		
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
		case "3": //IMPRIMIR PRODUCTOS
			registroDeProductos.imprimirLista(listaPrincipalDeProductos);
			break;
		case "4"://ALTA CLIENTES
			
			Cliente clienteTemporal = new Cliente();
			
			System.out.println("Ingrese los datos del cliente");
			System.out.println("Ingrese un id par el cliente: ");
			clienteTemporal.setIdCliente(sc.nextInt());
			System.out.println("Ingrese el nombre del cliente:");
			clienteTemporal.setNombre(sc.nextLine());
			System.out.println("Ingrese un dirección para el cliente: ");
			clienteTemporal.setDireccion(sc.nextLine());
			
			break;
		case "5": //LISTAR CLIENTES
			System.out.println("LISTA DE CLIENTES");
			registroDeClientes.imprimirLista(listaPrincipalDeClientes);
			
			break;
		case "6": //ELIMINAR CLIENTES
			registroDeProductos.escribirArchivo(listaPrincipalDeProductos);
			System.out.println("Salvados");
			break;
		case "7": //INSERTAR CLIENTE A LA COLA
			registroDeProductos.escribirArchivo(listaPrincipalDeProductos);
			System.out.println("Salvados");
			break;
		case "8": //LISTAR COLA DE CLIENTES
			registroDeProductos.escribirArchivo(listaPrincipalDeProductos);
			System.out.println("Salvados");
			break;
		case "9": //ATENDER CLIENTES
			registroDeProductos.escribirArchivo(listaPrincipalDeProductos);
			System.out.println("Salvados");
			break;
		case "10": //LISTAR GANANCIAS
			registroDeGanancias.imprimirLista(listaPrincipalDeGanancias);
			
			break;
		case "11": //CONSULTAR GANANCIA POR ID
			
			int dia,mes,ano;
			
			System.out.println("Ingrese la fecha de la ganancia que desea consultar: ");
			System.out.println("Ingrese el día: ");
			dia = sc.nextInt();
			System.out.println("Ingrese el mes: ");
			mes = sc.nextInt();
			System.out.println("Ingrese el año: ");
			ano = sc.nextInt();
			Date fechaAConsultar = new Date(ano,mes,dia);
			registroDeGanancias.consultar(listaPrincipalDeGanancias, fechaAConsultar);
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
		System.out.println("|3| Imprimir los productos.");
		System.out.println("GESTIÓN DE CARTERA DE CLIENTES");
		System.out.println("|4| Alta de clientes");
		System.out.println("|5| Listar clientes");
		System.out.println("|6| Eliminar clientes");
		System.out.println("GESTIÓN DE CARTERA DE VENTAS");
		System.out.println("|7| Insertar cliente a la cola");
		System.out.println("|8| Listar cola de clientes");
		System.out.println("|9| Atender clientes");
		
		System.out.println("GESTIÓN DE GANANCIA");
		System.out.println("|10| Listar ganancias");
		System.out.println("|11| Consultar ganancias por id");
		
		System.out.println("|20| Salvar todos los datos.");
		System.out.println("|0| Salir");
	}
}
