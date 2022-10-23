package gym.gymServer.Controller;

import gym.gymServer.Service.ActividadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/api/actividades")
public class ActividadController {

    @Autowired
    private ActividadService actividadService;

    public ActividadController() {
    }
}
