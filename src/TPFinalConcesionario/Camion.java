package TPFinalConcesionario;

public class Camion extends Vehiculo {
    private int capacidad_carga;
    private int cant_ejes;

    
    public Camion() {
        super();
        this.capacidad_carga = 0;
        this.cant_ejes = 0;
    }
    
    public int getCapacidad_carga() {
        return capacidad_carga;
    }

    public void setCapacidad_carga(int capacidad_carga) {
        this.capacidad_carga = capacidad_carga;
    }

    public int getCant_ejes() {
        return cant_ejes;
    }

    public void setCant_ejes(int cant_ejes) {
        this.cant_ejes = cant_ejes;
    }
}

