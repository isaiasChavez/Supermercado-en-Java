package persistencia;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Scanner;

import javax.naming.directory.InvalidAttributesException;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Proyecto.Cliente;
import Proyecto.Ganancia;
import Proyecto.Producto;
import Proyecto.RegistroCliente;
import Proyecto.RegistroGanancia;
import Proyecto.RegistroProducto;
import Proyecto.RegistroVenta;
import Proyecto.Venta;

public class Principal extends JFrame {

	
	public static void main(String[] args) throws InvalidAttributesException {
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

		RegistroVenta registroVentas = new RegistroVenta();
		ArrayList<Venta> listaPrincipalDeVentas = new ArrayList<Venta>();
		
		
		String respuesta="";
		Principal p = new Principal();
		
		
		
		while(respuesta!=  "0"  ) {
			
			
		p.imprimirMenu();
		
		
		
		respuesta = sc.nextLine();
		
		
		
		switch (respuesta) {
		
		case "1"://AGREGAR PRODUCTO
		
			Producto productoTemporal = new Producto();
			
			int idTemporalAgregar =0;
			try {
				
			
			System.out.println("--------NUEVO PRODUCTO----------");
			System.out.println("Ingrese un nombre para el producto");
			productoTemporal.setNombre(sc.nextLine());
			
			idTemporalAgregar = registroDeProductos.getIdProductos();
				
			System.out.println("Ingrese una cantidad para el producto");
			productoTemporal.setCantidad(sc.nextInt());
			System.out.println("Ingrese un precio de compra para el producto");
			productoTemporal.setPrecioDeCompra(sc.nextFloat());
			System.out.println("Ingrese un precio de venta");
			productoTemporal.setPrecioDeVenta(sc.nextFloat());
			System.out.println("-------------------------------");
			registroDeProductos.insertar(listaPrincipalDeProductos,productoTemporal);
			System.out.println("-------------------------------");	
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Parece que ha habido un error: " + e.getMessage());
			}
			
			break;
		case "2": //BAJA
			
			try {
				
			
			System.out.println("-------------------------------");
			System.out.println("---------LA LISTA DE PRODUCTOS EXISTENTES ES ----------");
			registroDeProductos.imprimirLista(listaPrincipalDeProductos);
			System.out.println("Ingrese el id del producto a eliminar: ");
			int idProductoAEliminar = sc.nextInt();
			
			Producto productoTemporalAEliminar = registroDeProductos.buscarProducto(listaPrincipalDeProductos, idProductoAEliminar);
			
			if (productoTemporalAEliminar != null) {
				try {
					
					registroDeProductos.eliminar(listaPrincipalDeProductos,productoTemporalAEliminar);		
					System.out.println("Se ha eliminado el cliente con exito.");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("No se ha podido realizar la acción.");
				}
				
			}
			else{
				System.out.println("No se encontró el producto buscado, vuelva a intentar.");
				
			}
			
			
			
			
			System.out.println("Se ha dado de baja el producto: ");
			System.out.println("-------------------------------");
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Parece que ha habido un error");
			}
			
			break;
		case "3": //IMPRIMIR PRODUCTOS
			try {
			registroDeProductos.imprimirLista(listaPrincipalDeProductos);
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
			
		case "4"://ALTA CLIENTES
			
			
			try {
			Cliente clienteTemporal = new Cliente();
		
			
			System.out.println("------------NUEVO CLIENTE---------------");
			System.out.println("Ingrese un id: ");
			clienteTemporal.setIdCliente(sc.nextInt());
			System.out.println("Ingrese el nombre: ");
			sc.nextLine();
			clienteTemporal.setNombre(sc.nextLine());
			
			System.out.println("Ingrese un dirección: ");
			clienteTemporal.setDireccion(sc.nextLine());
			registroDeClientes.insertar(listaPrincipalDeClientes, clienteTemporal);
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Parece que ha habido un error.");
			}
			break;
			
		case "5": //LISTAR CLIENTES
			
			registroDeClientes.imprimirLista(listaPrincipalDeClientes);
			
			
			break;
		case "6": //ELIMINAR CLIENTES
			
			try {
			int idTemporalAEliminar;
			
			System.out.println("-------------ELIMINAR CLIENTE----------------");
			System.out.println("Ingrese el id cliente a eliminar: ");
			registroDeClientes.imprimirLista(listaPrincipalDeClientes);
			
			idTemporalAEliminar = sc.nextInt();
			
			Cliente clienteAEliminar = registroDeClientes.buscarCliente(listaPrincipalDeClientes, idTemporalAEliminar);
			
			if(clienteAEliminar != null) {
				System.out.println("El cliente a eliminar es " +  clienteAEliminar);
				registroDeClientes.eliminar(listaPrincipalDeClientes, clienteAEliminar);
				
			}else {
				System.out.println("No se encontró el Ide buscado");
			}
			
			//LHOPITAL E INTEGRALES IMPROPIAS
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			break;
		case "7": //INSERTAR CLIENTE A LA COLA
			try {
			int idTemporalCliente,idTemporalProducto;
			System.out.println("-----------NUEVO CLIENTE A LA COLA------------");
			System.out.println("");
			System.out.println("Clientes disponibles: ");
			registroDeClientes.imprimirLista(listaPrincipalDeClientes);
			
			System.out.println("Ingrese el número de cliente que desea agregar a la cola: ");
			idTemporalCliente = sc.nextInt();
			
				
			//OBTENCIÓN DEL CLIENTE DE LA LISTA ACTUAL DE CLIENTES	
			Cliente clienteAInsertarALaCola = listaPrincipalDeClientes.get(idTemporalCliente);
			System.out.println("El cliente selecionado fue: " + clienteAInsertarALaCola.getNombre() );
			System.out.println("");
			
			Venta nuevaVenta = new Venta();
			ArrayList<Producto> carrito = new ArrayList<Producto>();
			
			
			System.out.println("-----------DATOS DE LA VENTA---------- ");
			/*
			 * int idVenta;
				Cliente cliente;
				ArrayList<Producto> carritoProducto;
				float totalVenta;
				Date fecha;
				float totalGanancias ;
			 * */
			
			System.out.println("Ingrese el id de la venta: ");
			nuevaVenta.setIdVenta(sc.nextInt());
			nuevaVenta.setFecha(new Date(1000));
			
			
			System.out.println("------------LLENADO DEL CARRITO-------- ");
			
			do {				
			System.out.println("PRODUCTOS EN STOCK_: ");
			
			registroDeProductos.imprimirLista(listaPrincipalDeProductos);
			
			
			System.out.println("|100| SALIR");
			idTemporalProducto = sc.nextInt();
			
			if(idTemporalProducto!= 100) {
				
			Producto productoSeleccionado = listaPrincipalDeProductos.get(idTemporalProducto);
			
			System.out.println("El producto seleccionado fue: " + productoSeleccionado.getNombre());
			carrito.add(productoSeleccionado);
			
			}
			
			
			} while (idTemporalProducto != 100);
			
			nuevaVenta.setCarritoProducto(carrito);
			
			nuevaVenta.setCliente(clienteAInsertarALaCola);
			
			nuevaVenta.imprimirCarrito();
			
			registroVentas.insertarVenta(listaPrincipalDeVentas, nuevaVenta);		
			
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
			
			break;
		case "8": //LISTAR COLA DE CLIENTES
			try {
			System.out.println("La cola de clientes es la siguiente: ");
			
			registroVentas.imprimirLista(listaPrincipalDeVentas);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			break;
		case "9": //ATENDER CLIENTES
			System.out.println("EN CONSTRUCCIÓN");
			try {
			
			System.out.println("CLIENTES EN LA COLA DE CLIENTES");
			registroVentas.imprimirLista(listaPrincipalDeVentas);
			System.out.println("-----------------------------------");
			registroVentas.atender(listaPrincipalDeVentas , listaPrincipalDeGanancias);
			
			
			
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			
			break;
		case "10": //LISTAR GANANCIAS
			try {
			System.out.println("--------------------GANANCIAS REGISTRADAS---------------");
			
			registroDeGanancias.imprimirLista(listaPrincipalDeGanancias);
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			
			break;
		case "11": //CONSULTAR GANANCIA POR ID
			try {
			System.out.println("-----------LA LISTA DE GANANCIAS ES LA SIGUIENTE: -----------");
			registroDeGanancias.imprimirLista(listaPrincipalDeGanancias);
			
			
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
			} catch (Exception e) {
				// TODO: handle exception
			}
			break;
			
		case"20":
			try {
			System.out.println("Salvando los datos");
			
			registroDeProductos.escribirArchivo(listaPrincipalDeProductos);
			registroDeGanancias.escribirArchivo(listaPrincipalDeGanancias);
			registroDeClientes.escribirArchivo(listaPrincipalDeClientes);
			} catch (Exception e) {
				// TODO: handle exception
			}
		case"0":
			System.out.println("Salida");
		
		}
	
		
		}
		
		
		
		
		
	}
	
	
	
	public void imprimirMenu() {
		System.out.println("");
		System.out.println("--------------------------------------------");
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
		System.out.println("--------------------------------------------");
		System.out.println("");
	}
}
