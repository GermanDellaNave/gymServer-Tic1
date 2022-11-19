package gym.gymServer.Service;

import gym.gymServer.Classes.*;
import gym.gymServer.Repository.ActividadRepository;
import gym.gymServer.Repository.InscripcionesActividadesRepository;
import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Service
public class InscripcionesActividadesService {

    @Autowired
    InscripcionesActividadesRepository inscripcionesActividadesRepository;

    @Autowired
    ActividadRepository actividadRepository;

    public void registrarInscripcion(InscripcionesActividades inscripcionesActividades) {
        //if (inscripcionesActividadesRepository.findById(new InscripcionesActividadesID(inscripcionesActividades.getEmpleadoMailInscripcion(), inscripcionesActividades.getActividadNombreInscripcion(), inscripcionesActividades.getActividadDiaInscripcion(), inscripcionesActividades.getActividadHoraInscripcion(), inscripcionesActividades.getActividadCentroInscripcion())) == null) {
        inscripcionesActividadesRepository.save(inscripcionesActividades);
        //} else {
        System.out.println("usuario ya inscripto a esa actividad");
        //}
    }

    public List<Actividad> getActividadesReservadasUsuario(String mailUsuario) {
        List<InscripcionesActividades> lista = inscripcionesActividadesRepository.getActividadesInscriptoEmpleado(mailUsuario);
        //System.out.println(lista);
        List<Actividad> listaActividades = new ArrayList<>();
        for (InscripcionesActividades actividadReturn : lista) {
            Actividad actividadAgregar = actividadRepository.findOneByKey(actividadReturn.getActividadCentroInscripcion(), actividadReturn.getActividadDiaInscripcion(), actividadReturn.getActividadHoraInscripcion(), actividadReturn.getActividadNombreInscripcion());
            listaActividades.add(actividadAgregar);
            //System.out.println(actividadReturn.toString());
        }
        //System.out.println(listaActividades);
        System.out.println("Salgo del for");
        return listaActividades;
    }

    public void borrarInscripcionActividad(String mailEmpleado, String nombreActividad, LocalDate diaActividad, LocalTime horaActividad, String mailCentroActividad) {
        System.out.println("Entro service borrar Inscripcion");
        System.out.println(horaActividad);
        System.out.println(mailCentroActividad);
        System.out.println(mailEmpleado);
        System.out.println(diaActividad);
        System.out.println(nombreActividad);
        InscripcionesActividades inscripcionesActividades = inscripcionesActividadesRepository.getInscripcionActividad(mailEmpleado, nombreActividad, diaActividad, horaActividad, mailCentroActividad);
        //System.out.println(inscripcionesActividades);
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
    public InscripcionesActividades getInscripcionActividad(String mailEmpleado, String nombreActividad, String diaActividad, String horaActividad, String mailCentroActividad) {
        LocalDate date = LocalDate.parse(diaActividad);
        LocalTime time = LocalTime.parse(horaActividad);
        InscripcionesActividades inscripcionReturn = inscripcionesActividadesRepository.getInscripcionActividad(mailEmpleado, nombreActividad, date, time, mailCentroActividad);
        System.out.println(inscripcionReturn);
        System.out.println("busqueda inscripcion hecha");

        return inscripcionReturn;

    }

    @Transactional
    public List<InscripcionesActividades> getInscripcionesActividad(String nombreActividad, String diaActividad, String horaActividad,String mailCentroActividad) {
        LocalDate date = LocalDate.parse(diaActividad);
        LocalTime time = LocalTime.parse(horaActividad);

        return inscripcionesActividadesRepository.getInscripcionesActividad(nombreActividad, date, time, mailCentroActividad);
    }

}
