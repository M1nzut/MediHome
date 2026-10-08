import java.time.LocalDateTime;

public class ServicioDomiciliario {
    private String codigoUnico;
    private LocalDateTime fechaHora;
    private String direccionAtencion;
    private String motivo;
    private EstadoServicio estado;
    private final Paciente paciente;
    private ProfesionalSalud profesional;
    private AtencionMedica atencion;

    public ServicioDomiciliario(String codigoUnico, LocalDateTime fechaHora,
                                String direccionAtencion, String motivo, Paciente paciente) {
        if (paciente == null) throw new IllegalArgumentException("El paciente es obligatorio");
        this.codigoUnico = codigoUnico;
        this.fechaHora = fechaHora;
        this.direccionAtencion = direccionAtencion;
        this.motivo = motivo;
        this.paciente = paciente;
        this.estado = EstadoServicio.SOLICITADO;
        paciente.agregarServicio(this);
    }

    public void programar(ProfesionalSalud profesional) {
        if (estado != EstadoServicio.SOLICITADO)
            throw new IllegalStateException("Solo se pueden programar servicios solicitados");
        if (profesional == null) throw new IllegalArgumentException("El profesional es obligatorio");
        this.profesional = profesional;
        profesional.agregarServicio(this);
        estado = EstadoServicio.PROGRAMADO;
        paciente.notificar("Servicio " + codigoUnico + " programado");
        profesional.notificar("Se le asignó el servicio " + codigoUnico);
    }

    public AtencionMedica iniciarAtencion(LocalDateTime inicio) {
        if (estado != EstadoServicio.PROGRAMADO)
            throw new IllegalStateException("El servicio debe estar programado");
        atencion = new AtencionMedica(this, inicio);
        estado = EstadoServicio.EN_ATENCION;
        return atencion;
    }

    void finalizar() { estado = EstadoServicio.FINALIZADO; }
    public void cancelar() {
        if (estado != EstadoServicio.SOLICITADO && estado != EstadoServicio.PROGRAMADO)
            throw new IllegalStateException("No se puede cancelar en este estado");
        estado = EstadoServicio.CANCELADO;
    }

    public String getCodigoUnico() { return codigoUnico; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getDireccionAtencion() { return direccionAtencion; }
    public String getMotivo() { return motivo; }
    public EstadoServicio getEstado() { return estado; }
    public Paciente getPaciente() { return paciente; }
    public ProfesionalSalud getProfesional() { return profesional; }
    public AtencionMedica getAtencion() { return atencion; }
}
