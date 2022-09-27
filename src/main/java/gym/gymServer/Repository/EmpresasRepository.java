package gym.gymServer.Repository;

import gym.gymServer.Classes.Empresas;
import org.springframework.data.repository.CrudRepository;

public interface EmpresasRepository extends CrudRepository<Empresas, String> {

    Empresas findOneByMail(String mail);
}
