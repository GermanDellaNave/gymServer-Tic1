package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Actividad")
@IdClass(value = ActividadesID.class)
@Component
public class Actividad {

    @Column(name = "nombreActividad")
    private @Id String nombre;

    @Column(name = "horaActividad")
    private @Id LocalTime hora;

    @Column(name = "diaActividad")
    private @Id LocalDate dia;
    private String tipo;

    private String descripcion;

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "empleado_actividad", joinColumns = {@JoinColumn(name = "nombre_actividad", referencedColumnName = "nombreActividad"),
//            @JoinColumn(name = "hora_actividad", referencedColumnName = "horaActividad"),
//            @JoinColumn(name = "dia_actividad", referencedColumnName = "diaActividad"),
//            @JoinColumn(name = "centro_actividad", referencedColumnName = "centro_mail")},
//            inverseJoinColumns = @JoinColumn(name = "mail_empleado", referencedColumnName = "mailEmpleado"))
//    private List<Empleado> listaEmpleadoInscriptos;

    private boolean conCupos;

    private int cupos;

    private boolean reservable;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "centro_mail", referencedColumnName = "mailCentro")
    @Id
    private CentrosDeportivos centroDeportivo;

    @OneToMany(fetch = FetchType.EAGER/*, mappedBy = "actividadNombreInscripcion","actividadDiaInscripcion","actividadHoraInscripcion"*/)
    private List<InscripcionesActividades> actividadesInscripto;

    public Actividad() {
        super();
    }

    public Actividad(String nombre, String tipo, String descripcion, LocalTime hora, LocalDate dia, boolean conCupos, int cupos, boolean reservable) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.conCupos = conCupos;
        this.cupos = cupos;
        this.reservable = reservable;
    }

    public Actividad(String nombre, LocalTime hora, LocalDate dia, String tipo, String descripcion, int cupos, boolean reservable, CentrosDeportivos centroDeportivo) {
        this.nombre = nombre;
        this.hora = hora;
        this.dia = dia;
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.cupos = cupos;
        this.reservable = reservable;
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
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

    public boolean isConCupos() {
        return conCupos;
    }

    public void setConCupos(boolean conCupos) {
        this.conCupos = conCupos;
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
                ", tipo='" + tipo + '\'' +
                ", descripcion='" + descripcion + '\'' +
                //", listaEmpleadoInscriptos=" + listaEmpleadoInscriptos +
                ", conCupos=" + conCupos +
                ", cupos=" + cupos +
                ", reservable=" + reservable +
                ", centroDeportivo=" + centroDeportivo +
                '}';
    }
}
