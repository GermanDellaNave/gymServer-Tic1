package gym.gymServer.Repository;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.ActividadesID;
import gym.gymServer.Classes.CentrosDeportivos;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ActividadRepository extends CrudRepository<Actividad, ActividadesID> {

    //Actividad findOneById(String nombre, LocalTime hora, LocalDate dia, CentrosDeportivos centrosDeportivos);
}
