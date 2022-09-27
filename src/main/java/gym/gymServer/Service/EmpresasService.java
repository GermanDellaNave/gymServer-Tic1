package gym.gymServer.Service;


import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Repository.EmpresasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresasService {

    @Autowired(required = true)
    private EmpresasRepository empresasRepository;

    public EmpresasService() {
    }

    public EmpresasService(EmpresasRepository empresasRepository) {
        this.empresasRepository = empresasRepository;
    }

    public void registrarEmpresa (Empresas nuevaEmpresa) throws EmpresaYaExiste {
        if (empresasRepository.findOneByMail(nuevaEmpresa.getMail()) != null) {
            throw new EmpresaYaExiste();
        }

        empresasRepository.save(nuevaEmpresa);
    }
}
