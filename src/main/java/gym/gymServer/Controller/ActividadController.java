package gym.gymServer.Controller;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.EmpresaNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/api/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    public ActividadController() {
    }

    @PostMapping
    public void registrarActividad(@RequestBody Actividad actividad) {
        System.out.println(actividad);
        actividadService.registrarActividad(actividad);
    }

    @GetMapping("/allActividades")
    public List<Actividad> getActividades() {
        return actividadService.getActividades();
    }

    @GetMapping("/actividad/{nombre}/{hora}/{dia}/{centroMail}")
    public Actividad getActividad(@PathVariable("nombre") String nombre, @PathVariable("hora") String hora, @PathVariable("dia") String dia, @PathVariable("centroMail") String centroMail) {
        System.out.println("Buscando empresa");
        return actividadService.getActividad(nombre, hora, dia, centroMail);
    }

    @GetMapping("/nuevasActividades")
    public List<Actividad> getActividadesRecientes() {
        return actividadService.getActividadesRecientes();
    }
}
