package Clase4;
import java.util.Scanner;

public class Ejercicio1B {

	public static void main(String[] args) {

		try (Scanner scn = new Scanner(System.in)) {
			System.out.println("Ingrese el primer numero: ");
			int a = scn.nextInt();
			System.out.println("Ingrese el segundo numero: ");
			int b = scn.nextInt();
			System.out.println("Ingrese el tercer numero: ");
			int c = scn.nextInt();
			System.out.println("Ingrese el orden (A=Ascendente, D=Descendente): ");
			String letra = scn.next();
			
			
			int[] vector = numerosOrdenados(a,b,c, letra);
			
			for(int i=0; i<vector.length; i++) {
				System.out.println("Numero: " + vector[i]);
			}
		}

			
		}
		
		public static int[] numerosOrdenados(int a, int b, int c, String orden) {
			int []vector = {0, 0, 0};
			
			if(orden.equals("A")){
				System.out.println("Orden ASCENDENTE:");
			}
			else if(orden.equals("D")) {
				System.out.println("Orden DESCENDENTE:");
			}
			else {
				orden = "A";
				System.out.println("Orden incorrecto, default ASCENDENTE");
			}
			
			switch(orden) {
			//Descendente
				case "D":
					if(a > b && a > c) {
						vector[0] = a;
						
						if(b > c) {
							vector[1] = b;
							vector[2] = c;
						}
						else {
							vector[1] = c;
							vector[2] = b;
						}
						break;
					}
					
					if((a < b && a > c) || (a > b && a < c)) {
						vector[1] = a;
						
						if(b > c) {
							vector[0] = b;
							vector[2] = c;
						}
						else {
							vector[0] = c;
							vector[2] = b;
						}
						break;
					}
					
					if(a < b && a < c) {
						vector[2] = a;
						
						if(b > c) {
							vector[0] = b;
							vector[1] = c;
						}
						else {
							vector[0] = c;
							vector[1] = b;
						}
						break;
					}
			
			
			//Ascendente
				case "A":
					if(a > b && a > c) {
						vector[2] = a;
						
						if(b > c) {
							vector[0] = c;
							vector[1] = b;
						}
						else {
							vector[0] = b;
							vector[1] = c;
						}
						break;
					}
					
					if((a < b && a > c) || (a > b && a < c)) {
						vector[1] = a;
						
						if(b > c) {
							vector[0] = c;
							vector[2] = b;
						}
						else {
							vector[0] = b;
							vector[2] = c;
						}
						break;
					}
					
					if(a < b && a < c) {
						vector[0] = a;
						
						if(b > c) {
							vector[1] = c;
							vector[2] = b;
						}
						else {
							vector[1] = b;
							vector[2] = c;
						}
						break;
					}
					
				}
			
			
			return vector;
		}
		
	}


