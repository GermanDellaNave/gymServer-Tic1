package gym.gymServer.Repository;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface CentrosDeportivosRepository extends CrudRepository<CentrosDeportivos, String> {

    CentrosDeportivos findOneByMail(String mail);

    @Query(value = "SELECT * FROM centros_deportivos c WHERE c.mail_centro LIKE %?1% OR c.nombre LIKE %?1% ORDER BY c.mail_centro ASC ,c.nombre ASC ", nativeQuery = true)
    List<CentrosDeportivos> findBySearch(String input);

    @Query(value = "SELECT COUNT(c) FROM centros_deportivos c", nativeQuery = true)
    Integer getNumeroCentrosDeportivos();

    @Query(value = "SELECT * FROM centros_deportivos c ORDER BY c.date_creado DESC LIMIT 5", nativeQuery = true)
    List<CentrosDeportivos> findTopNewest();

    List<CentrosDeportivos> findAllByOrderByMailAsc();
}
