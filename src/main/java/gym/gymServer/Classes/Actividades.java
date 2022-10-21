package gym.gymServer.Classes;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "Actividades")
@IdClass(ActividadesID.class)
@Component
public class Actividades extends ActividadesID {

    private ActividadesID idActividad;

    private @Id String nombre;

    private @Id LocalTime hora;

    private @Id LocalDate dia;
    private String tipo;

    private String descripcion;

    @OneToMany
    private List<Usuarios> listaUsuariosInscriptos;

    private boolean conCupos;

    private int cupos;

    private boolean reservable;

    @OneToOne
    private CentrosDeportivos centroDeportivo;

    public Actividades() {
        super();
    }

    public Actividades(String nombre, String tipo, String descripcion, LocalTime hora, LocalDate dia, List<Usuarios> listaUsuariosInscriptos, boolean conCupos, int cupos, boolean reservable) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.listaUsuariosInscriptos = listaUsuariosInscriptos;
        this.conCupos = conCupos;
        this.cupos = cupos;
        this.reservable = reservable;
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

    public List<Usuarios> getListaUsuariosInscriptos() {
        return listaUsuariosInscriptos;
    }

    public void setListaUsuariosInscriptos(List<Usuarios> listaUsuariosInscriptos) {
        this.listaUsuariosInscriptos = listaUsuariosInscriptos;
    }

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
}
