package gym.gymServer.Service;

import gym.gymServer.Repository.ActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActividadService {

    @Autowired(required = true)
    private ActividadRepository actividadRepository;

    public ActividadService() {
    }

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }
}
