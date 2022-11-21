package gym.gymServer.Repository;

import gym.gymServer.Classes.TipoActividad;
import org.springframework.data.repository.CrudRepository;

public interface TipoActividadRepository extends CrudRepository<TipoActividad, String> {

    TipoActividad findOneByTipo(String tipoActividad);

}
