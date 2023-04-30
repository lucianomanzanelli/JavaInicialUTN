package Clase8;

public class Cliente {

	private int codigo;
	private int dni;
	private String nombre;
	private String direccion;
	
	//Metodo constructor
	public Cliente(int codigo, int dni, String nombre, String dire) {
		this.codigo = codigo;
		this.dni = dni;
		this.nombre = nombre;
		this.direccion = dire;
	}
	
	public int dameCodigo() {
		return codigo;
	}
	public int dameDni() {
		return dni;
	}
	public String dameNombre() {
		return nombre;
	}
	public String dameDireccion() {
		return direccion;
	}
	
}
