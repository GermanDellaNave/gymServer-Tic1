package gym.gymServer.Repository;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.CentrosDeportivos;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CentrosDeportivosRepository extends CrudRepository<CentrosDeportivos, String> {

    CentrosDeportivos findOneByMail(String mail);

    @Query(value = "SELECT * FROM centros_deportivos c WHERE c.mail_centro LIKE %?1% OR c.nombre LIKE %?1%", nativeQuery = true)
    List<CentrosDeportivos> findBySearch(String input);

}
