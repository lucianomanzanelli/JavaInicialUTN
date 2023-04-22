package Clase5ConArchivo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ComprarSupermercado {

	public static void main(String[] args) throws IOException {
		
		//Se instancia un objeto tipo vector de la clase Producto
		Producto cargaProducto[] = new Producto[3];
		
		String ruta = "C:\\Users\\lucho\\eclipse-workspace\\JavaArgPrograma\\src\\Clase5ConArchivo\\carritoCompras.txt";
		File archivo = new File(ruta);
        String cadena;
        Scanner entrada = null;
  
  
        try {
        	//se crea un Scanner asociado al fichero
            entrada = new Scanner(archivo);         
           
          //mientras no se alcance el final del fichero  
            while (entrada.hasNext()) {       
            	for (int i=0; i<cargaProducto.length; i++) {
            		//se lee una línea del fichero
            		cadena = entrada.nextLine();  
            		int indice = i;
            		//llama al metodo donde se cargan los productos
            		cargarProductos(cadena, cargaProducto, indice);               
            	 }
            }
            
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally{
            entrada.close();                                                                                      
        }  
        
        Persona per1 = new Persona("Luciano","Manzanelli", 113826);
        Carrito_Compras carr1 = new Carrito_Compras(per1, 001);
        
    	ItemCarrito cargaItem[] = new ItemCarrito[3]; //se crea un vector de objetos de clase ItemCarrito
    	
		cargaItem[0] = new ItemCarrito(carr1,cargaProducto, 2, 0); 					
		cargaItem[1] = new ItemCarrito(carr1,cargaProducto, 5, 1);		
		cargaItem[2] = new ItemCarrito(carr1,cargaProducto, 1, 2);
		
		mostrarCompras(cargaItem, carr1, per1);
	}
        
	public static void cargarProductos(String cadena, Producto cargaProducto[],int i) {

		String[] items = cadena.split(",");
	
		int codigo = Integer.parseInt(items[0]);
		String nombre = items[1];
		double precio = Double.parseDouble(items[2]);
		int stock = Integer.parseInt(items[3]);	
	
		cargaProducto[i] = new Producto(codigo,nombre," ",precio,stock);//dejo vacia la descripcion, aqui pueden
																	//modificarlo

	}
	
	public static void mostrarCompras(ItemCarrito cargaItem[],Carrito_Compras carr1, Persona per1) {
		double suma = 0;
		System.out.println("====================================");
		System.out.println("Carrito numero: " + carr1.dameNumero() + "\nPersona: " + per1.un_nombre());
		System.out.println("====================================");
		cargaItem[0].mostrarTitulo();
		
		 	for (ItemCarrito items:cargaItem) {
		 		items.mostrarItems();
		 		suma += items.dameMonto();
		}
		 System.out.println("\nEl precio total del carrito es: $" + suma);
	}

}

