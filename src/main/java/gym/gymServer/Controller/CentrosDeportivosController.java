package gym.gymServer.Controller;

import com.fasterxml.jackson.databind.JsonNode;
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

    @GetMapping("/centros")
    public List<CentrosDeportivos> getCentrosDeportivos() {
        return centrosDeportivosService.getCentrosDeportivos();
    }

    @GetMapping("/centrosMail/{mail}")
    public CentrosDeportivos getCentroDeportivo(@PathVariable("mail") String mail) throws CentroDeportivoNoExiste {
        System.out.println("Buscando centro");
        return centrosDeportivosService.getCentroDeportivo(mail);
    }

    @GetMapping(path = "/nombreCentro/{mail}")
    public String getNombreCentro(@PathVariable("mail") String mail) {
        return centrosDeportivosService.getCentroDeportivoNombre(mail);
    }

    @PostMapping
    public void registrarCentroDeportivo(@RequestBody CentrosDeportivos nuevoCentroDeportivo) throws CentroDeportivoYaExiste {
        System.out.println("Centro Deportivo controller post");
        centrosDeportivosService.registrarCentroDeportivo(nuevoCentroDeportivo);
    }

    @DeleteMapping (path = {"/delete/{centroDeportivoId}"})
    public void borrarCentroDeportivo(@PathVariable("centroDeportivoId") String mailId) throws CentroDeportivoNoExiste {
        System.out.println("Borrando centro deportivo controller");
        centrosDeportivosService.borrarCentroDeportivo(mailId);
    }

    @PutMapping("/updateCentro/{mail}")
    public void modificarDatoEmpresa(@PathVariable("centroDeportivoId") String mailId, String nombre, String contrasena) throws CentroDeportivoNoExiste {
        centrosDeportivosService.actualizarDatosCD(mailId, nombre, contrasena);
    }

}
