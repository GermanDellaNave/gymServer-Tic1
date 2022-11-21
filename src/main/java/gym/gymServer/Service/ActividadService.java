package gym.gymServer.Service;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Repository.ActividadRepository;
import gym.gymServer.Repository.CentrosDeportivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
        actividadRepository.save(actividad);

        }

public Actividad getActividad(String nombre, String hora, String dia, String centroMail) {
        LocalTime horaLT = LocalTime.parse(hora);
        LocalDate diaLT = LocalDate.parse(dia);

       return actividadRepository.findOneByKey(centroMail,diaLT,horaLT,nombre);
        }

public List<Actividad> getActividadesDisponibles(){
        return actividadRepository.getActividadesDisponibles(LocalDate.now(),LocalTime.now());
        }

public List<Actividad> getActividades() {
        return (List<Actividad>) actividadRepository.findAll();
        }

public List<Actividad> getActividadesRecientes() {
        return actividadRepository.findTopNewest(LocalDate.now(), LocalTime.now());
        }

public List<Actividad> getActividadesProximasCentro(String mailCentro) {
        return actividadRepository.findTopNextCentro(LocalDate.now(), LocalTime.now(), mailCentro);
        }

public List<Actividad> getActividadesLike(String search) {
        return actividadRepository.findBySearch(search,LocalDate.now(),LocalTime.now());
        }

public List<Actividad> getActividadesTipo(String tipo) {
        return actividadRepository.getAllByTipo(tipo,LocalDate.now(),LocalTime.now());
        }

@Transactional
public void
actualizarActividad(String nombre, String dia, String hora, String centroMail, Actividad actividad) {
        LocalDate date = LocalDate.parse(dia);
        LocalTime time = LocalTime.parse(hora);
        Actividad actividadActualizable = actividadRepository.findOneByKey(centroMail, date, time, nombre);
        actividadActualizable.setCupos(actividad.getCupos());
        actividadActualizable.setImagen(actividad.getImagen());
        actividadActualizable.setCosto(actividad.getCosto());
        actividadActualizable.setDescripcion(actividad.getDescripcion());
        actividadActualizable.setReservable(actividad.isReservable());
        actividadActualizable.setDuracion(actividad.getDuracion());


        }

public List<Actividad> getActividadesCentro(String mailCentro){
        return actividadRepository.findOneByCentro(mailCentro,LocalDate.now());
        }

public Integer getCantidadActividades(){
        return actividadRepository.getCantidadActividades();
        }

public List<Actividad> findBySearchAndCentro(String search,String mailCentro) {
        return actividadRepository.findDisponiblesBySearchAndCentro(search,mailCentro,LocalDate.now(),LocalTime.now());
        }

public void deleteActividad(String nombreActividad,String diaActividad,String horaActividad,String mailCentroActividad) {
    LocalDate date=LocalDate.parse(diaActividad);
    LocalTime time=LocalTime.parse(horaActividad);

    Actividad actividad=actividadRepository.findOneByKey(nombreActividad,date,time,mailCentroActividad);

    actividadRepository.deleteActividad(nombreActividad,date,time,mailCentroActividad);

}
}

