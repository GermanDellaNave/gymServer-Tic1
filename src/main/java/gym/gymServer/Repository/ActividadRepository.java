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

    @Query(value = "SELECT * FROM actividades a WHERE (a.centro_mail_actividad LIKE %?1% OR a.nombre_actividad LIKE %?1%) AND ((a.dia_actividad = ?2 AND a.hora_actividad > ?3) OR (a.dia_actividad >?2)) ORDER BY a.dia_actividad ASC,a.hora_actividad ASC,a.nombre_actividad ASC ", nativeQuery = true)
    List<Actividad> findBySearch(String input,LocalDate date,LocalTime time);

    @Query(value = "SELECT * FROM actividades a WHERE (a.dia_actividad = ?1 AND a.hora_actividad > ?2) OR (a.dia_actividad >?1) ORDER BY a.date_creada DESC LIMIT 5", nativeQuery = true)
    List<Actividad> findTopNewest(LocalDate date, LocalTime time);

    @Query(value = "SELECT * FROM actividades a WHERE ((a.dia_actividad = ?1 AND a.hora_actividad > ?2) OR (a.dia_actividad >?1)) AND a.centro_mail_actividad = ?3 ORDER BY a.dia_actividad, a.hora_actividad LIMIT 5", nativeQuery = true)
    List<Actividad> findTopNextCentro(LocalDate date, LocalTime time, String mailCentro);

    @Query(value = "SELECT * FROM actividades a WHERE a.tipo = ?1 AND ((a.dia_actividad = ?2 AND a.hora_actividad > ?3) OR (a.dia_actividad >?2)) ORDER BY a.dia_actividad ASC,a.hora_actividad ASC,a.nombre_actividad ASC ", nativeQuery = true)
    List<Actividad> getAllByTipo(String tipostring,LocalDate date,LocalTime time);

    /*JOIN tipo_actividades t ON a.tipo = t.tipo*/

    @Query( value = "SELECT * FROM actividades a where (a.dia_actividad = ?1 AND a.hora_actividad > ?2) OR (a.dia_actividad >?1) ORDER BY a.dia_actividad ASC,a.hora_actividad ASC,a.nombre_actividad ASC", nativeQuery = true)
    List <Actividad> getActividadesDisponibles(LocalDate date,LocalTime time);


    @Query( value = "SELECT * FROM actividades a where a.centro_mail_actividad = ?1 AND ((a.dia_actividad = ?2 AND a.hora_actividad > ?3) OR (a.dia_actividad >?2)) ORDER BY a.dia_actividad ASC,a.hora_actividad ASC,a.nombre_actividad ASC ", nativeQuery = true)
    List<Actividad> findOneByCentro(String centroMail,LocalDate date,LocalTime time);

    @Query(value = "SELECT COUNT(a) FROM actividades a", nativeQuery = true)
    Integer getCantidadActividades();




}
