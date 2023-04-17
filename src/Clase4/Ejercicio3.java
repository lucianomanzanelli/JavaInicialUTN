package Clase4;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Ejercicio3 {
	
	public static void main(String[] args) {
	    String frase = "Agustin;Daniel;Bruno;Marcos;Nacho;Julieta;Olivia";
	    String[] vectorSplit = frase.split(";");

	    int i = 1;
	    for (String nombre : vectorSplit) {
	        System.out.println(i + " nombre: " + nombre);
	        i++;
	    }

	    // Escribir el vector en un archivo
	    File archivo = new File("D:\\Users\\LManzanelli\\Desktop\\hola.txt");
	    try (FileWriter escritor = new FileWriter(archivo)) {
	        for (String nombre : vectorSplit) {
	            escritor.write(nombre + "\n");
	        }
	        System.out.println("El archivo se ha escrito correctamente.");
	    } catch (IOException e) {
	        System.out.println("Error al escribir en el archivo.");
	        e.printStackTrace();
	    }
	}


}
