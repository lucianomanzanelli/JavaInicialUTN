package Clase8;

public class DescuentoPorcentaje extends Descuento {

	@Override
	public double valorFinal(double valorInicial) {
		return valorInicial - (valorInicial * this.dameValor());
	}

}
