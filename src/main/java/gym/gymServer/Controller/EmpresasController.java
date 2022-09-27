package gym.gymServer.Controller;

import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.EmpresaNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Service.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/api/empresas")
public class EmpresasController {

    @Autowired
    private EmpresasService empresasService;

    public EmpresasController() {
    }

    @GetMapping
    public List<Empresas> getEmpresas() {
        return empresasService.getEmpresas();
    }

    @PostMapping
    public void registrarEmpresa(@RequestBody Empresas nuevaEmpresa) throws EmpresaYaExiste {
        empresasService.registrarEmpresa(nuevaEmpresa);
    }

    @DeleteMapping (path = {"empresasId"})
    public void borrarEmpresa(@PathVariable("empresasId") String mailId) throws EmpresaNoExiste {
        empresasService.borrarEmpresa(mailId);
    }
}
