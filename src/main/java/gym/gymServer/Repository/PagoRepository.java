package gym.gymServer.Repository;

import gym.gymServer.Classes.Pago;
import gym.gymServer.Classes.PagoId;
import org.springframework.data.repository.CrudRepository;

public interface PagoRepository extends CrudRepository<Pago, PagoId> {
}
