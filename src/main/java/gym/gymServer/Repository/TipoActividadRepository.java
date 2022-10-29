package gym.gymServer.Repository;

import gym.gymServer.Classes.TipoActividad;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface TipoActividadRepository extends CrudRepository<TipoActividad, String> {

    TipoActividad findOneByTipo(TipoActividad tipoActividad);

    @Query(value = "SELECT * FROM tipo_actividades t where t.tipo = :tipo", nativeQuery = true)
    TipoActividad findOneByNombreTipo(@Param("tipo") String tipo);
}
