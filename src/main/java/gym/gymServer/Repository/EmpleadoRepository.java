package gym.gymServer.Repository;

import gym.gymServer.Classes.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoRepository extends CrudRepository<Empleado, String> {

    Empleado findOneByMail(String mail);
}
