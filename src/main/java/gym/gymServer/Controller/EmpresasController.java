package gym.gymServer.Controller;

import gym.gymServer.Service.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/api/empresas")
public class EmpresasController {

    @Autowired
    private EmpresasService empresasService;

    public EmpresasController() {
    }
}
