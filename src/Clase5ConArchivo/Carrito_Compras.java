package Clase5ConArchivo;

public class Carrito_Compras {
	private int numCarrito;
	private Producto producto;
	private int cantidad;
	private double monto;
	
	public Carrito_Compras(Persona per1, int numero) {
		numCarrito = numero;
		monto = 0;
	}
	public int dameNumero() {
		return numCarrito;
	}
	public double montoCarrito() {
		return monto;
	}
	public int dameCantidad() {
		return cantidad;
	}
	public double dameMonto() {
		return monto;
	}
	public Producto dameProducto() {
		return producto;
	}
	public void verCompras() {
		System.out.println(cantidad + "\t" + producto.un_nombre() + "\t" 
					+ producto.un_precio() + "\t" + monto );
	}


}
