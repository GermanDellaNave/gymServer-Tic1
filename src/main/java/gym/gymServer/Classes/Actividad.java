package gym.gymServer.Classes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table(name = "Actividades")
@IdClass(value = ActividadesID.class)
@Component
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Actividad implements Serializable {

    @Column(name = "nombreActividad")
    private @Id String nombre;

    @Column(name = "horaActividad")
    private @Id LocalTime hora;

    @Column(name = "diaActividad")
    private @Id LocalDate dia;

    @Column(name = "centroMailActividad")
    private @Id String centroMail;

    @ManyToOne(cascade = CascadeType.PERSIST )
    @JoinColumn(name = "tipo", referencedColumnName = "tipo")
    private TipoActividad tipo;

    private String descripcion;

    private int duracion;

    private int costo;

    private int cupos;

    private boolean reservable;

    private Date dateCreada;

    @Lob
    private String imagen;

    @ManyToOne()
    @JoinColumn(name = "centro", referencedColumnName = "mailCentro")
    private CentrosDeportivos centroDeportivo;


    public Actividad() {
        super();
    }



    public Actividad(String nombre, LocalTime hora, LocalDate dia, String centroMail, TipoActividad tipo, String descripcion, int duracion, int costo, int cupos, boolean reservable, Date dateCreada, String imagen, CentrosDeportivos centroDeportivo) {
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
        this.centroMail = centroMail;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.costo = costo;
        this.cupos = cupos;
        this.reservable = reservable;
        this.dateCreada = dateCreada;
        this.imagen = imagen;
        this.centroDeportivo = centroDeportivo;
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

    public TipoActividad getTipo() {
        return tipo;
    }

    public void setTipo(TipoActividad tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCentroMail() {
        return centroMail;
    }

    public void setCentroMail(String centroMail) {
        this.centroMail = centroMail;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public boolean isReservable() {
        return reservable;
    }

    public void setReservable(boolean reservable) {
        this.reservable = reservable;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public Date getDateCreada() {
        return dateCreada;
    }

    public void setDateCreada(Date dateCreada) {
        this.dateCreada = dateCreada;
    }

    public CentrosDeportivos getCentroDeportivo() {
        return centroDeportivo;
    }

    public void setCentroDeportivo(CentrosDeportivos centroDeportivo) {
        this.centroDeportivo = centroDeportivo;
    }


    @Override
    public String toString() {
        return "Actividad{" +
                "nombre='" + nombre + '\'' +
                ", hora=" + hora +
                ", dia=" + dia +
                ", centroMail='" + centroMail + '\'' +
                ", tipo=" + tipo +
                ", descripcion='" + descripcion + '\'' +
                ", duracion=" + duracion +
                ", costo=" + costo +
                ", cupos=" + cupos +
                ", reservable=" + reservable +
                ", dateCreada=" + dateCreada +
                ", imagen='" + imagen + '\'' +
                ", centroDeportivo=" + centroDeportivo +
                '}';
    }
}
