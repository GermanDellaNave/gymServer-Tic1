package gym.gymServer.Repository;

import gym.gymServer.Classes.Actividad;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ActividadRepository extends CrudRepository<Actividad, String> {

    Actividad findOneByNombreAndHoraAndDia(String nombre, LocalTime hora, LocalDate dia);
}
