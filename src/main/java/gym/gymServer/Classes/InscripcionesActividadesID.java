package gym.gymServer.Classes;

import javax.persistence.Column;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class InscripcionesActividadesID implements Serializable {

    private String empleadoMailInscripcion;

    private String actividadNombreInscripcion;

    private LocalDate actividadDiaInscripcion;

    private LocalTime actividadHoraInscripcion;

    public InscripcionesActividadesID() {
    }

    public InscripcionesActividadesID(String empleadoMailInscripcion, String actividadNombreInscripcion, LocalDate actividadDiaInscripcion, LocalTime actividadHoraInscripcion) {
        this.empleadoMailInscripcion = empleadoMailInscripcion;
        this.actividadNombreInscripcion = actividadNombreInscripcion;
        this.actividadDiaInscripcion = actividadDiaInscripcion;
        this.actividadHoraInscripcion = actividadHoraInscripcion;
    }

    public String getEmpleadoMailInscripcion() {
        return empleadoMailInscripcion;
    }

    public void setEmpleadoMailInscripcion(String empleadoMailInscripcion) {
        this.empleadoMailInscripcion = empleadoMailInscripcion;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InscripcionesActividadesID that = (InscripcionesActividadesID) o;
        return Objects.equals(empleadoMailInscripcion, that.empleadoMailInscripcion) && Objects.equals(actividadNombreInscripcion, that.actividadNombreInscripcion) && Objects.equals(actividadDiaInscripcion, that.actividadDiaInscripcion) && Objects.equals(actividadHoraInscripcion, that.actividadHoraInscripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empleadoMailInscripcion, actividadNombreInscripcion, actividadDiaInscripcion, actividadHoraInscripcion);
    }

    @Override
    public String toString() {
        return "InscripcionesActividadesID{" +
                "empleadoMailInscripcion='" + empleadoMailInscripcion + '\'' +
                ", actividadNombreInscripcion='" + actividadNombreInscripcion + '\'' +
                ", actividadDiaInscripcion=" + actividadDiaInscripcion +
                ", actividadHoraInscripcion=" + actividadHoraInscripcion +
                '}';
    }
}
