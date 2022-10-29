package gym.gymServer.Service;

import gym.gymServer.Classes.InscripcionesActividades;
import gym.gymServer.Classes.InscripcionesActividadesID;
import gym.gymServer.Repository.InscripcionesActividadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InscripcionesActividadesService {

    @Autowired
    InscripcionesActividadesRepository inscripcionesActividadesRepository;

    public void registrarInscripcion(InscripcionesActividades inscripcionesActividades) {
        if (inscripcionesActividadesRepository.findById(new InscripcionesActividadesID(inscripcionesActividades.getEmpleadoMailInscripcion(), inscripcionesActividades.getActividadNombreInscripcion(), inscripcionesActividades.getActividadDiaInscripcion(), inscripcionesActividades.getActividadHoraInscripcion(), inscripcionesActividades.getActividadCentroInscripcion())) == null) {
            inscripcionesActividadesRepository.save(inscripcionesActividades);
        } else {
            System.out.println("usuario ya inscripto a esa actividad");
        }
    }
}
