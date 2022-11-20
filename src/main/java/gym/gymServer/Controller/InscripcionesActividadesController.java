package gym.gymServer.Controller;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.InscripcionesActividades;
import gym.gymServer.Service.InscripcionesActividadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;

@RestController
@RequestMapping("/inscripciones")
public class InscripcionesActividadesController {

    @Autowired
    InscripcionesActividadesService inscripcionesActividadesService;

    @PostMapping
    public void registrarInscripcion(@RequestBody InscripcionesActividades inscripcionesActividades) {
        System.out.println(inscripcionesActividades);
        inscripcionesActividadesService.registrarInscripcion(inscripcionesActividades);
    }

    @GetMapping(path = "/inscripcionUsuario/{mailUsuario}")
    public List<Actividad> getActividadesReservadasUsuario(@PathVariable("mailUsuario") String mailUsuario){
        return inscripcionesActividadesService.getActividadesReservadasUsuario(mailUsuario);
    }

    @DeleteMapping (path = {"/delete/{mailEmpleado}/{nombreActividad}/{diaActividad}/{horaActividad}/{mailCentroActividad}"})
    public void borrarCentroDeportivo(@PathVariable("mailEmpleado") String mailEmpleado, @PathVariable("nombreActividad") String nombreActividad, @PathVariable("diaActividad") String diaActividad, @PathVariable("horaActividad") String horaActividad, @PathVariable("mailCentroActividad") String mailCentroActividad) {
        System.out.println("Entro borrar");
        System.out.println(horaActividad);
        LocalDate diaDate = LocalDate.parse(diaActividad);
        System.out.println(diaDate);
        DateTimeFormatter formato = new DateTimeFormatterBuilder().parseCaseInsensitive().appendPattern("HH:mm:ss").toFormatter();
        LocalTime hora = LocalTime.of(0,0,0);
        System.out.println(hora.format(formato));


        LocalTime horaTime = LocalTime.parse(horaActividad);
        horaTime = horaTime.plusSeconds(0);

        System.out.println(horaTime.format(formato));
        //System.out.println(horaConSeg);
        inscripcionesActividadesService.borrarInscripcionActividad(mailEmpleado, nombreActividad, diaDate, horaTime.withSecond(0), mailCentroActividad);
    }

    @PutMapping(path = "/actualizar/{mailEmpleado}/{nombreActividad}/{diaActividad}/{horaActividad}/{centroMailActividad}")
    public void asistencia(@PathVariable("mailEmpleado") String mailEmpleado, @PathVariable("nombreActividad") String nombreActividad, @PathVariable("diaActividad") String diaActividad, @PathVariable("horaActividad") String horaActividad,@PathVariable("centroMailActividad") String mailCentroActividad) {
        inscripcionesActividadesService.asistencia(mailEmpleado,nombreActividad,diaActividad,horaActividad,mailCentroActividad);
    }

    @GetMapping(path = "/inscripcion/{mailEmpleado}/{nombreActividad}/{diaActividad}/{horaActividad}/{centroMailActividad}")
    public InscripcionesActividades getInscripcionActividad(@PathVariable("mailEmpleado") String mailEmpleado, @PathVariable("nombreActividad") String nombreActividad, @PathVariable("diaActividad") String diaActividad, @PathVariable("horaActividad") String horaActividad,@PathVariable("centroMailActividad") String mailCentroActividad) {
        InscripcionesActividades inscripcionReturn = inscripcionesActividadesService.getInscripcionActividad(mailEmpleado,nombreActividad,diaActividad,horaActividad,mailCentroActividad);
        System.out.println("Obtener inscripcion");
        return inscripcionReturn;
    }

    @GetMapping(path = "/inscripcionesActividad/{nombreActividad}/{diaActividad}/{horaActividad}/{centroMailActividad}")
    public Integer getInscripcionesActividad(@PathVariable("nombreActividad") String nombreActividad, @PathVariable("diaActividad") String diaActividad, @PathVariable("horaActividad") String horaActividad,@PathVariable("centroMailActividad") String mailCentroActividad) {

        return inscripcionesActividadesService.getInscripcionesActividad(nombreActividad,diaActividad,horaActividad,mailCentroActividad);
    }



}
