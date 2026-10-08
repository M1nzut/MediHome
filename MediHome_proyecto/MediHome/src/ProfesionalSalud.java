import java.util.ArrayList;
import java.util.List;

public class ProfesionalSalud extends Usuario {
    private String numeroRegistroProfesional;
    private String especialidad;
    private EquipoMedico equipo;
    private final List<ServicioDomiciliario> servicios = new ArrayList<>();

    public ProfesionalSalud(String identificacion, String nombre, String correo,
                            String numeroRegistroProfesional, String especialidad) {
        super(identificacion, nombre, correo);
        this.numeroRegistroProfesional = numeroRegistroProfesional;
        this.especialidad = especialidad;
    }

    public String getNumeroRegistroProfesional() { return numeroRegistroProfesional; }
    public String getEspecialidad() { return especialidad; }
    public EquipoMedico getEquipo() { return equipo; }
    void setEquipo(EquipoMedico equipo) { this.equipo = equipo; }
    public List<ServicioDomiciliario> getServicios() { return new ArrayList<>(servicios); }
    public void agregarServicio(ServicioDomiciliario servicio) {
        if (!servicios.contains(servicio)) servicios.add(servicio);
    }
}
