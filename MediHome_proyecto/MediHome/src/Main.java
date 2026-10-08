import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

    public static void main(String[] args) {
        Empresa empresa = new Empresa("900123456", "MediHome", "contacto@medihome.com",
                "6021234567", "Pasto, Nariño");
        EquipoMedico equipo = new EquipoMedico("EQ-01", "Equipo Norte", "Zona Norte");
        empresa.agregarEquipo(equipo);

        Paciente paciente = new Paciente("100200300", "Ana Torres", "ana@correo.com",
                "3001234567", "Calle 10 # 20-30");
        ProfesionalSalud profesional = new ProfesionalSalud("80012345", "Carlos Ruiz",
                "carlos@medihome.com", "RM-2026-01", "Medicina general");
        equipo.agregarProfesional(profesional);

        LocalDateTime fecha = LocalDateTime.of(2026, 10, 8, 9, 0);
        ServicioDomiciliario servicio = new ServicioDomiciliario("SD-001", fecha,
                paciente.getDireccion(), "Control general de salud", paciente);
        servicio.programar(profesional);

        AtencionMedica atencion = servicio.iniciarAtencion(fecha);
        MedicionSignos medicion = new MedicionSignos(fecha.plusMinutes(10),
                36.7, 76, 118, 78, 98.0);
        atencion.registrarMedicion(medicion);
        atencion.finalizar(fecha.plusMinutes(40),
                "Paciente estable durante la visita.",
                "Mantener hidratación y asistir a controles periódicos.");

        imprimirReporte(empresa, servicio);
    }

    private static void imprimirReporte(Empresa empresa, ServicioDomiciliario servicio) {
        Paciente p = servicio.getPaciente();
        ProfesionalSalud pro = servicio.getProfesional();
        AtencionMedica a = servicio.getAtencion();

        System.out.println("\n========================================");
        System.out.println("        REPORTE DE ATENCIÓN - MEDIHOME");
        System.out.println("========================================");
        System.out.println("Empresa: " + empresa.getNombre());
        System.out.println("Servicio: " + servicio.getCodigoUnico());
        System.out.println("Estado: " + servicio.getEstado());
        System.out.println("Paciente: " + p.getNombre() + " (" + p.getIdentificacion() + ")");
        System.out.println("Profesional: " + pro.getNombre());
        System.out.println("Especialidad: " + pro.getEspecialidad());
        System.out.println("Equipo: " + pro.getEquipo().getNombre());
        System.out.println("Dirección: " + servicio.getDireccionAtencion());
        System.out.println("Motivo: " + servicio.getMotivo());
        System.out.println("Inicio: " + a.getFechaHoraInicio().format(FORMATO));
        System.out.println("Fin: " + a.getFechaHoraFinalizacion().format(FORMATO));
        System.out.println("Observaciones: " + a.getObservaciones());
        System.out.println("Recomendaciones: " + a.getRecomendaciones());
        System.out.println("\nSIGNOS VITALES (" + a.getMediciones().size() + " medición/es)");
        for (MedicionSignos m : a.getMediciones()) {
            System.out.println("  Fecha: " + m.getFechaHora().format(FORMATO));
            System.out.println("  Temperatura: " + m.getTemperatura() + " °C");
            System.out.println("  Frecuencia cardíaca: " + m.getFrecuenciaCardiaca() + " lpm");
            System.out.println("  Presión arterial: " + m.getPresionSistolica() + "/"
                    + m.getPresionDiastolica() + " mmHg");
            System.out.println("  Saturación de oxígeno: " + m.getSaturacionOxigeno() + "%");
        }
        System.out.println("========================================");
    }
}
