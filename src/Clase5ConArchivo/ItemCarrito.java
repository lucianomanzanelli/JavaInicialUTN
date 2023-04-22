package Clase5ConArchivo;

public class ItemCarrito {
	public ItemCarrito (Carrito_Compras num, Producto []p, int cantidad, int i) {
		num.dameNumero();
		prodI = p;
		this.cantidad = cantidad;
		montoItem = prodI[i].un_precio() * cantidad;
		montoTotal = 0;
		this.i = i;
	}
	
	private int cantidad;
	private double montoItem;
	private double montoTotal;
	private Producto []prodI;	
	private int i;
	
	public double dameMonto() {
		return montoItem;
	}
	public double dameMontoT() {
		return montoTotal;
	}	
	public void mostrarItems() {
		System.out.println(prodI[i].un_nombre() + "\t\t" + cantidad + "\t\t$" + prodI[i].un_precio() +
				"\t$" + montoItem);	
	}
	public void mostrarTitulo() {
		System.out.println("Producto\tCantidad\tPrecio\tSubtotal");
	}
	
}
