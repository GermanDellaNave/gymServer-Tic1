package gym.gymServer.Repository;

import gym.gymServer.Classes.Empleado;
import gym.gymServer.Classes.Pago;
import gym.gymServer.Classes.PagoId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PagoRepository extends CrudRepository<Pago, PagoId> {

    @Query(value = "SELECT * FROM pago_empresa_centro p WHERE p.empresa_mail_pago = :mailEmpresa AND p.centro_mail_pago = :mailCentro", nativeQuery = true)
    Pago findOneByEmpresaAndCentro(@Param("mailEmpresa") String mailEmpresa,@Param("mailCentro") String mailCentro);

    @Query(value = "SELECT * FROM pago_empresa_centro p WHERE p.empresa_mail_pago = :mailEmpresa", nativeQuery = true)
    List<Pago> findOneByEmpresa(@Param("mailEmpresa") String mailEmpresa);

    @Query(value = "SELECT * FROM pago_empresa_centro p WHERE p.centro_mail_pago = :mailCentro", nativeQuery = true)
    List<Pago> findOneByCentro(@Param("mailCentro") String mailCentro);

    @Query(value = "SELECT * FROM pago_empresa_centro p WHERE p.centro_mail_pago = ?1 AND p.empresa_mail_pago LIKE %?2%", nativeQuery = true)
    List<Pago> findByCentroAndSearch(String mailCentro,String input);




}
