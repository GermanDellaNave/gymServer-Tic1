package gym.gymServer.Repository;

import gym.gymServer.Classes.Empresas;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface EmpresasRepository extends CrudRepository<Empresas, String> {

    Empresas findOneByMail(String mail);
}
