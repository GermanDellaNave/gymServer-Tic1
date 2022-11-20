package gym.gymServer.Repository;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.Empleado;
import gym.gymServer.Classes.Empresas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Transactional
public interface EmpresasRepository extends CrudRepository<Empresas, String> {

    Empresas findOneByMail(String mail);

    List<Empresas> findAllByOrderByMailAsc();


    @Query(value = "SELECT * FROM empresas e WHERE e.mail_empresa LIKE %?1% OR e.nombre LIKE %?1% ORDER BY e.mail_empresa ASC,e.nombre ASC ", nativeQuery = true)
    List<Empresas> findBySearch(String input);

    @Query(value = "SELECT COUNT(e) FROM empresas e", nativeQuery = true)
    Integer getNumeroEmpresas();

    @Query(value = "SELECT * FROM empresas e ORDER BY e.date_creada DESC LIMIT 5", nativeQuery = true)
    List<Empresas> findTopNewest();





}
