package gym.gymServer.Service;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.ActividadesID;
import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.InscripcionesActividades;
import gym.gymServer.Repository.ActividadRepository;
import gym.gymServer.Repository.CentrosDeportivosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
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
        //if (actividadRepository.findOneByKey(actividad.getCentroMail(), actividad.getDia(), actividad.getHora(), actividad.getNombre()) == null) {
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
public void actualizarActividad(String nombre, String dia, String hora, String centroMail, Actividad actividad) {
        LocalDate date = LocalDate.parse(dia);
        LocalTime time = LocalTime.parse(hora);
        System.out.println("Entro actualizar actividad");
        Actividad actividadActualizable = actividadRepository.findOneByKey(centroMail, date, time, nombre);
        actividadActualizable.setCupos(actividad.getCupos());

        }

public List<Actividad> getActividadesCentro(String mailCentro){
        return actividadRepository.findOneByCentro(mailCentro,LocalDate.now(),LocalTime.now());
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

    if(actividad!=null){
        actividadRepository.deleteActividad(nombreActividad,date,time,mailCentroActividad);
    }
}
}

