package gym.gymServer.Classes;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

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
}
