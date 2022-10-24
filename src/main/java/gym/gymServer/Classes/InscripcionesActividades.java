package gym.gymServer.Classes;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "inscripcionesEmpleadoActividad")
@IdClass(value=InscripcionesActividadesID.class)
public class InscripcionesActividades {

    @Id
    private String empleadoMailInscripciones;

    @Id
    private String actividadNombreInscripcion;

    @Id
    private LocalDate actividadDiaInscripcion;

    @Id
    private LocalTime actividadHoraInscripcion;

    private boolean asistencia;

    @ManyToOne
    @JoinColumn(name = "empleado_mail_inscripcion", referencedColumnName = "mailEmpleado", insertable = false, updatable = false)
    private Empleado empleado;

    @ManyToOne(targetEntity = Actividad.class, fetch = FetchType.LAZY)
    @JoinColumns( {
        @JoinColumn(name = "actividad_nombre_inscripcion", referencedColumnName = "nombreActividad"),
        @JoinColumn(name = "actividad_dia_inscripcion", referencedColumnName = "diaActividad"),
        @JoinColumn(name = "actividad_hora_inscripcion", referencedColumnName = "horaActividad")
    })
    private Actividad actividad;

    public InscripcionesActividades() {
    }

    public InscripcionesActividades(String empleadoMailInscripciones, String actividadNombreInscripcion, LocalDate actividadDiaInscripcion, LocalTime actividadHoraInscripcion, boolean asistencia, Empleado empleado, Actividad actividad) {
        this.empleadoMailInscripciones = empleadoMailInscripciones;
        this.actividadNombreInscripcion = actividadNombreInscripcion;
        this.actividadDiaInscripcion = actividadDiaInscripcion;
        this.actividadHoraInscripcion = actividadHoraInscripcion;
        this.asistencia = asistencia;
        this.empleado = empleado;
        this.actividad = actividad;
    }

    public String getEmpleadoMailInscripciones() {
        return empleadoMailInscripciones;
    }

    public void setEmpleadoMailInscripciones(String empleadoMailInscripciones) {
        this.empleadoMailInscripciones = empleadoMailInscripciones;
    }

    public String getActividadNombreInscripcion() {
        return actividadNombreInscripcion;
    }

    public void setActividadNombreInscripcion(String actividadNombreInscripcion) {
        this.actividadNombreInscripcion = actividadNombreInscripcion;
    }

    public LocalDate getActividadDiaInscripcion() {
        return actividadDiaInscripcion;
    }

    public void setActividadDiaInscripcion(LocalDate actividadDiaInscripcion) {
        this.actividadDiaInscripcion = actividadDiaInscripcion;
    }

    public LocalTime getActividadHoraInscripcion() {
        return actividadHoraInscripcion;
    }

    public void setActividadHoraInscripcion(LocalTime actividadHoraInscripcion) {
        this.actividadHoraInscripcion = actividadHoraInscripcion;
    }

    public boolean isAsistencia() {
        return asistencia;
    }

    public void setAsistencia(boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscripcionesActividades that = (InscripcionesActividades) o;
        return asistencia == that.asistencia && Objects.equals(empleadoMailInscripciones, that.empleadoMailInscripciones) && Objects.equals(actividadNombreInscripcion, that.actividadNombreInscripcion) && Objects.equals(actividadDiaInscripcion, that.actividadDiaInscripcion) && Objects.equals(actividadHoraInscripcion, that.actividadHoraInscripcion) && Objects.equals(empleado, that.empleado) && Objects.equals(actividad, that.actividad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleadoMailInscripciones, actividadNombreInscripcion, actividadDiaInscripcion, actividadHoraInscripcion, asistencia, empleado, actividad);
    }

    @Override
    public String toString() {
        return "InscripcionesActividades{" +
                "empleadoMailInscripciones='" + empleadoMailInscripciones + '\'' +
                ", actividadNombreInscripcion='" + actividadNombreInscripcion + '\'' +
                ", actividadDiaInscripcion=" + actividadDiaInscripcion +
                ", actividadHoraInscripcion=" + actividadHoraInscripcion +
                ", asistencia=" + asistencia +
                ", empleado=" + empleado +
                ", actividad=" + actividad +
                '}';
    }
}
