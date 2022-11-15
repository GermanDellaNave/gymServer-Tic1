package gym.gymServer.Controller;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.EmpresaNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
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

    @GetMapping("/proximasActividadesCentro/{mailCentro}")
    public List<Actividad> getActividadesRecientesCentro(@PathVariable("mailCentro") String centroMail) {
        return actividadService.getActividadesProximasCentro(centroMail);
    }

    @GetMapping("/similarActividad/{like}")
    public List<Actividad> getActividadesLike(@PathVariable("like") String search) {
        return actividadService.getActividadesLike(search);
    }

    @GetMapping(path = "/actividadTipo/{tipo}")
    public List<Actividad> getActividadesTipo(@PathVariable("tipo") String tipo) {
        System.out.println(tipo);
        return actividadService.getActividadesTipo(tipo);
    }

    @GetMapping("/actividadesDisponibles")
    public List<Actividad> getActividadesDisponibles() {
        return actividadService.getActividadesDisponibles();
    }

    @PutMapping(path = "/actualizar/{nombre}/{dia}/{hora}/{centroMail}")
    public void actualizarActividad(@PathVariable("nombre") String nombre, @PathVariable("dia") String dia, @PathVariable("hora") String hora, @PathVariable("centroMail") String centroMail, @RequestBody Actividad actividad) {
        actividadService.actualizarActividad(nombre, dia, hora, centroMail, actividad);
    }

    @GetMapping("/actividadesCentro/{centroMail}")
    public List<Actividad>  getActividadesCentro(@PathVariable("centroMail") String centroMail) {
        return actividadService.getActividadesCentro(centroMail);
    }

    @GetMapping("/cantidadActividades")
    Integer getCantidadActividades () {
        return actividadService.getCantidadActividades();
    }

    @GetMapping("/similarActividadCentro/{search}/{mailCentro}")
    public List<Actividad> findBySearchAndCentro(@PathVariable("search") String search,@PathVariable("mailCentro") String mailCentro) {
        return actividadService.findBySearchAndCentro(search,mailCentro);
    }

}
