package gym.gymServer.Repository;

import gym.gymServer.Classes.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface EmpleadoRepository extends CrudRepository<Empleado, String> {

    @Query(value = "SELECT * FROM empleados e WHERE e.mail_empleado = :mail", nativeQuery = true)
    Empleado findOneByMail(@Param("mail") String mail);


    @Query(value = "SELECT * FROM empleados e WHERE e.mail_empleado LIKE %?1% OR e.nombre LIKE %?1% OR e.apellido LIKE %?1%", nativeQuery = true)
    List<Empleado> findBySearch(String input);

    @Query(value = "SELECT * FROM empleados e WHERE e.empresa_mail = :mailEmpresa", nativeQuery = true)
    List<Empleado> findAllByEmpresa(@Param("mailEmpresa") String mailEmpresa);



}
