package gym.gymServer.Repository;

import gym.gymServer.Classes.UserLogin;
import gym.gymServer.Classes.UserRegistro;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface UserLoginRepository extends CrudRepository<UserLogin, String> {

    UserLogin findOneByMail(String mail);
}
