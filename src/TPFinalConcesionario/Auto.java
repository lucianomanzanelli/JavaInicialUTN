package TPFinalConcesionario;

public class Auto extends Vehiculo {
    private int cant_puertas;
    private String combustible;
    

    public Auto() {
    	super();
    	this.cant_puertas = 0;
        this.combustible = "";
	}

	public int getCant_puertas() {
        return cant_puertas;
    }

    public void setCant_puertas(int cant_puertas) {
        this.cant_puertas = cant_puertas;
    }

    public String getCombustible() {
        return combustible;
    }

    public void setCombustible(String combustible) {
        this.combustible = combustible;
    }
}

