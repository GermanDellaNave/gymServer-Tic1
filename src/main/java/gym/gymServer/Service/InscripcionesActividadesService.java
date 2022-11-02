package gym.gymServer.Service;

import gym.gymServer.Classes.*;
import gym.gymServer.Repository.ActividadRepository;
import gym.gymServer.Repository.InscripcionesActividadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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

    public List<Actividad> getActividadesReservadasUsuario(String mailUsuario){
        List<InscripcionesActividades> lista =  inscripcionesActividadesRepository.getActividadesInscriptoEmpleado(mailUsuario);
        //System.out.println(lista);
        List<Actividad> listaActividades = new ArrayList<>();
        for (InscripcionesActividades actividadReturn: lista) {
            Actividad actividadAgregar = actividadRepository.findOneByKey(actividadReturn.getActividadCentroInscripcion(), actividadReturn.getActividadDiaInscripcion(), actividadReturn.getActividadHoraInscripcion(), actividadReturn.getActividadNombreInscripcion());
            listaActividades.add(actividadAgregar);
            //System.out.println(actividadReturn.toString());
        }
        //System.out.println(listaActividades);
        System.out.println("Salgo del for");
        return listaActividades;
    }
}
