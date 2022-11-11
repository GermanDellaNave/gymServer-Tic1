package gym.gymServer.Repository;

import gym.gymServer.Classes.InscripcionesActividades;
import gym.gymServer.Classes.InscripcionesActividadesID;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Transactional
public interface InscripcionesActividadesRepository extends CrudRepository<InscripcionesActividades, InscripcionesActividadesID> {


    //@Query(value = "SELECT a FROM actividades a JOIN inscripciones_empleado_actividad i ON i.actividad_nombre_inscripcion = a.nombre_actividad AND i.actividad_dia_inscripcion = a.dia_actividad AND i.actividad_hora_inscripcion = a.hora_actividad AND i.actividad_centro_inscripcion = a.centro_mail_actividad WHERE i.empleado_mail_inscripcion = :mailEmpleado", nativeQuery = true)
    /*@Query(value = "SELECT a.* FROM inscripciones_empleado_actividad i JOIN actividades a ON i.actividad_nombre_inscripcion = a.nombre_actividad AND i.actividad_dia_inscripcion = a.dia_actividad AND i.actividad_hora_inscripcion = a.hora_actividad AND i.actividad_centro_inscripcion = a.centro_mail_actividad WHERE i.empleado_mail_inscripcion = :mailEmpleado", nativeQuery = true)
    //@Query(value = "SELECT a FROM actividades a JOIN i.actividad_nombre_inscripcion, i.actividad_dia_inscripcion, i.actividad_hora_inscripcion, i.actividad_centro_inscripcion WHERE i.empleado_mail_inscripcion = :mailEmpleado")
    List<Object[]> getActividadesInscriptoEmpleado(@Param("mailEmpleado") String mailEmpleado);
*/
    /*@Query(value = "SELECT a.nombre_actividad AS nombre, a.dia_actividad AS dia, a.hora_actividad AS hora, a.centro_mail_actividad AS centroMail, a.tipo, a.descripcion, a.duracion, a.costo, a.cupos, a.reservable, a.date_creada AS dateCreada, a.imagen, a.centro AS centroDeportivo FROM inscripciones_empleado_actividad i JOIN actividades a ON i.actividad_nombre_inscripcion = a.nombre_actividad AND i.actividad_dia_inscripcion = a.dia_actividad AND i.actividad_hora_inscripcion = a.hora_actividad AND i.actividad_centro_inscripcion = a.centro_mail_actividad WHERE i.empleado_mail_inscripcion = :mailEmpleado", nativeQuery = true)
        //@Query(value = "SELECT a FROM actividades a JOIN i.actividad_nombre_inscripcion, i.actividad_dia_inscripcion, i.actividad_hora_inscripcion, i.actividad_centro_inscripcion WHERE i.empleado_mail_inscripcion = :mailEmpleado")
    List<String> getActividadesInscriptoEmpleado(@Param("mailEmpleado") String mailEmpleado);*/

    /*@Query(value = "SELECT * FROM inscripciones_empleado_actividad i WHERE i")
    InscripcionesActividades findIscripcionActividadHecha(@Param())*/

    @Query(value = "SELECT * FROM inscripciones_empleado_actividad i WHERE i.empleado_mail_inscripcion = :mailEmpleado ORDER BY i.actividad_dia_inscripcion ASC,i.actividad_hora_inscripcion ASC,i.actividad_nombre_inscripcion ASC", nativeQuery = true)
        //@Query(value = "SELECT a FROM actividades a JOIN i.actividad_nombre_inscripcion, i.actividad_dia_inscripcion, i.actividad_hora_inscripcion, i.actividad_centro_inscripcion WHERE i.empleado_mail_inscripcion = :mailEmpleado")
    List<InscripcionesActividades> getActividadesInscriptoEmpleado(@Param("mailEmpleado") String mailEmpleado);

    /*new Actividad(a.nombre_actividad, a.hora_actividad, a.dia_actividad, a.centro_mail_actividad, a.tipo, a.descripcion, a.duracion, a.costo, a.cupos, a.reservable, a.date_creada, a.imagen, a.centro_deportivo)*/

    @Query(value = "SELECT * FROM inscripciones_empleado_actividad i WHERE i.empleado_mail_inscripcion = :mailEmpleado AND i.actividad_nombre_inscripcion = :nombreActividad AND i.actividad_dia_inscripcion = :diaActividad AND i.actividad_hora_inscripcion = :horaActividad AND i.actividad_centro_inscripcion = :centroMailActividad ", nativeQuery = true)
    InscripcionesActividades getInscripcionActividad (@Param("mailEmpleado") String mailEmpleado, @Param("nombreActividad") String nombreActividad, @Param("diaActividad")LocalDate diaActividad, @Param("horaActividad")LocalTime horaActividad,@Param("centroMailActividad") String centroMailActividad);

    @Modifying
    @Query(value = "DELETE FROM inscripciones_empleado_actividad i WHERE i.empleado_mail_inscripcion = :mailEmpleado AND i.actividad_nombre_inscripcion = :nombreActividad AND i.actividad_dia_inscripcion = :diaActividad AND i.actividad_hora_inscripcion = :horaActividad AND i.actividad_centro_inscripcion = :centroMailActividad", nativeQuery = true)
    void borrarInscripcionActividad (@Param("mailEmpleado") String mailEmpleado, @Param("nombreActividad") String nombreActividad, @Param("diaActividad")LocalDate diaActividad, @Param("horaActividad")LocalTime horaActividad,@Param("centroMailActividad") String centroMailActividad);

}

