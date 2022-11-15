package gym.gymServer.Repository;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.Empleado;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Transactional
public interface EmpleadoRepository extends CrudRepository<Empleado, String> {

    @Query(value = "SELECT * FROM empleados e WHERE e.mail_empleado = :mail", nativeQuery = true)
    Empleado findOneByMail(@Param("mail") String mail);

    @Query(value = "SELECT * FROM empleados e WHERE e.mail_empleado LIKE %?1% OR e.nombre LIKE %?1% OR e.apellido LIKE %?1%", nativeQuery = true)
    List<Empleado> findBySearch(String input);

    @Query(value = "SELECT * FROM empleados e WHERE e.empresa_mail = :mailEmpresa  ORDER BY e.mail_empleado ASC ", nativeQuery = true)
    List<Empleado> findAllByEmpresa(@Param("mailEmpresa") String mailEmpresa);

    @Query(value = "SELECT * FROM empleados e WHERE e.empresa_mail = :mailEmpresa ORDER BY e.date_creado DESC LIMIT 5", nativeQuery = true)
    List<Empleado> findTopNewestEmpresa(@Param("mailEmpresa") String mailEmpresa);

    @Query(value = "SELECT * FROM empleados e WHERE (e.mail_empleado LIKE %?1% OR e.nombre LIKE %?1% OR e.apellido LIKE %?1%) AND e.empresa_mail= ?2", nativeQuery = true)
    List<Empleado> findBySearchAndEmpresa(String input,String mailEmpresa);

    @Query(value = "SELECT * FROM empleados e WHERE e.empresa_mail= ?1 AND e.deuda> 0", nativeQuery = true)
    List<Empleado> getDeudoresPorEmpresa(String mailEmpresa);

    @Query(value = "SELECT COUNT(e) FROM empleados e", nativeQuery = true)
    Integer getCantidadEmpleados();

    @Query(value = "SELECT COUNT(e) FROM empleados e WHERE e.empresa_mail = :mailEmpresa", nativeQuery = true)
    Integer getCantidadEmpleadosEmpresa(@Param("mailEmpresa") String mailEmpresa);



}
