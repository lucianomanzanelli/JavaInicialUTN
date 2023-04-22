package Clase5;

import java.util.HashMap;

public class Producto {

	private int codigo;
	private String nombre;
	private String descripcion;
	private double precio;
	
	public Producto(int cod, String nom, String desc, double pre) {
		codigo = cod;
		nombre = nom;
		descripcion = desc;
		precio = pre;
		
	}
	
	//creo los metodos getters para acceder al contenido de los atributos
	
	public int Codigo(){
		return codigo;
	}
	public String Nombre() {
		return nombre;
	}
	public String Descripcion() {
		return descripcion;
	}
	public double Precio(){
		return precio;
	}
	
	public void mostrarProducto(){
		System.out.println("Codigo: " + codigo);
		System.out.println("Nombre: " + nombre);
		System.out.println("Descripcion: " + descripcion);
		System.out.println("Precio: " + precio + "\n");
	}
	
	
	
	
	
	

}
