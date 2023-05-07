package TPFinalConcesionario;

public class Utilitario extends Vehiculo {
    private String tipo_trabajo;
    private int cant_asientos;

    public Utilitario() {
        super();
        this.tipo_trabajo = "";
        this.cant_asientos = 0;
    }
    
    

    public String getTipo_trabajo() {
        return tipo_trabajo;
    }

    public void setTipo_trabajo(String tipo_trabajo) {
        this.tipo_trabajo = tipo_trabajo;
    }

    public int getCant_asientos() {
        return cant_asientos;
    }

    public void setCant_asientos(int cant_asientos) {
        this.cant_asientos = cant_asientos;
    }
}

