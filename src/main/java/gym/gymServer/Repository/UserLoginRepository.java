package gym.gymServer.Repository;

import gym.gymServer.Classes.UserLogin;
import org.springframework.data.repository.CrudRepository;

public interface UserLoginRepository extends CrudRepository<UserLogin, String> {

    UserLogin findOneByMail(String mail);
}
