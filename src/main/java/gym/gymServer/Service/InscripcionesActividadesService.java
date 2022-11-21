package gym.gymServer.Service;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.InscripcionesActividades;
import gym.gymServer.Repository.ActividadRepository;
import gym.gymServer.Repository.InscripcionesActividadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class InscripcionesActividadesService {

    @Autowired
    InscripcionesActividadesRepository inscripcionesActividadesRepository;

    @Autowired
    ActividadRepository actividadRepository;

    public void registrarInscripcion(InscripcionesActividades inscripcionesActividades) {
        inscripcionesActividadesRepository.save(inscripcionesActividades);
    }

    public List<Actividad> getActividadesReservadasUsuario(String mailUsuario) {
        List<InscripcionesActividades> lista = inscripcionesActividadesRepository.getActividadesInscriptoEmpleado(mailUsuario);
        List<Actividad> listaActividades = new ArrayList<>();
        for (InscripcionesActividades actividadReturn : lista) {
            Actividad actividadAgregar = actividadRepository.findOneByKey(actividadReturn.getActividadCentroInscripcion(), actividadReturn.getActividadDiaInscripcion(), actividadReturn.getActividadHoraInscripcion(), actividadReturn.getActividadNombreInscripcion());
            listaActividades.add(actividadAgregar);
        }
        return listaActividades;
    }

    public void borrarInscripcionActividad(String mailEmpleado, String nombreActividad, LocalDate diaActividad, LocalTime horaActividad, String mailCentroActividad) {
        InscripcionesActividades inscripcionesActividades = inscripcionesActividadesRepository.getInscripcionActividad(mailEmpleado, nombreActividad, diaActividad, horaActividad, mailCentroActividad);
        if (inscripcionesActividades != null) {
            inscripcionesActividadesRepository.borrarInscripcionActividad(mailEmpleado, nombreActividad, diaActividad, horaActividad.withSecond(0), mailCentroActividad);
        }
    }

    @Transactional
    public void asistencia(String mailEmpleado, String nombreActividad, String diaActividad, String horaActividad, String mailCentroActividad) {
        LocalDate date = LocalDate.parse(diaActividad);
        LocalTime time = LocalTime.parse(horaActividad);

        InscripcionesActividades inscripcionActividadActualizable = inscripcionesActividadesRepository.getInscripcionActividad(mailEmpleado, nombreActividad, date, time, mailCentroActividad);

        inscripcionActividadActualizable.setAsistencia(true);
        inscripcionActividadActualizable.setDateIngreso(new Date());

    }

    @Transactional
    @org.springframework.transaction.annotation.Transactional
    public InscripcionesActividades getInscripcionActividad(String mailEmpleado, String nombreActividad, String diaActividad, String horaActividad, String mailCentroActividad) {
        LocalDate date = LocalDate.parse(diaActividad);
        LocalTime time = LocalTime.parse(horaActividad);
        InscripcionesActividades inscripcionReturn = inscripcionesActividadesRepository.getInscripcionActividad(mailEmpleado, nombreActividad, date, time, mailCentroActividad);
        System.out.println("");
        System.out.println(inscripcionReturn);
        return inscripcionReturn;

    }

    public Integer getInscripcionesActividad(String nombreActividad, String diaActividad, String horaActividad,String mailCentroActividad) {
        LocalDate date = LocalDate.parse(diaActividad);
        LocalTime time = LocalTime.parse(horaActividad);
        Integer inscripcionesReturn = inscripcionesActividadesRepository.getInscripcionesActividad(nombreActividad, date, time, mailCentroActividad);
        return inscripcionesReturn;
    }

}
