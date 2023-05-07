package TPFinalConcesionario;

public class Vehiculo {
    private int id_vehiculo;
    private String marca;
    private String modelo;
    private String tipo;
    private double precio;
    private boolean disponible;
    
    public Vehiculo() {
    	this.marca = "";
        this.modelo = "";
        this.tipo = "";
        this.precio = 0;
        this.disponible = true;
    }
    
    
    
    // Getters y Setters
    public int getId_vehiculo() {
        return id_vehiculo;
    }
    
    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }
    
    public String getMarca() {
        return marca;
    }
    
    public void setMarca(String marca) {
        this.marca = marca;
    }
    
    public String getModelo() {
        return modelo;
    }
    
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public double getPrecio() {
        return precio;
    }
    
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public boolean isDisponible() {
        return disponible;
    }
    
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
}

