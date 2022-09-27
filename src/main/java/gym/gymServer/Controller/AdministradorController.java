package gym.gymServer.Controller;

import gym.gymServer.Service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
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
