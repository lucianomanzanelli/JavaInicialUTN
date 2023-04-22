package Clase5ConArchivo;

public class Producto {
	private int codigo;
	private String nombre;
	private String descripcion;
	private double precio;
	private int stock;
	
	public Producto(int cod, String nom, String desc, double prec, int stc) {
		codigo = cod;
		nombre = nom;
		descripcion = desc;
		precio = prec;
		stock = stc;	
	}

	public int un_codigo() {
		return codigo;
	}
	public String un_nombre() {
		return nombre;
	}
	public String un_desc() {
		return descripcion;
	}
	public double un_precio() {
		return precio;
	}
	public int un_stock() {
		return stock;
	}
	public String mostrarProducto() {
		return "Codigo: " + codigo + ", Nombre: " + nombre + ", Precio: " + precio;
	}

}
