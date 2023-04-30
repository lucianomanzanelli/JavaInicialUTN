package Clase8;

public class Carrito {
	
	private int numero;
	private Cliente cliente;
	private double montoTotal;
	
	public Carrito(int numero, Cliente cliente) {
		this.numero = numero;
		this.cliente = cliente;
		this.montoTotal = 0;
	}
	
	public int dameNumero() {
		return numero;
	}
	public Cliente dameCliente() {
		return cliente;
	}
	public double dameMonto() {
		return montoTotal;
	}
	
	public void mostrarMontoTotal(double monto) {
		System.out.println("===========================================");
		System.out.println("El monto total del carrito es: $" + String.format("%.2f", monto));
		System.out.println("===========================================");
	}

}
