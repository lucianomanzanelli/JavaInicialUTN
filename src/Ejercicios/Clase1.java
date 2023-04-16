package Ejercicios;

public class Clase1 {

	public static void main(String[] args) {
		
		//Ejercicios Clase 1
		
		System.out.println("----1A----");
		//Ej 1 a.
		
		int anumeroInicio = 5;
		int anumeroFin = 14;
		
		while (anumeroInicio <= anumeroFin) {
			System.out.println("Numero: " + anumeroInicio);
			anumeroInicio++;
		}
		
		
		System.out.println("----1B----");
		//Ej 1 b.
		
		int bnumeroInicio = 5;
		int bnumeroFin = 14;
		
		while (bnumeroInicio <= bnumeroFin) {
			if(bnumeroInicio % 2 == 0) {
				System.out.println("Par: " + bnumeroInicio);
			}
			bnumeroInicio++;
		}
		
		System.out.println("----1C----");
		//Ej 1 c.
		
		int cnumeroInicio = 5;
		int cnumeroFin = 14;
		//elegir true para imprimir pares, false para impares
		boolean esPar = false; 
		
		while (cnumeroInicio <= cnumeroFin) {
			if(esPar) {
				if(cnumeroInicio % 2 == 0) {
					System.out.println("Par: " + cnumeroInicio);
				}		
			}
			else 
				if(cnumeroInicio % 2 != 0) {
					System.out.println("Impar: " + cnumeroInicio);
				}	
			cnumeroInicio++;
		}
			
		System.out.println("----1D----");
		//Ej 1 d.
		
		int dnumeroInicio = 5;
		int dnumeroFin = 14;
		
		for(int i=dnumeroFin; i>dnumeroInicio; i--) {
			if(i % 2 == 0) {
				System.out.println("Par: " + i);
			}
		}
		
		
		System.out.println("----2----");
		//Ej 2.
		
		
		int ingresos = 400000;
		//Vehículos con una antigüedad menor a 5 años.
		int vehiculos = 2;
		int inmuebles = 3;
		//TRUE -> Si posee una embarcación, una aeronave de lujo o ser titular de activos
		//societarios que demuestren capacidad económica plena.
		boolean lujo = false;
		
		if((ingresos >= 489083) || (vehiculos >= 3) || (inmuebles >= 3) || (lujo) )
		{
			System.out.println("PERTENECE al segmento de ingresos altos");
		}
		else 
			System.out.println("NO pertenece al segmento de ingresos altos");
		
		
		
		}
	}

