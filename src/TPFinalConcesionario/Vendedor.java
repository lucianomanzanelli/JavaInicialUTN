package TPFinalConcesionario;

public class Vendedor {
    private int id_vendedor;
    private int legajo;
    private String nombre;
    private String apellido;

    
    public Vendedor() {
        this.legajo = 0;
        this.nombre = "";
        this.apellido = "";
    }

    // getters y setters
    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public int getLegajo() {
        return legajo;
    }

    public void setLegajo(int legajo) {
        this.legajo = legajo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}

