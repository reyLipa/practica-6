package modelos;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private int stock;
    private float precio;

    public Producto(String nombreCliente, int dni, float email, int telefono) {
    }

    public Producto(String nombreProducto, int stock, float precio) {

        this.nombreProducto = nombreProducto;
        this.stock = stock;
        this.precio = precio;
    }


    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "idProducto=" + idProducto +
                ", nombreProducto='" + nombreProducto + '\'' +
                ", stock=" + stock +
                ", precio=" + precio +
                '}';
    }
}
