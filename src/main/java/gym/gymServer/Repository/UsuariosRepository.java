package gym.gymServer.Repository;

import gym.gymServer.Classes.Usuarios;
import org.springframework.data.repository.CrudRepository;

public interface UsuariosRepository extends CrudRepository<Usuarios, String> {

    Usuarios findOneByMail(String mail);
}
