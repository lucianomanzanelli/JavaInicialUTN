package Clase8;

public class DescuentoFijo extends Descuento {

	@Override
	public double valorFinal(double valorInicial) {
		
		return valorInicial - this.dameValor();
	}

}
