package gym.gymServer.Classes;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class ActividadesID implements Serializable {

    @Column(name = "nombreActividad")
    private String nombre;

    @Column(name = "horaActividad")
    private LocalTime hora;

    @Column(name = "diaActividad")
    private LocalDate dia;

    @Column(name = "centroMailActividad")
    private String centroMail;

    public ActividadesID(String nombre, LocalTime hora, LocalDate dia, String centroMail) {
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
        this.centroMail = centroMail;
    }

    public ActividadesID() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalDate getDia() {
        return dia;
    }

    public void setDia(LocalDate dia) {
        this.dia = dia;
    }

    public String getCentroMail() {
        return centroMail;
    }

    public void setCentroMail(String centroMail) {
        this.centroMail = centroMail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActividadesID that = (ActividadesID) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(hora, that.hora) && Objects.equals(dia, that.dia) && Objects.equals(centroMail, that.centroMail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, hora, dia, centroMail);
    }

    @Override
    public String toString() {
        return "ActividadesID{" +
                "nombre='" + nombre + '\'' +
                ", hora=" + hora +
                ", dia=" + dia +
                ", centroMail='" + centroMail + '\'' +
                '}';
    }
}
