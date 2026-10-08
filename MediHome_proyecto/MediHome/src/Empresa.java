import java.util.ArrayList;
import java.util.List;

public class Empresa {
    private String identificacion;
    private String nombre;
    private String correo;
    private String telefono;
    private String direccionPrincipal;
    private final List<EquipoMedico> equipos = new ArrayList<>();

    public Empresa(String identificacion, String nombre, String correo,
                   String telefono, String direccionPrincipal) {
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.direccionPrincipal = direccionPrincipal;
    }

    public String getNombre() { return nombre; }
    public String getIdentificacion() { return identificacion; }
    public String getCorreo() { return correo; }
    public String getTelefono() { return telefono; }
    public String getDireccionPrincipal() { return direccionPrincipal; }
    public void agregarEquipo(EquipoMedico equipo) {
        if (equipo != null && !equipos.contains(equipo)) equipos.add(equipo);
    }
    public List<EquipoMedico> getEquipos() { return new ArrayList<>(equipos); }
}
