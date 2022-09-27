package gym.gymServer.Controller;

import gym.gymServer.Service.CentrosDeportivosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/api/centroDeportivo")
public class CentrosDeportivosController {

    @Autowired
    private CentrosDeportivosService centrosDeportivosService;

    public CentrosDeportivosController() {
    }
}
