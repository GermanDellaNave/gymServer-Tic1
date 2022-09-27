package gym.gymServer.Service;

import gym.gymServer.Repository.CentrosDeportivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CentrosDeportivosService {

    @Autowired
    private CentrosDeportivosRepository centrosDeportivosRepository;

    public CentrosDeportivosService() {
    }

    public CentrosDeportivosService(CentrosDeportivosRepository centrosDeportivosRepository) {
        this.centrosDeportivosRepository = centrosDeportivosRepository;
    }
}
