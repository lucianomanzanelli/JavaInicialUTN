package Clase5ConArchivo;

public class Persona {
	public Persona(String nombre,String  apellido, int dni) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		id = idSiguiente;
		idSiguiente++;
	}
	
	private String nombre;
	private String  apellido;
	private int dni;
	private int id;
	private static int idSiguiente = 1;
	
	public String un_nombre() {
		return id + "- " + nombre.toUpperCase() + " " + apellido.toUpperCase();
	}
	public int un_dni() {
		return dni;
	}

	public static int un_idSiguiente() {
		return idSiguiente;
	}

}
