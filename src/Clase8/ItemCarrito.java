package Clase8;

public class ItemCarrito {
	
	private Carrito numero;
	private Producto producto;
	private int cantidad;
	private double montoItem;
	
	public ItemCarrito(Carrito num, Producto prod, int cant) {
		numero = num;
		producto = prod;
		cantidad = cant;
		montoItem = cant * prod.Precio();
		
	};
	
	public Carrito dameNumero() {
		return numero;
	}
	public Producto dameProducto() {
		return producto;
	}
	public int dameCantidad() {
		return cantidad;
	}
	public double dameMontoItem() {
		return montoItem;
	}
	
	public String dameNombre() {
		String nombre = producto.Nombre();
		return nombre;
	}

	public void mostrarItems() {
		System.out.println(cantidad + "\t\t$" + producto.Precio() + "\t" 
					+ producto.Nombre() + "\t\t$" + montoItem);
		
	}
	
	

	
}
