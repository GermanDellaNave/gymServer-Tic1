package gym.gymServer.Service;


import gym.gymServer.Repository.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresasService {

    @Autowired
    private EmpresasRepository empresasRepository;

    public EmpresasService() {
    }

    public EmpresasService(EmpresasRepository empresasRepository) {
        this.empresasRepository = empresasRepository;
    }
}
