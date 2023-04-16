package Clase3;

public class Ejercicio1A {

	public static void main(String[] args) {

	    String palabra = "Otorrinolaringolo";
	    String caracter = "o";
	    int contador = 0;

	    String palabraMinuscula = palabra.toLowerCase();
	    String caracterLower = caracter.toLowerCase();
	    String caracterUpper = caracter.toUpperCase();

	    int posicion = palabraMinuscula.indexOf(caracterLower);
	    
	    while (posicion != -1) {
	        contador++;
	        posicion = palabraMinuscula.indexOf(caracterLower, posicion+1);
	    }

	    if (contador > 1) {
	        System.out.println("En la palabra hay " + contador + " letras " + caracterUpper);
	    } 
	    else if (contador > 0 && contador < 2) {
	        System.out.println("En la palabra hay " + contador + " letra " + caracterUpper);
	    }
	    else {
	        System.out.println("No hay coincidencias");
	    }
	}


}
