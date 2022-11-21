package gym.gymServer.Repository;

import gym.gymServer.Classes.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface EmpleadoRepository extends CrudRepository<Empleado, String> {

    @Query(value = "SELECT * FROM empleados e WHERE e.mail_empleado = :mail ORDER BY e.mail_empleado ASC,e.apellido ASC,e.nombre ASC ", nativeQuery = true)
    Empleado findOneByMail(@Param("mail") String mail);

    @Query(value = "SELECT * FROM empleados e WHERE e.mail_empleado LIKE %?1% OR e.nombre LIKE %?1% OR e.apellido LIKE %?1% ORDER BY e.mail_empleado ASC,e.apellido ASC,e.nombre ASC ", nativeQuery = true)
    List<Empleado> findBySearch(String input);

    @Query(value = "SELECT * FROM empleados e WHERE e.empresa_mail = :mailEmpresa  ORDER BY e.mail_empleado ASC,e.apellido ASC,e.nombre ASC ", nativeQuery = true)
    List<Empleado> findAllByEmpresa(@Param("mailEmpresa") String mailEmpresa);

    @Query(value = "SELECT * FROM empleados e WHERE e.empresa_mail = :mailEmpresa ORDER BY e.date_creado DESC LIMIT 5", nativeQuery = true)
    List<Empleado> findTopNewestEmpresa(@Param("mailEmpresa") String mailEmpresa);

    @Query(value = "SELECT * FROM empleados e WHERE (e.mail_empleado LIKE %?1% OR e.nombre LIKE %?1% OR e.apellido LIKE %?1%) AND e.empresa_mail= ?2 ORDER BY e.mail_empleado ASC,e.apellido ASC,e.nombre ASC", nativeQuery = true)
    List<Empleado> findBySearchAndEmpresa(String input,String mailEmpresa);

    @Query(value = "SELECT * FROM empleados e WHERE e.empresa_mail= ?1 AND e.deuda> 0 ORDER BY e.mail_empleado ASC,e.apellido ASC,e.nombre ASC", nativeQuery = true)
    List<Empleado> getDeudoresPorEmpresa(String mailEmpresa);

    @Query(value = "SELECT COUNT(e) FROM empleados e", nativeQuery = true)
    Integer getCantidadEmpleados();

    @Query(value = "SELECT COUNT(e) FROM empleados e WHERE e.empresa_mail = :mailEmpresa", nativeQuery = true)
    Integer getCantidadEmpleadosEmpresa(@Param("mailEmpresa") String mailEmpresa);




}
