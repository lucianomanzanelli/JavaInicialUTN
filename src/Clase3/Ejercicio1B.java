package Clase3;

public class Ejercicio1B {

	public static void main(String[] args) {
		
		int a = 15;
		int b = 10;
		int c = 20;
		boolean creciente = false;
		
		int []vector = {0,0,0};
		
		if(!creciente) {
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
			}
		}
		//creciente
			else {
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
				}
				
				if(a < b && a < c) {
					vector[0] = a;
					
					if(b > c) {
						vector[1] = b;
						vector[2] = c;
					}
					else {
						vector[1] = c;
						vector[2] = b;
					}
				}
				
				
			}
		
		//orden creciente o decreciente
		if(creciente) {
			System.out.println("Orden creciente:");
			
			for(int i=0; i<vector.length; i++) {
				System.out.println("Posicion " + i + ": " + vector[i]);
			}
		}
		else {
			System.out.println("Orden decreciente:");
			
			for(int i=0; i<vector.length; i++) {
				System.out.println("Posicion " + i + ": " + vector[i]);
			}
		}
		
	}

}
