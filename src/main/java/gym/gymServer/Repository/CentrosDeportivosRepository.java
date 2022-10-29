package gym.gymServer.Repository;

import gym.gymServer.Classes.CentrosDeportivos;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface CentrosDeportivosRepository extends CrudRepository<CentrosDeportivos, String> {

    CentrosDeportivos findOneByMail(String mail);
}
