package gym.gymServer.Classes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Actividades")
@IdClass(value = ActividadesID.class)
@Component
public class Actividad {

    @Column(name = "nombreActividad")
    private @Id String nombre;

    @Column(name = "horaActividad")
    private @Id LocalTime hora;

    @Column(name = "diaActividad")
    private @Id LocalDate dia;

    @Column(name = "centroMailActividad")
    private @Id String centroMail;

    @JsonIgnore
    @ManyToOne(targetEntity = TipoActividad.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "tipo", referencedColumnName = "tipo"/*, updatable = false*/)
    private TipoActividad tipo;

    private String descripcion;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "empleado_actividad", joinColumns = {@JoinColumn(name = "nombre_actividad", referencedColumnName = "nombreActividad"),
//            @JoinColumn(name = "hora_actividad", referencedColumnName = "horaActividad"),
//            @JoinColumn(name = "dia_actividad", referencedColumnName = "diaActividad"),
//            @JoinColumn(name = "centro_actividad", referencedColumnName = "centro_mail")},
//            inverseJoinColumns = @JoinColumn(name = "mail_empleado", referencedColumnName = "mailEmpleado"))
//    private List<Empleado> listaEmpleadoInscriptos;

    private int costo;

    private int cupos;

    private boolean reservable;

    @JsonIgnore
    @ManyToOne(targetEntity = CentrosDeportivos.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "centro", referencedColumnName = "mailCentro"/*, updatable = false*/)
    private CentrosDeportivos centroDeportivo;

    @OneToMany(/*fetch = FetchType.EAGER,*/ mappedBy = "actividad")
    private List<InscripcionesActividades> actividadesInscripto = new ArrayList<>();

    public Actividad() {
        super();
    }

    public Actividad(String nombre, LocalTime hora, LocalDate dia, String centroMail, TipoActividad tipo, String descripcion, int costo, int cupos, boolean reservable, CentrosDeportivos centroDeportivo) {
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
        this.centroMail = centroMail;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.costo = costo;
        this.cupos = cupos;
        this.reservable = reservable;
        this.centroDeportivo = centroDeportivo;
        this.actividadesInscripto = new ArrayList<>();
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

    /*public List<Empleado> getListaEmpleadoInscriptos() {
        return listaEmpleadoInscriptos;
    }

    public void setListaEmpleadoInscriptos(List<Empleado> listaEmpleadoInscriptos) {
        this.listaEmpleadoInscriptos = listaEmpleadoInscriptos;
    }*/

    public String getCentroMail() {
        return centroMail;
    }

    public void setCentroMail(String centroMail) {
        this.centroMail = centroMail;
    }

    public List<InscripcionesActividades> getActividadesInscripto() {
        return actividadesInscripto;
    }

    public void setActividadesInscripto(List<InscripcionesActividades> actividadesInscripto) {
        this.actividadesInscripto = actividadesInscripto;
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
                ", costo=" + costo +
                ", cupos=" + cupos +
                ", reservable=" + reservable +
                ", centroDeportivo=" + centroDeportivo +
                ", actividadesInscripto=" + actividadesInscripto +
                '}';
    }
}