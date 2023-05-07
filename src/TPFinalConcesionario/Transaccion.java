package TPFinalConcesionario;

import java.time.LocalDate;

public class Transaccion {
    private int id_transaccion;
    private int id_cliente;
    private int id_vehiculo;
    private int id_vendedor;
    private LocalDate fecha;
    private String tipo;
    
    public Transaccion(Cliente cliente, Vendedor vendedor, Vehiculo vehiculo) {
    	this.id_cliente = cliente.getId_cliente();
        this.id_vehiculo = vehiculo.getId_vehiculo();
        this.id_vendedor = vendedor.getId_vendedor();
        this.fecha = LocalDate.now();
        this.tipo = "";
    }


    // getters y setters
    public int getId_transaccion() {
        return id_transaccion;
    }

    public void setId_transaccion(int id_transaccion) {
        this.id_transaccion = id_transaccion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public int getId_vehiculo() {
        return id_vehiculo;
    }

    public void setId_vehiculo(int id_vehiculo) {
        this.id_vehiculo = id_vehiculo;
    }

    public int getId_vendedor() {
        return id_vendedor;
    }

    public void setId_vendedor(int id_vendedor) {
        this.id_vendedor = id_vendedor;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
