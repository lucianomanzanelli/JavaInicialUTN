package TPFinalConcesionario;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompraVenta {

	public static void main(String[] args) {
		try {
			
			//crear la conexion
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/concesionario", "root", "admin");
			
			
			System.out.println("==============================");
			System.out.println("| BIENVENDIDO: CONCESIONARIO |");
			System.out.println("==============================\n");
			
			System.out.println("Seleccione una opcion: ");
			System.out.println("1) Dar de alta a un Cliente");
			System.out.println("2) Consultar listado de Clientes");
			System.out.println("3) Dar de alta a un Vendedor");
			System.out.println("4) Consultar listado de Vendedores");
			System.out.println("5) Comprar un vehiculo");
			System.out.println("6) Vender un vehiculo");
			System.out.println("7) Consultar vehiculos");
			System.out.println("8) Consultar listado de Transacciones");
			
			try (Scanner entrada = new Scanner(System.in)) {
				int opcion = entrada.nextInt();
				entrada.nextLine();
				
				switch (opcion) {
				case 1:
					altaCliente(conn);
					System.out.println("\n");
					consultaClientes(conn);
					break;
				case 2:
					consultaClientes(conn);
					break;
				case 3:
					altaVendedor(conn);
					System.out.println("\n");
					consultaVendedores(conn);
					break;	
				case 4:
					consultaVendedores(conn);
					break;
				case 5:
					altaVehiculo(conn);
					System.out.println("\n");
					vehiculosDisponibles(conn);
					break;
				case 6:
					agregarVenta(conn);
					System.out.println("\n");
					consultaVehiculos(conn);
					break;
				case 7:
					consultaVehiculos(conn);
					break;
				case 8:
					consultaTransacciones(conn);
					break;
						
				default:
					return;
				}
			}
			
		} 
		catch (Exception e) {
			System.out.println("Error en la DB: " + e.fillInStackTrace());
		}
	}
	
	
	private static void consultaTransacciones(Connection conn) {
		System.out.println("LISTADO DE TRANSACCIONES");
		try {
			String consulta = "SELECT CONCAT(c.apellido,' ', c.nombre) 'Cliente', CONCAT(v.apellido,' ', v.nombre) 'Vendedor', CONCAT(ve.marca,' ',ve.modelo) 'Vehiculo', t.fecha 'Fecha', t.tipo 'Tipo' FROM TRANSACCIONES T, CLIENTES C, VENDEDORES V, VEHICULOS VE WHERE t.id_cliente = c.id_cliente and t.id_vendedor = v.id_vendedor and t.id_vehiculo = ve.id_vehiculo;";
			
			Statement stat = conn.createStatement();
			ResultSet resultadoConsulta = stat.executeQuery(consulta);
			
			while (resultadoConsulta.next()) {
				
				System.out.println("Cliente: " + resultadoConsulta.getString(1) + 
						" \t|Vendedor: " + resultadoConsulta.getString(2) + 
						" \t|Vehiculo: " + resultadoConsulta.getString(3) + 
						" \t|Fecha: " + resultadoConsulta.getDate(4) + 
						" \t|Transaccion: " + resultadoConsulta.getString(5));
			}
			
		} 
		
		catch (Exception e) {
        System.out.println("Error al mostrar el historial de transacciones:\n" + e.getMessage());
		}
	}


	private static void consultaVendedores(Connection conn) {
		System.out.println("LISTADO DE VENDEDORES");
		try {
			String consulta = "SELECT * FROM VENDEDORES";
			
			Statement stat = conn.createStatement();
			ResultSet resultadoConsulta = stat.executeQuery(consulta);
			
			while (resultadoConsulta.next()) {
				
				System.out.println("Legajo: " + resultadoConsulta.getString(2) + 
						" \t|Nombre: " + resultadoConsulta.getString(3) + 
						" \t|Apellido: " + resultadoConsulta.getString(4));
			}
			
		} 
		
		catch (Exception e) {
        System.out.println("Error al mostrar los vendedores: " + e.getMessage());
		}
	}


	private static void consultaClientes(Connection conn) {
		System.out.println("LISTADO DE CLIENTES");
		try {
			String consulta = "SELECT * FROM CLIENTES";
			
			Statement stat = conn.createStatement();
			ResultSet resultadoConsulta = stat.executeQuery(consulta);
			
			while (resultadoConsulta.next()) {
				
				System.out.println("DNI: " + resultadoConsulta.getString(2) + 
						" \t|Nombre: " + resultadoConsulta.getString(3) + 
						" \t|Apellido: " + resultadoConsulta.getString(4));
			}
			
		} 
		
		catch (Exception e) {
        System.out.println("Error al mostrar los clientes: " + e.getMessage());
		}
	}


	public static void agregarVenta(Connection conn) {
	    Scanner entrada = new Scanner(System.in);
	    try {
	        System.out.println("VENTA DE VEHICULO");

	        // Guardar los vehiculos en una lista
	        List<Vehiculo> vehiculosDisponibles = new ArrayList<>();
	        String consulta = "SELECT * FROM VEHICULOS WHERE disponible = true;";
			
			Statement stat = conn.createStatement();
			ResultSet resultadoConsulta = stat.executeQuery(consulta);
	        
			while (resultadoConsulta.next()) {
				Vehiculo vehiculo = new Vehiculo();
				vehiculo.setId_vehiculo(resultadoConsulta.getInt(1));
				vehiculo.setMarca(resultadoConsulta.getString(2));
				vehiculo.setModelo(resultadoConsulta.getString(3));
				vehiculo.setPrecio(resultadoConsulta.getDouble(5));
				
				vehiculosDisponibles.add(vehiculo);
			}
			resultadoConsulta.close();
			stat.close();
			
			
	        // Obtener la información del vehículo
	        System.out.println("Seleccione un vehiculo:");
	        for (int i = 0; i < vehiculosDisponibles.size(); i++) {
	            System.out.println((i + 1) + ". " + vehiculosDisponibles.get(i).getModelo());
	        }
	        int vehiculoIndex = entrada.nextInt() - 1;
	        entrada.nextLine();
	        Vehiculo vehiculo = vehiculosDisponibles.get(vehiculoIndex);

	        
	        // Agregar clientes a una lista
	        List<Cliente> listaClientes = new ArrayList<>();
	        String consulta1 = "SELECT * FROM CLIENTES;";
			
			Statement stat1 = conn.createStatement();
			ResultSet resultadoConsulta1 = stat1.executeQuery(consulta1);
	        
			while (resultadoConsulta1.next()) {
				Cliente cliente = new Cliente();
				cliente.setId_cliente(resultadoConsulta1.getInt(1));
				cliente.setDni(resultadoConsulta1.getInt(2));
				cliente.setNombre(resultadoConsulta1.getString(3));
				cliente.setApellido(resultadoConsulta1.getString(4));
				
				listaClientes.add(cliente);
			}
			resultadoConsulta1.close();
			stat1.close();
	        
	        
	        // Obtener la información del cliente
	        System.out.println("Seleccione un cliente:");
	        for (int i = 0; i < listaClientes.size(); i++) {
	            System.out.println((i + 1) + ". " + listaClientes.get(i).getNombre());
	        }
	        int clienteIndex = entrada.nextInt() - 1;
	        entrada.nextLine();
	        Cliente cliente = listaClientes.get(clienteIndex);

	        
	        // Guardar vendedores en una lista
	        List<Vendedor> listaVendedores = new ArrayList<>();
	        String consulta2 = "SELECT * FROM VENDEDORES;";
			
			Statement stat2 = conn.createStatement();
			ResultSet resultadoConsulta2 = stat2.executeQuery(consulta2);
	        
			while (resultadoConsulta2.next()) {
				Vendedor vendedor = new Vendedor();
				vendedor.setId_vendedor(resultadoConsulta2.getInt(1));
				vendedor.setLegajo(resultadoConsulta2.getInt(2));
				vendedor.setNombre(resultadoConsulta2.getString(3));
				vendedor.setApellido(resultadoConsulta2.getString(4));
				
				listaVendedores.add(vendedor);
			}
			resultadoConsulta2.close();
			stat2.close();
	        
	        // Obtener la información del vendedor
	        System.out.println("Seleccione un vendedor:");
	        for (int i = 0; i < listaVendedores.size(); i++) {
	            System.out.println((i + 1) + ". " + listaVendedores.get(i).getNombre());
	        }
	        int vendedorIndex = entrada.nextInt() - 1;
	        entrada.nextLine();
	        Vendedor vendedor = listaVendedores.get(vendedorIndex);

	        
	        
	        // Crear la transacción
	        Transaccion transaccion = new Transaccion(cliente, vendedor, vehiculo);

	        // Guardar la transacción en la base de datos
	        String tipo = "Venta";
	        String consultaT = "INSERT INTO TRANSACCIONES VALUES (id_transaccion, " + 
	        		cliente.getId_cliente() + ", " + vendedor.getId_vendedor() + ", " + 
	        		vehiculo.getId_vehiculo() + ", '" + transaccion.getFecha() + "', '" + 
	        		tipo + "');";
	        
	        Statement statT = conn.createStatement();
	        statT.executeUpdate(consultaT);
	        System.out.println("Transaccion agregada correctamente");
	        
	        // Actualizar el vehiculo como vendido
	        String update = "UPDATE VEHICULOS SET disponible = 0 where id_vehiculo = " + vehiculo.getId_vehiculo() + ";";
	        Statement stat3 = conn.createStatement();
	        stat3.executeUpdate(update);
	        System.out.println("Vehiculo marcado como NO disponible");
	        
	        
	    } 
	    catch (Exception e) {
	        System.out.println("Error al agregar la transaccion: " + e.getMessage());
	    } finally {
	        entrada.close();
	    }
	}



	private static void consultaVehiculos(Connection conn) {
		
		vehiculosDisponibles(conn);
		vehiculosVendidos(conn);
		
	}


	private static void vehiculosDisponibles(Connection conn) {
		System.out.println("LISTADO DE VEHICULOS DISPONIBLES ORDENADOS POR PRECIO");
		try {
			String consulta = "SELECT * FROM VEHICULOS WHERE disponible = true ORDER BY precio";
			
			Statement stat = conn.createStatement();
			ResultSet resultadoConsulta = stat.executeQuery(consulta);
			
			while (resultadoConsulta.next()) {
				
				System.out.println("Marca: " + resultadoConsulta.getString(2) + 
						" \t|Modelo: " + resultadoConsulta.getString(3) + 
						" \t|Tipo: " + resultadoConsulta.getString(4) +
						" \t|Precio: " + resultadoConsulta.getDouble(5));
			}
			
		} 
		
		catch (Exception e) {
        System.out.println("Error al mostrar los vehiculos: " + e.getMessage());
		}
	}
	
	private static void vehiculosVendidos(Connection conn) {
		System.out.println("\nLISTADO DE VEHICULOS VENDIDOS ORDENADOS POR PRECIO");
		try {
			String consulta = "SELECT * FROM VEHICULOS WHERE disponible = false ORDER BY precio";
			
			Statement stat = conn.createStatement();
			ResultSet resultadoConsulta = stat.executeQuery(consulta);
			
			while (resultadoConsulta.next()) {
				
				System.out.println("Marca: " + resultadoConsulta.getString(2) + 
						" \t|Modelo: " + resultadoConsulta.getString(3) + 
						" \t|Tipo: " + resultadoConsulta.getString(4) +
						" \t|Precio: " + resultadoConsulta.getDouble(5));
			}
		}
			catch (Exception e) {
		        System.out.println("Error al mostrar los vehiculos: " + e.getMessage());
				}
	}


	public static void altaCliente(Connection conn) {
		try (Scanner entrada = new Scanner(System.in)) {
			
			Cliente cliente = new Cliente();
			
			System.out.println("AGREGAR NUEVO CLIENTE");
			System.out.println("Ingrese el dni: ");
			cliente.setDni(entrada.nextInt());
			entrada.nextLine();
			System.out.println("Ingrese el nombre: ");
			cliente.setNombre(entrada.nextLine());
			System.out.println("Ingrese el apellido: ");
			cliente.setApellido(entrada.nextLine());
			System.out.println("Ingrese el contacto: ");
			cliente.setContacto(entrada.nextLine());
			
			
			int dni = cliente.getDni();
	    	String nombre = cliente.getNombre();
	    	String apellido = cliente.getApellido();
	    	String contacto = cliente.getContacto();
	    	
	        String consulta = "INSERT INTO CLIENTES VALUES (id_cliente, " + dni + ", '" + nombre + "', '" + apellido + "', '" + contacto + "');";
	        Statement stat = conn.createStatement();
	        stat.executeUpdate(consulta);
	        System.out.println("Cliente agregado correctamente");
		}
		catch (Exception e) {
	        System.out.println("Error al agregar el cliente: " + e.getMessage());
	    }
	}
	
	public static void altaVendedor(Connection conn) {
		try (Scanner entrada = new Scanner(System.in)) {
				
				Vendedor vendedor = new Vendedor();
				
				System.out.println("AGREGAR NUEVO VENDEDOR");
				System.out.println("Ingrese el legajo: ");
				vendedor.setLegajo(entrada.nextInt());
				entrada.nextLine();
				System.out.println("Ingrese el nombre: ");
				vendedor.setNombre(entrada.nextLine());
				System.out.println("Ingrese el apellido: ");
				vendedor.setApellido(entrada.nextLine());
				
				
				int legajo = vendedor.getLegajo();
		        String nombre = vendedor.getNombre();
		        String apellido = vendedor.getApellido();

		        String consulta = "INSERT INTO VENDEDORES VALUES (id_vendedor, " + legajo + ", '" + nombre + "', '" + apellido + "');";
		        Statement stat = conn.createStatement();
		        stat.executeUpdate(consulta);
		        System.out.println("Vendedor agregado correctamente");
		    } 
		    catch (Exception e) {
		        System.out.println("Error al agregar el vendedor: " + e.getMessage());
		    }
	        
	}
	
	
	public static void altaVehiculo(Connection conn) {
	    try (Scanner scanner = new Scanner(System.in)) {
			try {
				System.out.println("COMPRA DE VEHICULO");
			    System.out.println("Ingrese los datos del vehiculo:");
			    System.out.println("1- Auto");
			    System.out.println("2- Camion");
			    System.out.println("3- Utilitario");
			    int opcion = scanner.nextInt();
			    scanner.nextLine();
			    
			    Vehiculo vehiculo = null;
			    int cant_puertas = 0;
			    String combustible = null;
			    int capacidad_carga = 0;
			    int cant_ejes = 0;
			    String tipo_trabajo = null;
			    int cant_asientos = 0;
			    
			    switch (opcion) {
			        case 1:
			            Auto auto = new Auto();
			            
			            System.out.print("Marca: ");
			            auto.setMarca(scanner.nextLine());
			            System.out.print("Modelo: ");
			            auto.setModelo(scanner.nextLine());
			            System.out.print("Precio: ");
			            auto.setPrecio(scanner.nextDouble());
			            scanner.nextLine();
			            System.out.print("Cantidad de puertas: ");
			            auto.setCant_puertas(scanner.nextInt());
			            scanner.nextLine();
			            System.out.print("Combustible: ");
			            auto.setCombustible(scanner.nextLine());
			            
			            auto.setTipo("Auto");
			            vehiculo = auto;
			            cant_puertas = auto.getCant_puertas();
			            combustible = auto.getCombustible();
			            break;
			            
			        case 2:
			            Camion camion = new Camion();
			            
			            System.out.print("Marca: ");
			            camion.setMarca(scanner.nextLine());
			            System.out.print("Modelo: ");
			            camion.setModelo(scanner.nextLine());
			            System.out.print("Precio: ");
			            camion.setPrecio(scanner.nextDouble());
			            scanner.nextLine();
			            System.out.print("Capacidad de carga en toneladas: ");
			            camion.setCapacidad_carga(scanner.nextInt());
			            scanner.nextLine();
			            System.out.print("Cantidad de ejes: ");
			            camion.setCant_ejes(scanner.nextInt());
			            scanner.nextLine();
			            
			            camion.setTipo("Camion");
			            capacidad_carga = camion.getCapacidad_carga();
			            cant_ejes = camion.getCant_ejes();
			            vehiculo = camion;
			            break;
			            
			        case 3:
			            Utilitario utilitario = new Utilitario();
			            System.out.print("Marca: ");
			            utilitario.setMarca(scanner.nextLine());
			            System.out.print("Modelo: ");
			            utilitario.setModelo(scanner.nextLine());
			            System.out.print("Precio: ");
			            utilitario.setPrecio(scanner.nextDouble());
			            scanner.nextLine();
			            System.out.print("Tipo de trabajo: ");
			            utilitario.setTipo_trabajo(scanner.nextLine());
			            System.out.print("Cantidad de asientos: ");
			            utilitario.setCant_asientos(scanner.nextInt());
			            scanner.nextLine();
			            
			            utilitario.setTipo("Utilitario");
			            tipo_trabajo = utilitario.getTipo_trabajo();
			            cant_asientos = utilitario.getCant_asientos();
			            vehiculo = utilitario;
			            break; 
			            
			        default:
			            System.out.println("Opcion invalida");
			            return;
			    }
			    
			    String consulta = "";
			    if (opcion == 1) {
			    	consulta = "INSERT INTO VEHICULOS (id_vehiculo, marca, modelo, tipo, precio, disponible, cant_puertas, combustible) " +
			                "VALUES (id_vehiculo, '" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "', '" + vehiculo.getTipo() +
			                "', " + vehiculo.getPrecio() + ", true, " + cant_puertas + ", '" + combustible + "');";
				} 
			    else if(opcion == 2) {
			    	consulta = "INSERT INTO VEHICULOS (id_vehiculo, marca, modelo, tipo, precio, disponible, capacidad_carga, cant_ejes) " +
			                "VALUES (id_vehiculo, '" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "', '" + vehiculo.getTipo() +
			                "', " + vehiculo.getPrecio() + ", true, " + capacidad_carga + ", " + cant_ejes + ");";
			    }
			    
			    else {
			    	consulta = "INSERT INTO VEHICULOS (id_vehiculo, marca, modelo, tipo, precio, disponible, tipo_trabajo, cant_asientos) " +
			                "VALUES (id_vehiculo, '" + vehiculo.getMarca() + "', '" + vehiculo.getModelo() + "', '" + vehiculo.getTipo() +
			                "', " + vehiculo.getPrecio() + ", true, '" + tipo_trabajo + "', " + cant_asientos + ");";
				}

			    
			    Statement stat = conn.createStatement();
			    stat.executeUpdate(consulta);
			    System.out.println("Vehiculo agregado correctamente");
			} 
			catch (Exception e) {
			    System.out.println("Error al agregar el vehiculo: " + e.getMessage());
			}
		}
	}


	
	
	
	
	
//fin clase	
}