package gym.gymServer.Controller;

import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Service.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/api/empresas")
public class EmpresasController {

    @Autowired
    private EmpresasService empresasService;

    public EmpresasController() {
    }

    @PostMapping
    public void registrarEmpresa(@RequestBody Empresas nuevaEmpresa) throws EmpresaYaExiste {
        empresasService.registrarEmpresa(nuevaEmpresa);
    }
}
