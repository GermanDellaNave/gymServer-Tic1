package gym.gymServer.Service;

import gym.gymServer.Repository.ActividadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadesService {

    @Autowired(required = true)
    private ActividadesRepository actividadesRepository;

    public ActividadesService() {
    }

    public ActividadesService(ActividadesRepository actividadesRepository) {
        this.actividadesRepository = actividadesRepository;
    }
}
