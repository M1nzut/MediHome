import java.util.ArrayList;
import java.util.List;

public class Paciente extends Usuario {
    private String telefono;
    private String direccion;
    private final List<ServicioDomiciliario> servicios = new ArrayList<>();

    public Paciente(String identificacion, String nombre, String correo,
                    String telefono, String direccion) {
        super(identificacion, nombre, correo);
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public String getTelefono() { return telefono; }
    public String getDireccion() { return direccion; }
    public List<ServicioDomiciliario> getServicios() { return new ArrayList<>(servicios); }

    public void agregarServicio(ServicioDomiciliario servicio) {
        if (!servicios.contains(servicio)) servicios.add(servicio);
    }
}
