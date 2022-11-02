package gym.gymServer.Service;

import gym.gymServer.Classes.*;
import gym.gymServer.Repository.InscripcionesActividadesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public void registrarInscripcion(InscripcionesActividades inscripcionesActividades) {
        //if (inscripcionesActividadesRepository.findById(new InscripcionesActividadesID(inscripcionesActividades.getEmpleadoMailInscripcion(), inscripcionesActividades.getActividadNombreInscripcion(), inscripcionesActividades.getActividadDiaInscripcion(), inscripcionesActividades.getActividadHoraInscripcion(), inscripcionesActividades.getActividadCentroInscripcion())) == null) {
            inscripcionesActividadesRepository.save(inscripcionesActividades);
        //} else {
            System.out.println("usuario ya inscripto a esa actividad");
        //}
    }

    public /*List<Actividad>*/ void getActividadesReservadasUsuario(String mailUsuario){
        List<String> lista =  inscripcionesActividadesRepository.getActividadesInscriptoEmpleado(mailUsuario);
        for (String actividadReturn: lista) {
            List<String> actividad = Arrays.asList(actividadReturn.split(","));
            System.out.println(actividad);
            Actividad actividadNueva = new Actividad(actividad.get(0), LocalTime.parse(actividad.get(1)), LocalDate.parse(actividad.get(2), DateTimeFormatter.ofPattern("yyyy-MM-dd")), actividad.get(3), new TipoActividad(actividad.get(4)), actividad.get(5), Integer.parseInt(actividad.get(6)), Integer.parseInt(actividad.get(7)), Integer.parseInt(actividad.get(8)), Boolean.valueOf(actividad.get(9)), Date.valueOf(actividad.get(10)), actividad.get(11), CentrosDeportivos.class.cast(actividad.get(12)));
            System.out.println(actividadNueva.toString());
            System.out.println(actividadReturn.toString());
        }
        //return lista;
    }
}
