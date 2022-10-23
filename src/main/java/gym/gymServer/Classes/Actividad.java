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

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "empleado_actividad", joinColumns = {@JoinColumn(name = "nombre_actividad", referencedColumnName = "nombreActividad"),
            @JoinColumn(name = "hora_actividad", referencedColumnName = "horaActividad"),
            @JoinColumn(name = "dia_actividad", referencedColumnName = "diaActividad"),
            @JoinColumn(name = "centro_actividad", referencedColumnName = "centro_mail")},
            inverseJoinColumns = @JoinColumn(name = "mail_empleado", referencedColumnName = "mailEmpleado"))
    private List<Empleado> listaEmpleadoInscriptos;

    private boolean conCupos;

    private int cupos;

    private boolean reservable;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "centro_mail", referencedColumnName = "mailCentro")
    @Id
    private CentrosDeportivos centroDeportivo;

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




}
