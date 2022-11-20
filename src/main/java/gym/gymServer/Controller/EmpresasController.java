package gym.gymServer.Controller;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empleado;
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

    @GetMapping("/allEmpresas")
    public List<Empresas> getEmpresas() {
        return empresasService.getEmpresas();
    }

    @GetMapping("/nuevasEmpresas")
    public List<Empresas> getNuevasEmpresas() {
        return empresasService.getNuevasEmpresas();
    }

    @GetMapping("/empresaMail/{mail}")
    public Empresas getEmpresa(@PathVariable String mail) {
        System.out.println("Buscando empresa");
        return empresasService.getEmpresa(mail);
    }

    @GetMapping("/similarEmpresa/{like}")
    public List<Empresas> getEmpresasLike(@PathVariable("like") String search) {
        return empresasService.getEmpresasLike(search);
    }

    @GetMapping("/numberEmpresas")
    public Integer getCantidadEmpresas(){
        return empresasService.getCantidadEmpresas();
    }

    @PostMapping
    public void registrarEmpresa(@RequestBody Empresas nuevaEmpresa)  {
        System.out.println(nuevaEmpresa);
        empresasService.registrarEmpresa(nuevaEmpresa);
    }

    @DeleteMapping (path = {"/delete/{empresasId}"})
    public void borrarEmpresa(@PathVariable("empresasId") String mailId) {
        System.out.println("Borrando Empresa Controller");
        empresasService.borrarEmpresa(mailId);
    }

    /*@PutMapping("/{mail}")
    public void modificarDatoEmpresa(@PathVariable("mail") String mailId, String nombre, String contrasena) throws EmpresaNoExiste {
        empresasService.actualizarDatosEmpresa(mailId, nombre, contrasena);
    }*/

    @PutMapping(path = "/actualizar/{mailEmpresa}")
    public void actualizarEmpresa(@PathVariable("mailEmpresa") String mailEmpresa, @RequestBody Empresas empresa) {
        empresasService.actualizarEmpresa(mailEmpresa,empresa);
    }
}
