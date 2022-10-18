package gym.gymServer.Controller;

import com.fasterxml.jackson.databind.JsonNode;
import gym.gymServer.Service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/api/administrador")
public class AdministradorController {

    @Autowired
    private AdministradorService administradorService;

    public AdministradorController() {
    }


}
