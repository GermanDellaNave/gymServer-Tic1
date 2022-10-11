package gym.gymServer.Repository;

import gym.gymServer.Classes.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository extends CrudRepository<Login, String> {

    Login findOneByMail(String mail);
}
