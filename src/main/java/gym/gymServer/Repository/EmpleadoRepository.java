package gym.gymServer.Repository;

import gym.gymServer.Classes.Empleado;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface EmpleadoRepository extends CrudRepository<Empleado, String> {

    @Query(value = "SELECT * FROM empleados e WHERE e.mail_empleado = :mail", nativeQuery = true)
    Empleado findOneByMail(@Param("mail") String mail);


}
