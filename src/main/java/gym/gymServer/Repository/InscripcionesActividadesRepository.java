package gym.gymServer.Repository;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.InscripcionesActividades;
import gym.gymServer.Classes.InscripcionesActividadesID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface InscripcionesActividadesRepository extends CrudRepository<InscripcionesActividades, InscripcionesActividadesID> {


    @Query(value = "SELECT a FROM actividades a JOIN   inscripciones_empleado_actividad i ON i.actividad_nombre_inscripcion=a.nombre_actividad AND i.actividad_dia_inscripcion=a.dia_actividad AND i.actividad_hora_inscripcion=a.hora_actividad AND i.actividad_centro_inscripcion=a.centro_mail WHERE i.empleado_mail_inscripcion = :mailEmpleado", nativeQuery = true)
    List<Actividad> getActividadesInscriptoEmpleado(@Param("mailEmpleado") String mailEmpleado);



}

