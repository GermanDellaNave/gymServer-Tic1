package gym.gymServer.Service;

import gym.gymServer.Classes.TipoActividad;
import gym.gymServer.Repository.TipoActividadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TipoActividadService {

    @Autowired
    TipoActividadRepository tipoActividadRepository;

    public TipoActividadService() {
    }

    public TipoActividadService(TipoActividadRepository tipoActividadRepository) {
        this.tipoActividadRepository = tipoActividadRepository;
    }

    public void registrarTipo(TipoActividad tipoActividad){
        if(tipoActividadRepository.findOneByTipo(tipoActividad.getTipo())==null){
            tipoActividadRepository.save(tipoActividad);
        }
    }

    public List<TipoActividad> getTiposActividad() {
        return (List<TipoActividad>) tipoActividadRepository.findAll();
    }

    public void borrarTipoActividad(String tipo) {
        if (tipoActividadRepository.findOneByTipo(tipo) != null) {
            tipoActividadRepository.deleteById(tipo);
        }
    }
}
