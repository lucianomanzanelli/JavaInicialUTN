package Clase8;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Compras {

	public static void main(String[] args) {
		
		
		Producto p1 = new Producto(1, "Sal", "Sal de mesa", 250.25);
		Producto p2 = new Producto(10, "Arroz", "Arroz refinado", 285);
		Producto p3 = new Producto(13, "Leche", "Leche entera", 325.30);
		Producto p4 = new Producto(15, "Harina", "Harina 0000", 278);
		Producto p5 = new Producto(17, "Fideos", "Spaguetti", 207);
		Producto p6 = new Producto(27, "Queso", "Queso crema", 214.3);
		
		Cliente c1 = new Cliente(113826, 11222333, "Luciano", "Córdoba");
		
		Carrito carro = new Carrito(25, c1);
	
		ItemCarrito item1 = new ItemCarrito(carro, p1, 2);
		ItemCarrito item2 = new ItemCarrito(carro, p2, 5);
		ItemCarrito item3 = new ItemCarrito(carro, p3, 1);
		ItemCarrito item4 = new ItemCarrito(carro, p4, 1);
		ItemCarrito item5 = new ItemCarrito(carro, p5, 2);
		ItemCarrito item6 = new ItemCarrito(carro, p6, 4);
		
		List<ItemCarrito> listaItems = new ArrayList<ItemCarrito>();
		
		
		listaItems.add(item1);
		listaItems.add(item2);
		listaItems.add(item3);
		listaItems.add(item4);
		listaItems.add(item5);
		listaItems.add(item6);
		
		mostrarCompras(listaItems, carro, c1);
		
				
	}
	
	
	public static void aplicarDescuento(double total) {
		
		final double montoMinimo = 5000;
		
		LocalDate fecha = LocalDate.now();
		int dia = fecha.getDayOfMonth();
		
		if(dia%2 != 0) {
			//aplicamos descuento fijo
			Descuento desc1 = new DescuentoFijo();
			desc1.asignarDescuento(250.8);
			double montoFijo = desc1.valorFinal(total);
			
			if (montoFijo > 0) {
				System.out.println("El monto total con el descuento asignado es: $" 
						+ String.format("%.2f", montoFijo));
			}
			else
				System.out.println("No se permite aplicar el descuento");
				
				
				
		}
		else {
			//aplicamos descuento porcentual
			Descuento desc2 = new DescuentoPorcentaje();
			double montoPorcent =  desc2.valorFinal(total);
			
			if (montoPorcent > 0) {
				if (total < montoMinimo) {
					desc2.asignarDescuento(0.10);
					System.out.println("El monto total con el porcentaje de descuento asignado es: $" 
										+ String.format("%.2f", montoPorcent));
					
				}
				else {

					desc2.asignarDescuento(0.15);
					System.out.println("El monto total con el porcentaje de descuento asignado es: $" 
										+ String.format("%.2f", montoPorcent));
				}
			}
			else 
				System.out.println("No se permite aplicar el descuento");
			
		}
	}
	
	
	
	public static void mostrarCompras(List<ItemCarrito> listaItems, Carrito carro, Cliente c1) {
		
		Iterator<ItemCarrito> itItems = listaItems.iterator();
		
		System.out.println("Cantidad\tPrecio\tProducto\tSubtotal");
		
		
		double total = 0;
		while(itItems.hasNext()) {
			ItemCarrito datos = itItems.next();
			
			datos.mostrarItems();
			
			total += datos.dameMontoItem();
		}
		
		
		
		carro.mostrarMontoTotal(total);
		
		if (total > 0)
			aplicarDescuento(total);
		else
			System.out.println("El monto del carro no permite descuentos");
		
		
	}
	

}
