import java.time.LocalDateTime;

public class MedicionSignos {
    private LocalDateTime fechaHora;
    private double temperatura;
    private int frecuenciaCardiaca;
    private int presionSistolica;
    private int presionDiastolica;
    private double saturacionOxigeno;
    private AtencionMedica atencion;

    public MedicionSignos(LocalDateTime fechaHora, double temperatura,
                          int frecuenciaCardiaca, int presionSistolica,
                          int presionDiastolica, double saturacionOxigeno) {
        this.fechaHora = fechaHora;
        this.temperatura = temperatura;
        this.frecuenciaCardiaca = frecuenciaCardiaca;
        this.presionSistolica = presionSistolica;
        this.presionDiastolica = presionDiastolica;
        this.saturacionOxigeno = saturacionOxigeno;
    }

    void asignarAtencion(AtencionMedica atencion) { this.atencion = atencion; }
    public AtencionMedica getAtencion() { return atencion; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public double getTemperatura() { return temperatura; }
    public int getFrecuenciaCardiaca() { return frecuenciaCardiaca; }
    public int getPresionSistolica() { return presionSistolica; }
    public int getPresionDiastolica() { return presionDiastolica; }
    public double getSaturacionOxigeno() { return saturacionOxigeno; }
}
