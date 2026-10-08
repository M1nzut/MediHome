import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AtencionMedica {
    private final ServicioDomiciliario servicio;
    private LocalDateTime fechaHoraInicio;
    private LocalDateTime fechaHoraFinalizacion;
    private String observaciones = "";
    private String recomendaciones = "";
    private final List<MedicionSignos> mediciones = new ArrayList<>();

    AtencionMedica(ServicioDomiciliario servicio, LocalDateTime fechaHoraInicio) {
        this.servicio = servicio;
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public void registrarMedicion(MedicionSignos medicion) {
        if (fechaHoraFinalizacion != null) throw new IllegalStateException("La atención ya finalizó");
        if (medicion == null) throw new IllegalArgumentException("La medición es obligatoria");
        if (mediciones.contains(medicion)) return;
        if (medicion.getAtencion() != null && medicion.getAtencion() != this)
            throw new IllegalStateException("La medición pertenece a otra atención");
        medicion.asignarAtencion(this);
        mediciones.add(medicion);
    }

    public void finalizar(LocalDateTime fin, String observaciones, String recomendaciones) {
        if (fechaHoraFinalizacion != null) throw new IllegalStateException("La atención ya finalizó");
        if (fin.isBefore(fechaHoraInicio)) throw new IllegalArgumentException("Fecha de fin inválida");
        this.fechaHoraFinalizacion = fin;
        this.observaciones = observaciones;
        this.recomendaciones = recomendaciones;
        servicio.finalizar();
        servicio.getPaciente().notificar("La atención " + servicio.getCodigoUnico() + " finalizó");
    }

    public ServicioDomiciliario getServicio() { return servicio; }
    public LocalDateTime getFechaHoraInicio() { return fechaHoraInicio; }
    public LocalDateTime getFechaHoraFinalizacion() { return fechaHoraFinalizacion; }
    public String getObservaciones() { return observaciones; }
    public String getRecomendaciones() { return recomendaciones; }
    public List<MedicionSignos> getMediciones() { return new ArrayList<>(mediciones); }
}
