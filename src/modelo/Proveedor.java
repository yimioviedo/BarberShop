package modelo;

public class Proveedor {
    
    private int id;
    private String nombreEmpresa;
    private String nombreContacto;
    private String email;
    private String telefono;

    public Proveedor(int id, String nombreEmpresa, String nombreContacto, String email, String telefono) {
        this.id = id;
        this.nombreEmpresa = nombreEmpresa;
        this.nombreContacto = nombreContacto;
        
   
        this.email = email;
        this.telefono = telefono;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public String getNombreContacto() {
        return nombreContacto;
    }

    public void setNombreContacto(String nombreContacto) {
        this.nombreContacto = nombreContacto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método toString para representar el proveedor como una cadena
    @Override
    public String toString() {
        return "Proveedor{"
                + "id=" + id
                + ", nombreEmpresa='" + nombreEmpresa + '\''
                + ", nombreContacto='" + nombreContacto + '\''
                + ", email='" + email + '\''
                + ", telefono='" + telefono + '\''
                + '}';
    }
}
    

