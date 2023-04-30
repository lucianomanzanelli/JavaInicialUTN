package Clase8;

public abstract class Descuento {

	private double valor;
	
	public double dameValor() {
		return valor;
	}
	
	public void asignarDescuento(double valor) {
		this.valor = valor;
	}
	
	public abstract double valorFinal(double valorInicial);
	
}
