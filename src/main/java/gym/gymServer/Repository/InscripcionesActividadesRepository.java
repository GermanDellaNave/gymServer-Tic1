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


    @Query(value = "SELECT * FROM inscripciones_empleado_actividad i WHERE i.empleado_mail_inscripcion = :mailEmpleado ORDER BY i.actividad_dia_inscripcion DESC,i.actividad_hora_inscripcion DESC,i.actividad_nombre_inscripcion DESC", nativeQuery = true)
    List<InscripcionesActividades> getActividadesInscriptoEmpleado(@Param("mailEmpleado") String mailEmpleado);


    @Query(value = "SELECT * FROM inscripciones_empleado_actividad i WHERE i.empleado_mail_inscripcion = :mailEmpleado AND i.actividad_nombre_inscripcion = :nombreActividad AND i.actividad_dia_inscripcion = :diaActividad AND i.actividad_hora_inscripcion = :horaActividad AND i.actividad_centro_inscripcion = :centroMailActividad ", nativeQuery = true)
    InscripcionesActividades getInscripcionActividad (@Param("mailEmpleado") String mailEmpleado, @Param("nombreActividad") String nombreActividad, @Param("diaActividad")LocalDate diaActividad, @Param("horaActividad")LocalTime horaActividad,@Param("centroMailActividad") String centroMailActividad);

    @Modifying
    @Query(value = "DELETE FROM inscripciones_empleado_actividad i WHERE i.empleado_mail_inscripcion = :mailEmpleado AND i.actividad_nombre_inscripcion = :nombreActividad AND i.actividad_dia_inscripcion = :diaActividad AND i.actividad_hora_inscripcion = :horaActividad AND i.actividad_centro_inscripcion = :centroMailActividad", nativeQuery = true)
    void borrarInscripcionActividad (@Param("mailEmpleado") String mailEmpleado, @Param("nombreActividad") String nombreActividad, @Param("diaActividad")LocalDate diaActividad, @Param("horaActividad")LocalTime horaActividad,@Param("centroMailActividad") String centroMailActividad);


    @Query(value = "SELECT COUNT(i) FROM inscripciones_empleado_actividad i WHERE i.actividad_nombre_inscripcion = :nombreActividad AND i.actividad_dia_inscripcion = :diaActividad AND i.actividad_hora_inscripcion = :horaActividad AND i.actividad_centro_inscripcion = :centroMailActividad", nativeQuery = true)
    Integer getInscripcionesActividad (@Param("nombreActividad") String nombreActividad, @Param("diaActividad")LocalDate diaActividad, @Param("horaActividad")LocalTime horaActividad,@Param("centroMailActividad") String centroMailActividad);

}

