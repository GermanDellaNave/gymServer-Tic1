package gym.gymServer.Controller;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.TipoActividad;
import gym.gymServer.Service.TipoActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/tipoactividad")
public class TipoActividadController {

    @Autowired
    TipoActividadService tipoActividadService;

    public TipoActividadController() {
    }

    public TipoActividadController(TipoActividadService tipoActividadService) {
        this.tipoActividadService = tipoActividadService;
    }

    @PostMapping
    public void registrarTipo(@RequestBody TipoActividad tipoActividad){
        tipoActividadService.registrarTipo(tipoActividad);
    }

    @GetMapping("/allTipoActividad")
    public List<TipoActividad> getActividades() {
        return tipoActividadService.getTiposActividad();
    }

    @DeleteMapping (path = {"/delete/{tipo}"})
    public void borrarTipoActividad(@PathVariable("tipo") String tipo) {
        tipoActividadService.borrarTipoActividad(tipo);
    }


}
