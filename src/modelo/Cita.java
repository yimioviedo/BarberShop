package modelo;

import java.time.LocalDateTime;

public class Cita {
    private int id;
    private int clienteId;
    private int barberoId;
    private String estadoCita;
    private LocalDateTime fechaHora;

    public Cita(int id, int clienteId, int barberoId, String estadoCita, LocalDateTime fechaHora) {
        this.id = id;
        this.clienteId = clienteId;
        this.barberoId = barberoId;
        this.estadoCita = estadoCita;
        this.fechaHora = fechaHora;
    }
    
    //Getters y setters
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

    public int getBarberoId() {
        return barberoId;
    }

    public void setBarberoId(int barberoId) {
        this.barberoId = barberoId;
    }

    public String getEstadoCita() {
        return estadoCita;
    }

    public void setEstadoCita(String estadoCita) {
        this.estadoCita = estadoCita;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    // Método toString para representar la cita como una cadena
    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", clienteId=" + clienteId +
                ", barberoId=" + barberoId +
                ", estadoCita='" + estadoCita + '\'' +
                ", fechaHora=" + fechaHora +
                '}';
    }
}
    

