package Clase3;

public class Ejercicio2 {

	public static void main(String[] args) {

	    String frase = "Agustin;Daniel;Bruno;Marcos;Nacho;Julieta;Olivia";
	    String[] vectorSplit = frase.split(";");

	    int i = 1;
	    for (String nombre : vectorSplit) {
	        System.out.println(i + " nombre: " + nombre);
	        i++;
	    }
	}

}
