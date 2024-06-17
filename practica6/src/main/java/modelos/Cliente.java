package modelos;

public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private int dni;
    private String email;
    private int telefono;

    public Cliente() {
    }

    public Cliente(String nombreCliente, int dni, String email, int telefono) {
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    public Cliente(int idCliente, String nombreCliente, int dni, String email, int telefono) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.dni = dni;
        this.email = email;
        this.telefono = telefono;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "idCliente=" + idCliente +
                ", nombreCliente='" + nombreCliente + '\'' +
                ", dni=" + dni +
                ", email='" + email + '\'' +
                ", telefono=" + telefono +
                '}';
    }
}
