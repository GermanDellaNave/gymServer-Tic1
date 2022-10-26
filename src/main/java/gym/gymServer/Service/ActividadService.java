package gym.gymServer.Service;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Repository.ActividadRepository;
import gym.gymServer.Repository.CentrosDeportivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ActividadService {

    @Autowired(required = true)
    private ActividadRepository actividadRepository;

    @Autowired
    private CentrosDeportivosRepository centrosDeportivosRepository;

    public ActividadService() {
    }

    public ActividadService(ActividadRepository actividadRepository) {
        this.actividadRepository = actividadRepository;
    }

    public  void registrarActividad(Actividad actividad) {
        //if (actividadRepository.findOneById(actividad.getNombre(), actividad.getHora(), actividad.getDia(), actividad.getCentroDeportivo()) == null) {
            actividadRepository.save(actividad);
        //} else {
            System.out.println("Hola actividad ya existe");
        //}
    }

    public Actividad getActividad(String nombre, String hora, String dia, String centroMail) {
        LocalTime horaLT = LocalTime.parse(hora);
        LocalDate diaLT = LocalDate.parse(dia);
        CentrosDeportivos centroDeportivo = centrosDeportivosRepository.findOneByMail(centroMail);
        return null;
        //return actividadRepository.findOneById(nombre, horaLT, diaLT, centroDeportivo);
    }

    public List<Actividad> getActividades() {
        return (List<Actividad>) actividadRepository.findAll();
    }
}
