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

    @Query(value = "SELECT * FROM actividades a WHERE a.centro_mail_actividad LIKE %?1% OR a.nombre_actividad LIKE %?1%", nativeQuery = true)
    List<Actividad> findBySearch(String input);

    @Query(value = "SELECT * FROM actividades ORDER BY date_creada DESC LIMIT 5", nativeQuery = true)
    List<Actividad> findTopNewest();

    @Query(value = "SELECT * FROM actividades a WHERE a.tipo = :tipostring", nativeQuery = true)
    List<Actividad> getAllByTipo(@Param("tipostring") String tipostring);

    /*JOIN tipo_actividades t ON a.tipo = t.tipo*/

    @Query( value = "SELECT * FROM actividades a where (a.dia_actividad = ?1 AND a.hora_actividad > ?2) OR (a.dia_actividad >?1)", nativeQuery = true)
    List <Actividad> getActividadesDisponibles(LocalDate date,LocalTime time);


    @Query( value = "SELECT * FROM actividades a where a.centro_mail_actividad = :centroMail ", nativeQuery = true)
    Actividad findOneByCentro(@Param("centroMail") String centroMail);



}
