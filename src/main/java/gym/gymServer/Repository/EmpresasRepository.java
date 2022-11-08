package gym.gymServer.Repository;

import gym.gymServer.Classes.Empleado;
import gym.gymServer.Classes.Empresas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface EmpresasRepository extends CrudRepository<Empresas, String> {

    Empresas findOneByMail(String mail);


    @Query(value = "SELECT * FROM empresas e WHERE e.mail_empresa LIKE %?1% OR e.nombre LIKE %?1%", nativeQuery = true)
    List<Empresas> findBySearch(String input);



}
