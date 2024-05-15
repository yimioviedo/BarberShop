package modelo;

import java.time.LocalDateTime;

public class Factura {
    private int id;
    private int clienteId;
    private int productoId;
    private String servicioPrestado;
    private LocalDateTime fechaHora;
    private double total;

    public Factura(int id, int clienteId, int productoId, String servicioPrestado, LocalDateTime fechaHora, double total) {
        this.id = id;
        this.clienteId = clienteId;
        this.productoId = productoId;
        this.servicioPrestado = servicioPrestado;
        this.fechaHora = fechaHora;
        this.total = total;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }

    public String getServicioPrestado() {
        return servicioPrestado;
    }

    public void setServicioPrestado(String servicioPrestado) {
        this.servicioPrestado = servicioPrestado;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    // Método toString para representar la factura como una cadena
    @Override
    public String toString() {
        return "Factura{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", productoId=" + productoId +
                ", servicioPrestado='" + servicioPrestado + '\'' +
                ", fechaHora=" + fechaHora +
                ", total=" + total +
                '}';
    }
}
    

