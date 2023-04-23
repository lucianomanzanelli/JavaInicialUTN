package Clase5;

public class Compras {

	public static void main(String[] args) {
		
		
		Producto p1 = new Producto(1, "Sal", "Sal de mesa", 250.25);
		Producto p2 = new Producto(10, "Arroz", "Arroz refinado", 285);
		Producto p3 = new Producto(13, "Leche", "Leche entera", 325.30);
		
		Cliente c1 = new Cliente(113826, 11222333, "Luciano", "Córdoba");
		
		Carrito carro = new Carrito(25, c1);
	
		ItemCarrito itemC[] = new ItemCarrito[3];
		itemC[0] = new ItemCarrito(carro, p1, 2);
		itemC[1] = new ItemCarrito(carro, p2, 5);
		itemC[2] = new ItemCarrito(carro, p3, 1);
		
		System.out.println("Cantidad\tPrecio\tProducto\tSubtotal");
		mostrarItems(itemC, carro, c1);
		
		
		
		
	}
	
	public static void mostrarItems(ItemCarrito vector[], Carrito carro, Cliente c1) {
		
		double total = 0;
		
		for(ItemCarrito items:vector) {
			items.mostrarItems();
			total += items.dameMontoItem();
		}
		
		carro.mostrarMontoTotal(total);
		
		//aplicamos descuento fijo
		Descuento desc1 = new DescuentoFijo();
		desc1.asignarDescuento(250.8);
		System.out.println("El monto total con el descuento asignado es: $" + desc1.valorFinal(total));
	
		//aplicamos descuento porcentual
		Descuento desc2 = new DescuentoPorcentaje();
		desc2.asignarDescuento(0.15);
		System.out.println("El monto total con el porcentaje de descuento asignado es: $" + desc2.valorFinal(total));
	
	}
	

}
