package gym.gymServer.Classes;


import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "inscripcionesEmpleadoActividad")
@IdClass(value=InscripcionesActividadesID.class)
@Component
public class InscripcionesActividades {

    private @Id String empleadoMailInscripcion;

    private @Id String actividadNombreInscripcion;

    private @Id LocalDate actividadDiaInscripcion;

    private @Id LocalTime actividadHoraInscripcion;

    private @Id String actividadCentroInscripcion;

    private boolean asistencia;

    @ManyToOne(targetEntity = Empleado.class)
    @JoinColumn(name = "empleadoMailInscripcion", referencedColumnName = "mailEmpleado", insertable = false, updatable = false)
    private Empleado empleado;

    @ManyToOne(targetEntity = Actividad.class, fetch = FetchType.LAZY)
    @JoinColumns( {
        @JoinColumn(name = "actividadNombreInscripcion", referencedColumnName = "nombreActividad", insertable = false, updatable = false),
        @JoinColumn(name = "actividadDiaInscripcion", referencedColumnName = "diaActividad", insertable = false, updatable = false),
        @JoinColumn(name = "actividadHoraInscripcion", referencedColumnName = "horaActividad", insertable = false, updatable = false),
        @JoinColumn(name = "actividadCentroInscripcion", referencedColumnName = "centroMailActividad", insertable = false, updatable = false),
    })
    private Actividad actividad;

    public InscripcionesActividades() {
    }

    public InscripcionesActividades(String empleadoMailInscripciones, String actividadNombreInscripcion, LocalDate actividadDiaInscripcion, LocalTime actividadHoraInscripcion, boolean asistencia, Empleado empleado, Actividad actividad) {
        this.empleadoMailInscripcion = empleadoMailInscripciones;
        this.actividadNombreInscripcion = actividadNombreInscripcion;
        this.actividadDiaInscripcion = actividadDiaInscripcion;
        this.actividadHoraInscripcion = actividadHoraInscripcion;
        this.asistencia = asistencia;
        this.empleado = empleado;
        this.actividad = actividad;
    }

    public String getEmpleadoMailInscripciones() {
        return empleadoMailInscripcion;
    }

    public void setEmpleadoMailInscripciones(String empleadoMailInscripciones) {
        this.empleadoMailInscripcion = empleadoMailInscripciones;
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

    public String getEmpleadoMailInscripcion() {
        return empleadoMailInscripcion;
    }

    public void setEmpleadoMailInscripcion(String empleadoMailInscripcion) {
        this.empleadoMailInscripcion = empleadoMailInscripcion;
    }

    public String getActividadCentroInscripcion() {
        return actividadCentroInscripcion;
    }

    public void setActividadCentroInscripcion(String actividadCentroInscripcion) {
        this.actividadCentroInscripcion = actividadCentroInscripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscripcionesActividades that = (InscripcionesActividades) o;
        return asistencia == that.asistencia && Objects.equals(empleadoMailInscripcion, that.empleadoMailInscripcion) && Objects.equals(actividadNombreInscripcion, that.actividadNombreInscripcion) && Objects.equals(actividadDiaInscripcion, that.actividadDiaInscripcion) && Objects.equals(actividadHoraInscripcion, that.actividadHoraInscripcion) && Objects.equals(empleado, that.empleado) && Objects.equals(actividad, that.actividad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleadoMailInscripcion, actividadNombreInscripcion, actividadDiaInscripcion, actividadHoraInscripcion, asistencia, empleado, actividad);
    }

    @Override
    public String toString() {
        return "InscripcionesActividades{" +
                "empleadoMailInscripciones='" + empleadoMailInscripcion + '\'' +
                ", actividadNombreInscripcion='" + actividadNombreInscripcion + '\'' +
                ", actividadDiaInscripcion=" + actividadDiaInscripcion +
                ", actividadHoraInscripcion=" + actividadHoraInscripcion +
                ", asistencia=" + asistencia +
                ", empleado=" + empleado +
                ", actividad=" + actividad +
                '}';
    }
}
