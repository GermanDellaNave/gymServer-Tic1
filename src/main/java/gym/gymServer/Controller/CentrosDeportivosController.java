package gym.gymServer.Controller;

import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.CentroDeportivoNoExiste;
import gym.gymServer.Classes.Exceptions.CentroDeportivoYaExiste;
import gym.gymServer.Classes.Exceptions.EmpresaNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Service.CentrosDeportivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/api/centroDeportivo")
public class CentrosDeportivosController {

    @Autowired
    private CentrosDeportivosService centrosDeportivosService;

    public CentrosDeportivosController() {
    }

    @GetMapping
    public List<CentrosDeportivos> getCentrosDeportivos() {
        return centrosDeportivosService.getCentrosDeportivos();
    }

    @PostMapping
    public void registrarCentroDeportivo(@RequestBody CentrosDeportivos nuevoCentroDeportivo) throws CentroDeportivoYaExiste {
        centrosDeportivosService.registrarCentroDeportivo(nuevoCentroDeportivo);
    }

    @DeleteMapping (path = {"centroDeportivoId"})
    public void borrarCentroDeportivo(@PathVariable("centroDeportivoId") String mailId) throws CentroDeportivoNoExiste {
        centrosDeportivosService.borrarCentroDeportivo(mailId);
    }
}
