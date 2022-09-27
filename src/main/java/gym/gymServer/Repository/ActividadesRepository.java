package gym.gymServer.Repository;

import gym.gymServer.Classes.Actividades;
import gym.gymServer.Classes.CentrosDeportivos;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.time.LocalTime;

public interface ActividadesRepository extends CrudRepository<String, Actividades> {
}
