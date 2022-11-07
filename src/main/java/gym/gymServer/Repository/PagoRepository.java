package gym.gymServer.Repository;

import gym.gymServer.Classes.Empleado;
import gym.gymServer.Classes.Pago;
import gym.gymServer.Classes.PagoId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface PagoRepository extends CrudRepository<Pago, PagoId> {

    @Query(value = "SELECT * FROM pago_empresa_centro p WHERE e.empresa_mail_pago = :mailEmpresa AND e.centro_mail_pago = :mailCentro", nativeQuery = true)
    Pago findOneByEmpresaAndCentro(@Param("mailEmpresa") String mailEmpresa,@Param("mailEmpresa") String mailCentro);
}
