package gym.gymServer.Controller;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.InscripcionesActividades;
import gym.gymServer.Service.InscripcionesActividadesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
}
