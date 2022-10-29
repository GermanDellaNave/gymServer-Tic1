package gym.gymServer.Service;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.TipoActividad;
import gym.gymServer.Repository.TipoActividadRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class TipoActividadService {

    TipoActividadRepository tipoActividadRepository;

    public TipoActividadService() {
    }

    public TipoActividadService(TipoActividadRepository tipoActividadRepository) {
        this.tipoActividadRepository = tipoActividadRepository;
    }

    public void registrarTipo(TipoActividad tipoActividad){
        if(tipoActividadRepository.findOneByTipo(tipoActividad)==null){
            tipoActividadRepository.save(tipoActividad);
        }
    }

    public List<TipoActividad> getTiposActividad() {
        return (List<TipoActividad>) tipoActividadRepository.findAll();
    }

    public void borrarTipoActividad(String tipo) {
        if (tipoActividadRepository.findOneByNombreTipo(tipo)!= null) {
            tipoActividadRepository.deleteById(tipo);
    }
}
