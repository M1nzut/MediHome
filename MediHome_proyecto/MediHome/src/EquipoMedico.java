import java.util.ArrayList;
import java.util.List;

public class EquipoMedico {
    private String codigo;
    private String nombre;
    private String zonaCobertura;
    private final List<ProfesionalSalud> profesionales = new ArrayList<>();

    public EquipoMedico(String codigo, String nombre, String zonaCobertura) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.zonaCobertura = zonaCobertura;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getZonaCobertura() { return zonaCobertura; }
    public List<ProfesionalSalud> getProfesionales() { return new ArrayList<>(profesionales); }

    public void agregarProfesional(ProfesionalSalud profesional) {
        if (profesional == null) throw new IllegalArgumentException("El profesional es obligatorio");
        if (profesional.getEquipo() != null && profesional.getEquipo() != this) {
            profesional.getEquipo().quitarProfesional(profesional);
        }
        if (!profesionales.contains(profesional)) profesionales.add(profesional);
        profesional.setEquipo(this);
    }

    public void quitarProfesional(ProfesionalSalud profesional) {
        if (profesionales.remove(profesional)) profesional.setEquipo(null);
    }
}
