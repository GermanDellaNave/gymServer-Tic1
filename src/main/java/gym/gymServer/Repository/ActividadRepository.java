package gym.gymServer.Repository;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.ActividadesID;
import gym.gymServer.Classes.CentrosDeportivos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Transactional
public interface ActividadRepository extends CrudRepository<Actividad, ActividadesID> {

    @Query( value = "SELECT * FROM actividades a where a.centro_mail_actividad = :centroMail AND dia_actividad = :dia AND hora_actividad = :hora AND nombre_actividad = :nombre", nativeQuery = true)
    Actividad findOneByKey(@Param("centroMail") String centroMail, @Param("dia") LocalDate dia, @Param("hora")  LocalTime hora, @Param("nombre")  String nombre);

    @Query(value = "SELECT * FROM actividades a WHERE a.centro_mail_actividad LIKE %?1%", nativeQuery = true)
    List<Actividad> findBySearch(String input);

    @Query(value = "SELECT * FROM actividades ORDER BY date_creada DESC LIMIT 5", nativeQuery = true)
    List<Actividad> findTopNewest();
}
