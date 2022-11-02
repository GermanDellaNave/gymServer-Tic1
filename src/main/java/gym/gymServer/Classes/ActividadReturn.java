package gym.gymServer.Classes;

import javax.persistence.Lob;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class ActividadReturn {

    String centro_mail_actividad;

    LocalDate dia_actividad;

    LocalTime hora_actividad;

    String nombre_actividad;

    Integer costo;

    Integer cupos;

    Date date_creada;

    String descripcion;

    Integer duracion;

    @Lob
    String imagen;

    Boolean reservable;

    CentrosDeportivos centro;

    public ActividadReturn(String centro_mail_actividad, LocalDate dia_actividad, LocalTime hora_actividad, String nombre_actividad, Integer costo, Integer cupos, Date date_creada, String descripcion, Integer duracion, String imagen, Boolean reservable, CentrosDeportivos centro) {
        this.centro_mail_actividad = centro_mail_actividad;
        this.dia_actividad = dia_actividad;
        this.hora_actividad = hora_actividad;
        this.nombre_actividad = nombre_actividad;
        this.costo = costo;
        this.cupos = cupos;
        this.date_creada = date_creada;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.imagen = imagen;
        this.reservable = reservable;
        this.centro = centro;
    }

    public String getCentro_mail_actividad() {
        return centro_mail_actividad;
    }

    public void setCentro_mail_actividad(String centro_mail_actividad) {
        this.centro_mail_actividad = centro_mail_actividad;
    }

    public LocalDate getDia_actividad() {
        return dia_actividad;
    }

    public void setDia_actividad(LocalDate dia_actividad) {
        this.dia_actividad = dia_actividad;
    }

    public LocalTime getHora_actividad() {
        return hora_actividad;
    }

    public void setHora_actividad(LocalTime hora_actividad) {
        this.hora_actividad = hora_actividad;
    }

    public String getNombre_actividad() {
        return nombre_actividad;
    }

    public void setNombre_actividad(String nombre_actividad) {
        this.nombre_actividad = nombre_actividad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }

    public Integer getCupos() {
        return cupos;
    }

    public void setCupos(Integer cupos) {
        this.cupos = cupos;
    }

    public Date getDate_creada() {
        return date_creada;
    }

    public void setDate_creada(Date date_creada) {
        this.date_creada = date_creada;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getDuracion() {
        return duracion;
    }

    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Boolean getReservable() {
        return reservable;
    }

    public void setReservable(Boolean reservable) {
        this.reservable = reservable;
    }

    public CentrosDeportivos getCentro() {
        return centro;
    }

    public void setCentro(CentrosDeportivos centro) {
        this.centro = centro;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActividadReturn that = (ActividadReturn) o;
        return Objects.equals(centro_mail_actividad, that.centro_mail_actividad) && Objects.equals(dia_actividad, that.dia_actividad) && Objects.equals(hora_actividad, that.hora_actividad) && Objects.equals(nombre_actividad, that.nombre_actividad) && Objects.equals(costo, that.costo) && Objects.equals(cupos, that.cupos) && Objects.equals(date_creada, that.date_creada) && Objects.equals(descripcion, that.descripcion) && Objects.equals(duracion, that.duracion) && Objects.equals(imagen, that.imagen) && Objects.equals(reservable, that.reservable) && Objects.equals(centro, that.centro);
    }

    @Override
    public int hashCode() {
        return Objects.hash(centro_mail_actividad, dia_actividad, hora_actividad, nombre_actividad, costo, cupos, date_creada, descripcion, duracion, imagen, reservable, centro);
    }

    @Override
    public String toString() {
        return "ActividadReturn{" +
                "centro_mail_actividad='" + centro_mail_actividad + '\'' +
                ", dia_actividad=" + dia_actividad +
                ", hora_actividad=" + hora_actividad +
                ", nombre_actividad='" + nombre_actividad + '\'' +
                ", costo=" + costo +
                ", cupos=" + cupos +
                ", date_creada=" + date_creada +
                ", descripcion='" + descripcion + '\'' +
                ", duracion=" + duracion +
                ", imagen='" + imagen + '\'' +
                ", reservable=" + reservable +
                ", centro=" + centro +
                '}';
    }
}
