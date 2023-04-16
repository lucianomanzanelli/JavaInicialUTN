package Clase3;

public class Ejercicio1C {

	public static void main(String[] args) {

		int []vector = {15,5,5};
		int numeroX = 2;
		int resultado = 0;
		
		for(int i=0; i<vector.length; i++) {
			if(vector[i] > numeroX) {
				resultado += vector[i]; 
			}
		}
		System.out.println("La suma de los numeros es: " + resultado);

	}

}
