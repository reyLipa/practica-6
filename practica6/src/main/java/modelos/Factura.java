package modelos;


import java.time.LocalDate;

public class Factura {
    private int numeroFactura;
    private int idCliente;
    private int idProducto;
    private LocalDate fecha;
    private int cantidad;
    private float total;

    public Factura() {
    }

    public Factura(int idCliente, int idProducto, LocalDate fecha, int cantidad, float total) {
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
    }

    public Factura(int numeroFactura, int idCliente, int idProducto, LocalDate fecha, int cantidad, float total) {
        this.numeroFactura = numeroFactura;
        this.idCliente = idCliente;
        this.idProducto = idProducto;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.total = total;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "numeroFactura=" + numeroFactura +
                ", idCliente=" + idCliente +
                ", idProducto=" + idProducto +
                ", fecha=" + fecha +
                ", cantidad=" + cantidad +
                ", total=" + total +
                '}';
    }
}
