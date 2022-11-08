package gym.gymServer.Controller;

import gym.gymServer.Classes.Actividad;
import gym.gymServer.Classes.CentrosDeportivos;
import gym.gymServer.Classes.Empleado;
import gym.gymServer.Service.EmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping (path = "/api/usuarios")
public class EmpleadoController {

    @Autowired
    private EmpleadoService empleadoService;

    public EmpleadoController() {}

    @PostMapping
    public void registrarEmpleado (@RequestBody Empleado empleado) throws Exception {
        empleadoService.registrarEmpleado(empleado);
    }

    @GetMapping("/allEmpleados")
    public List<Empleado> todosLosEmpleados () {
        return empleadoService.todosLosEmpleados();
    }

    @GetMapping("/empleadoMail/{mail}")
    public Empleado getEmpleado(@PathVariable("mail") String mail){
        return empleadoService.getEmpleado(mail);
    }

    @GetMapping("/similarEmpleado/{like}")
    public List<Empleado> getEmpleadosLike(@PathVariable("like") String search) {
        return empleadoService.getEmpleadosLike(search);
    }

    @GetMapping("/empleadosEmpresa/{mailEmpresa}")
    public List<Empleado> getEmpleadosByEmpresa(@PathVariable("mailEmpresa") String mail) {
        return empleadoService.getEmpleadosByEmpresa(mail);
    }

    @DeleteMapping(path = "/deleteEmpleado/{mailEmpleado}")
    public void deleteEmpleado(@PathVariable("mailEmpleado") String mail) {
        empleadoService.deleteEmpleado(mail);
    }

}
