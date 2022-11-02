package gym.gymServer.Repository;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.ActividadReturn;
import gym.gymServer.Classes.InscripcionesActividades;
import gym.gymServer.Classes.InscripcionesActividadesID;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

public interface InscripcionesActividadesRepository extends CrudRepository<InscripcionesActividades, InscripcionesActividadesID> {


    //@Query(value = "SELECT a FROM actividades a JOIN inscripciones_empleado_actividad i ON i.actividad_nombre_inscripcion = a.nombre_actividad AND i.actividad_dia_inscripcion = a.dia_actividad AND i.actividad_hora_inscripcion = a.hora_actividad AND i.actividad_centro_inscripcion = a.centro_mail_actividad WHERE i.empleado_mail_inscripcion = :mailEmpleado", nativeQuery = true)
    /*@Query(value = "SELECT a.* FROM inscripciones_empleado_actividad i JOIN actividades a ON i.actividad_nombre_inscripcion = a.nombre_actividad AND i.actividad_dia_inscripcion = a.dia_actividad AND i.actividad_hora_inscripcion = a.hora_actividad AND i.actividad_centro_inscripcion = a.centro_mail_actividad WHERE i.empleado_mail_inscripcion = :mailEmpleado", nativeQuery = true)
    //@Query(value = "SELECT a FROM actividades a JOIN i.actividad_nombre_inscripcion, i.actividad_dia_inscripcion, i.actividad_hora_inscripcion, i.actividad_centro_inscripcion WHERE i.empleado_mail_inscripcion = :mailEmpleado")
    List<Object[]> getActividadesInscriptoEmpleado(@Param("mailEmpleado") String mailEmpleado);
*/
    @Query(value = "SELECT a.nombre_actividad AS nombre, a.dia_actividad AS dia, a.hora_actividad AS hora, a.centro_mail_actividad AS centroMail, a.tipo, a.descripcion, a.duracion, a.costo, a.cupos, a.reservable, a.date_creada AS dateCreada, a.imagen, a.centro AS centroDeportivo FROM inscripciones_empleado_actividad i JOIN actividades a ON i.actividad_nombre_inscripcion = a.nombre_actividad AND i.actividad_dia_inscripcion = a.dia_actividad AND i.actividad_hora_inscripcion = a.hora_actividad AND i.actividad_centro_inscripcion = a.centro_mail_actividad WHERE i.empleado_mail_inscripcion = :mailEmpleado", nativeQuery = true)
        //@Query(value = "SELECT a FROM actividades a JOIN i.actividad_nombre_inscripcion, i.actividad_dia_inscripcion, i.actividad_hora_inscripcion, i.actividad_centro_inscripcion WHERE i.empleado_mail_inscripcion = :mailEmpleado")
    List<String> getActividadesInscriptoEmpleado(@Param("mailEmpleado") String mailEmpleado);

    /*@Query(value = "SELECT * FROM inscripciones_empleado_actividad i WHERE i")
    InscripcionesActividades findIscripcionActividadHecha(@Param())*/

    /*new Actividad(a.nombre_actividad, a.hora_actividad, a.dia_actividad, a.centro_mail_actividad, a.tipo, a.descripcion, a.duracion, a.costo, a.cupos, a.reservable, a.date_creada, a.imagen, a.centro_deportivo)*/

}

