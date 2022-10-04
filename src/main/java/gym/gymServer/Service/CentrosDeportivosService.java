package gym.gymServer.Service;

import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.CentroDeportivoNoExiste;
import gym.gymServer.Classes.Exceptions.CentroDeportivoYaExiste;
import gym.gymServer.Classes.Exceptions.EmpresaNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Repository.CentrosDeportivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentrosDeportivosService {

    @Autowired
    private CentrosDeportivosRepository centrosDeportivosRepository;

    public CentrosDeportivosService() {
    }

    public CentrosDeportivosService(CentrosDeportivosRepository centrosDeportivosRepository) {
        this.centrosDeportivosRepository = centrosDeportivosRepository;
    }

    public List<CentrosDeportivos> getCentrosDeportivos() {
        return (List<CentrosDeportivos>) centrosDeportivosRepository.findAll();
    }

    public void registrarCentroDeportivo (CentrosDeportivos nuevoCentro) throws CentroDeportivoYaExiste {
        if (centrosDeportivosRepository.findOneByMail(nuevoCentro.getMail()) != null) {
            throw new CentroDeportivoYaExiste();
        }

        centrosDeportivosRepository.save(nuevoCentro);
    }

    public void borrarCentroDeportivo(String mailId) throws CentroDeportivoNoExiste {
        if (centrosDeportivosRepository.findOneByMail(mailId) == null) {
            throw new CentroDeportivoNoExiste();
        }

        centrosDeportivosRepository.deleteById(mailId);
    }

    public void actualizarDatosCD(String mailId, String nombre, String contrasena) throws CentroDeportivoNoExiste {
        CentrosDeportivos centroActualizable = centrosDeportivosRepository.findOneByMail(mailId);

        if (centroActualizable == null) {
            throw new CentroDeportivoNoExiste();
        }

        centroActualizable.setContrasena(contrasena);
        centroActualizable.setNombre(nombre);

        centrosDeportivosRepository.save(centroActualizable);
    }
}
