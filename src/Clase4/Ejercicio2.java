package Clase4;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Ejercicio2 {

	public static void main(String[] args) {


		String ruta = "D:\\Users\\LManzanelli\\Desktop\\hola.txt";
		String sumMult = "M";
		
		if(sumMult.equals("S")) {
			sumarArchivo(ruta);
		}
		else if(sumMult.equals("M")) {
			multiplicarArchivo(ruta);
		}
		else
			System.out.println("Debe elegir si sumar o multiplicar");
		

		
	}

	private static void sumarArchivo(String ruta) {

		try {

			for(String numeros : Files.readAllLines(Paths.get(ruta))) {
				System.out.println("Dato a sumar: " + numeros);
			}

			int sumaValores = sumaValores("D:\\Users\\LManzanelli\\Desktop\\hola.txt");
			System.out.println("La suma es: "+ sumaValores);
				
			
		} catch (IOException e) {

			System.out.println("El archivo no exixte");;

		}
	}

	private static void multiplicarArchivo(String ruta) {

		try {
			for(String numeros : Files.readAllLines(Paths.get(ruta))) {
				System.out.println("Dato a multiplicar: " + numeros);
			}
			
			int multiplicacionValores = multiplicacionValores("D:\\Users\\LManzanelli\\Desktop\\hola.txt");
			System.out.println("La multiplicacion es: "+ multiplicacionValores);
			
		} 
		
		catch (IOException e) {

			System.out.println("El archivo no exixte");;

		}
	}
	

	public static int multiplicacionValores(String datosArchivo) throws FileNotFoundException {

		File archivo = new File("D:\\Users\\LManzanelli\\Desktop\\hola.txt");
		int multiplicacion = 1;
		
		try (Scanner multNumeros = new Scanner(archivo)) {
			while (multNumeros.hasNextInt()) { 
				multiplicacion *= multNumeros.nextInt();
			}
		}
		
		return multiplicacion;
	}

	public static int sumaValores(String datosArchivo) throws FileNotFoundException {

		File archivo = new File("D:\\Users\\LManzanelli\\Desktop\\hola.txt");

		int sumaInt=0;

		try (Scanner sumaNumeros = new Scanner(archivo)) {
			while (sumaNumeros.hasNextInt()) { 
				sumaInt = sumaInt + sumaNumeros.nextInt();
			}
		}

		 return sumaInt;
	}
}
