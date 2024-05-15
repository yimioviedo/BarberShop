package modelo;

import java.time.LocalDate;

public class Compra {
    private int id;
    private int proveedorId;
    private int productoId;
    private int cantidad;
    private double precioUnitario;
    private LocalDate fechaCompra;

    public Compra(int id, int proveedorId, int productoId, int cantidad, double precioUnitario, LocalDate fechaCompra) {
        this.id = id;
        this.proveedorId = proveedorId;
        this.productoId = productoId;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fechaCompra = fechaCompra;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProveedorId() {
        return proveedorId;
    }

    public void setProveedorId(int proveedorId) {
        this.proveedorId = proveedorId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public LocalDate getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(LocalDate fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    // Método toString para representar la compra como una cadena
    @Override
    public String toString() {
        return "Compra{" +
                "id=" + id +
                ", proveedorId=" + proveedorId +
                ", productoId=" + productoId +
                ", cantidad=" + cantidad +
                ", precioUnitario=" + precioUnitario +
                ", fechaCompra=" + fechaCompra +
                '}';
    }
}
    

