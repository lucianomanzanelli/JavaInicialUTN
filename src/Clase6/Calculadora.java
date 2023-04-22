package Clase6;

import java.util.Scanner;

public class Calculadora {

	public static void main(String[] args) {

		//sumar(1, 2);
		//restar(2, 5);
		//multiplicar(5, 5);
		//dividir(5, 3);
		//dividir(5, 0);
		
		iniciar();
		calcular();
		
		
		
	}
	
	public static void iniciar() {
		System.out.println("~~~~~~~~~~~~~");
		System.out.println("|Calculadora|");
		System.out.println("~~~~~~~~~~~~~");
		System.out.println("Elija la opcion:");
		
		System.out.println("1) Sumar");	
		System.out.println("2) Restar");	
		System.out.println("3) Multiplicar");	
		System.out.println("4) Dividir\n");	
		
		opciones();
	}
	
	public static void opciones() {
		System.out.println("5) Limpiar");
		System.out.println("6) Salir\n");
	}
	
	
	public static void calcular() {
		try (Scanner scn = new Scanner(System.in)) {
			
			int numero = scn.nextInt();
			
			switch(numero) {
			case 1:
				System.out.println("SUMAR");
				System.out.println("Ingrese el primer numero");
				double sum1 = scn.nextDouble();
				System.out.println("Ingrese el segundo numero");
				double sum2 = scn.nextDouble();
				sumar(sum1, sum2);
				opciones();
				calcular();
				break;
			
			case 2:
				System.out.println("RESTAR");
				System.out.println("Ingrese el primer numero");
				double res1 = scn.nextDouble();
				System.out.println("Ingrese el segundo numero");
				double res2 = scn.nextDouble();
				restar(res1, res2);
				opciones();
				calcular();
				break;
				
			case 3:
				System.out.println("MULTIPLICAR");
				System.out.println("Ingrese el primer numero");
				double mul1 = scn.nextDouble();
				System.out.println("Ingrese el segundo numero");
				double mul2 = scn.nextDouble();
				multiplicar(mul1, mul2);
				opciones();
				calcular();
				break;
				
			case 4:
				System.out.println("DIVIDIR");
				System.out.println("Ingrese el primer numero");
				double div1 = scn.nextDouble();
				System.out.println("Ingrese el segundo numero");
				double div2 = scn.nextDouble();
				dividir(div1, div2);
				opciones();
				calcular();
				break;
				
			case 5:
				iniciar();
				calcular();
				break;
				
			case 6:
				System.out.println("Cerrando calculadora...");
				System.exit(0);
				break;
				
 
			default:
				System.out.println("Ingrese un numero de las opciones:");
				calcular();
			}
			
		}
		
		
	}
	

	
	public static void sumar(double num1, double num2) {
		double suma = 0;
		suma = num1 + num2;
		System.out.println("Resultado: " + num1 + " + " + num2 + " = " + suma);	
	}

	public static void restar(double num1, double num2) {
		double resta = 0;
		resta = num1 - num2;
		System.out.println("Resultado: " + num1 + " - " + num2 + " = " + resta);	
	}
	
	private static void multiplicar(double num1, double num2) {
		double multi = 0;
		multi = num1 * num2;
		System.out.println("Resultado: " + num1 + " * " + num2 + " = " + multi);	
	}

	public static void dividir(double num1, double num2) {
		double divi = 0;
		if(num2 != 0) {
			divi = num1 / num2;
			System.out.println("Resultado: " + num1 + " / " + num2 + " = " + divi);		
		}
		else
			System.out.println("No es posible dividir por 0");
		
		
	}
}
