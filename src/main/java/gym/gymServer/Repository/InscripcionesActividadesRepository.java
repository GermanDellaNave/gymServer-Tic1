package gym.gymServer.Repository;

import gym.gymServer.Classes.InscripcionesActividades;
import gym.gymServer.Classes.InscripcionesActividadesID;
import org.springframework.data.repository.CrudRepository;

public interface InscripcionesActividadesRepository extends CrudRepository<InscripcionesActividades, InscripcionesActividadesID> {
}
