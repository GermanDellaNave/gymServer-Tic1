package gym.gymServer.Controller;

import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empresas;
import gym.gymServer.Classes.Exceptions.CentroDeportivoNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaNoExiste;
import gym.gymServer.Classes.Exceptions.EmpresaYaExiste;
import gym.gymServer.Service.EmpresasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@PreAuthorize("hasRole('EMPRESA')")
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

    @GetMapping("/empresaMail/{mail}")
    public Empresas getEmpresa(@PathVariable String mail) throws EmpresaNoExiste {
        System.out.println("Buscando empresa");
        return empresasService.getEmpresa(mail);
    }

    @PostMapping
    public void registrarEmpresa(@RequestBody Empresas nuevaEmpresa) throws EmpresaYaExiste {
        System.out.println(nuevaEmpresa);
        empresasService.registrarEmpresa(nuevaEmpresa);
    }

    @DeleteMapping (path = {"empresasId"})
    public void borrarEmpresa(@PathVariable("empresasId") String mailId) throws EmpresaNoExiste {
        empresasService.borrarEmpresa(mailId);
    }

    @PutMapping("{mail}")
    public void modificarDatoEmpresa(@PathVariable("empresasId") String mailId, String nombre, String contrasena) throws EmpresaNoExiste {
        empresasService.actualizarDatosEmpresa(mailId, nombre, contrasena);
    }
}
