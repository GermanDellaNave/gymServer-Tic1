package gym.gymServer.Classes;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Objects;

public class ActividadesID implements Serializable {

    private String nombre;

    private LocalTime hora;

    private LocalDate dia;

    private CentrosDeportivos centroDeportivo;

    public ActividadesID(String nombre, LocalTime hora, LocalDate dia, CentrosDeportivos centroDeportivo) {
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
        this.centroDeportivo = centroDeportivo;
    }

    public ActividadesID(String nombre, LocalTime hora, LocalDate dia) {
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
    }

    public ActividadesID() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ActividadesID that = (ActividadesID) o;
        return Objects.equals(nombre, that.nombre) && Objects.equals(hora, that.hora) && Objects.equals(dia, that.dia) && Objects.equals(centroDeportivo, that.centroDeportivo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, hora, dia, centroDeportivo);
    }

    @Override
    public String toString() {
        return "ActividadesID{" +
                "nombre='" + nombre + '\'' +
                ", hora=" + hora +
                ", dia=" + dia +
                ", centroDeportivo=" + centroDeportivo +
                '}';
    }
}
