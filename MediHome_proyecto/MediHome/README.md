# MediHome

**Sistema de gestión de servicios médicos domiciliarios**

Proyecto desarrollado en Java para representar el proceso de solicitud, programación y prestación de una atención médica domiciliaria. Incluye un modelo de clases UML realizado para Visual Paradigm y una demostración funcional mediante consola.

## Integrantes

- Sara Valentina Delgado Muñoz
- Andres David Delgado Castillo

## Descripción del sistema

MediHome permite representar los siguientes elementos del servicio:

- Registro de la empresa y organización de profesionales en equipos médicos por zona de cobertura.
- Registro de pacientes y profesionales de salud como usuarios del sistema.
- Solicitud de servicios domiciliarios y asignación del profesional responsable.
- Gestión de estados del servicio: `SOLICITADO`, `PROGRAMADO`, `EN_ATENCION`, `FINALIZADO` y `CANCELADO`.
- Registro de una atención médica asociada al servicio, con observaciones y recomendaciones.
- Registro de mediciones de signos vitales durante la atención.
- Notificaciones por consola y generación de un reporte final.

## Tecnologías y requisitos

- Java (JDK 11 o superior).
- Visual Paradigm 18.1 para consultar y editar el diagrama UML (`.vpp`).
- No requiere dependencias externas para ejecutar el programa Java.

## Estructura del repositorio

```text
MediHome/
├── src/
│   ├── Main.java
│   ├── Empresa.java
│   ├── Usuario.java
│   ├── Paciente.java
│   ├── ProfesionalSalud.java
│   ├── EquipoMedico.java
│   ├── ServicioDomiciliario.java
│   ├── AtencionMedica.java
│   ├── MedicionSignos.java
│   ├── EstadoServicio.java
│   └── INotificable.java
├── diagrama/
│   ├── MediHome.vpp
│   ├── MediHome.png
│   └── MediHome.xmi
└── README.md
```

## Ejecución

Desde la raíz del repositorio, con el JDK instalado:

```bash
javac -encoding UTF-8 -d out src/*.java
java -cp out Main
```

Al ejecutar `Main`, se desarrolla un caso de ejemplo: se crean una empresa, un equipo, un paciente y un profesional; se solicita y programa un servicio; se registra la atención con sus signos vitales; y se presenta un reporte en consola. Esta entrega es una demostración por consola, no una aplicación con interfaz gráfica ni almacenamiento persistente.

## Modelo UML

El modelo utiliza programación orientada a objetos y relaciones UML para representar las reglas del dominio:

| Elementos | Relación | Cardinalidad / significado |
|---|---|---|
| `Paciente`, `ProfesionalSalud` y `Usuario` | Herencia | Ambos tipos de usuario heredan de `Usuario`. |
| `INotificable` y usuarios | Realización de interfaz | La capacidad de notificar se representa conforme al modelo de clases. |
| `Paciente` — `ServicioDomiciliario` | Asociación | Un paciente solicita `0..*` servicios; cada servicio corresponde a `1` paciente. |
| `ProfesionalSalud` — `ServicioDomiciliario` | Asociación | Un profesional atiende `0..*` servicios; un servicio tiene `0..1` profesional asignado. |
| `EquipoMedico` — `ProfesionalSalud` | Agregación | Un equipo reúne `0..*` profesionales; un profesional pertenece a `0..1` equipo. |
| `ServicioDomiciliario` — `AtencionMedica` | Composición | Un servicio tiene `0..1` atención; cada atención pertenece a `1` servicio. |
| `AtencionMedica` — `MedicionSignos` | Composición | Una atención registra `0..*` mediciones; cada medición pertenece a `1` atención. |

`EstadoServicio` se modela como una enumeración. El modelo también incluye la organización de equipos por parte de la empresa.

### Archivos del diagrama

- **[`MediHome.png`](diagrama/MediHome.png):** vista del diagrama de clases.
- **[`MediHome.vpp`](diagrama/MediHome.vpp):** proyecto editable en Visual Paradigm.
- **[`MediHome.xmi`](diagrama/MediHome.xmi):** respaldo del modelo UML en formato de intercambio.

## Alcance

El proyecto presenta un caso de uso ejecutable que demuestra la instanciación de `Paciente`, `ProfesionalSalud`, `ServicioDomiciliario`, `AtencionMedica` y `MedicionSignos`, así como sus relaciones y el reporte final de la atención prestada.
